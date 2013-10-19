package compl;

import args.Flags;
import gen.JavaGen;
import io.SaveFile;
import java.io.File;
import java.util.regex.Pattern;
import jcompile.InMemoryCompile;

/**
 * used as a front for compiling things nicely
 * @author zkieda
 */
public class CompileJava {
    private CompileJava(){}
    public static void compile(JavaGen jclass, CompileArgs args) {
        if(args.classname!=null) jclass.setClassName(args.classname);
        
        File path = new File(args.path==null?"./":args.path);
        
        assert path.isDirectory();
        
        CharSequence chars = jclass.toCharSequence();
        
        if(args.flag(CompileArgs.SAVE_SOURCE))
            SaveFile.save(new File(path, jclass.getClassName()+".java"), chars);
        if(args.flag(CompileArgs.IN_MEMORY_COMPILE)){
            try {
                InMemoryCompile.compile(jclass.getFullName(), chars);
            } catch (Exception e) {e.printStackTrace();}
        }else{
            throw new UnsupportedOperationException("todo");
        }
    }
    
    /**
     * call Args.parse to parse Args in the standard format.
     * 
     * requires: classname is valid, path is valid
     * ensures: path exists
     */
    public static class CompileArgs implements Flags{
        public static final byte IN_MEMORY_COMPILE = 1;
        public static final byte SAVE_SOURCE = 2;
        
        public final byte flags;
        public final String classname;
        public final String path;
        
        /**
         * classname, path may be null.
         */
        public CompileArgs(byte flags, String classname, String path){
            checkArgs(classname, path);
            this.flags = flags;
            this.classname = classname;
            this.path = path;
        }
        public boolean flag(int pos){return (flags&pos)!=0;}
        
        
        private static byte findFlags(String[] args){
            final String err1 = " cannot be at the end of args, since it requires an extra argument";
                //we allocate this here since we will only use findFlags once
                //per compile.
            
            byte ret = 0b0;
            
            String clsName = null, path=null;
            
            //we use the most recent class name or save path. Since both the
            //save path and the class name require at least two arguments, and
            //to read a save path or a class name we would have read at least 
            //two args, we may place the class name at args[0] and place the
            //class path at args[1].
            
            //for any updates, ensure that this still holds, or code a better 
            //system.

            //ghetto but ok for now...
            for(int pos = 0; pos<args.length;pos++){
                switch(args[pos]){
                    case FLAG_SAVE_SOURCE: ret |= SAVE_SOURCE; break;
                    case FLAG_IN_MEMORY_COMPILE: ret |= IN_MEMORY_COMPILE; break;
                    case FLAG_SET_CLASS_NAME: 
                            if(++pos<args.length){
                                clsName = args[pos];
                            }else
                                throw new InvalidArgsException(FLAG_SET_CLASS_NAME+err1);
                        break;
                    case FLAG_SAVE_PATH: 
                            if(++pos<args.length){
                                path = args[pos];
                            }else
                                throw new InvalidArgsException(FLAG_SAVE_PATH+err1);
                        break;
                    default:
                        throw new InvalidArgsException("flag not recognized : "+args[pos]);
                }
            }
            args[0] = clsName;
            args[1] = path;
            
            return ret;
        }
        
        //ensures: exception iff arg0 is an invalid java class name type, 
        //         or arg1 is an invalid class path. If arg1 is non-null and is
        //         a valid directory, then the directory is created. 
        private static void checkArgs(String arg0, String arg1) {
            //correct java class starts with [a-zA-Z_] and is followed 
            //by a sequence of [a-zA-Z0-9_]. We do not allow $, since we use it
            //for system variables in dynamic compilation.
            if(arg0 != null && !Pattern.compile("[a-zA-Z_][a-zA-Z0-9_]*").matcher(arg0).matches())
                throw new InvalidArgsException("class "+arg0+" is an invalid class name.");
            if(arg1 != null && !(new File(arg1).mkdirs()))
                throw new InvalidArgsException(arg1+" is an invalid path.");
        }
        
        /**
         * Flags : -s               saves the source file
         *         -m               saves the class in memory, rather than compiling it
         *         -c <name>        sets the class name 
         *         -p <path>        sets the save path
         * Throws: InvalidArgsException if the args are not in a proper format,
         * i.e. -c and -p cannot be at the end, and there can not be any unknown
         * args, and the paths and names must be correct
         */
        public static CompileArgs compile(String[] args){
            byte res = findFlags(args);
            if(args.length>=2){
                checkArgs(args[0], args[1]);
                return new CompileArgs(res, args[0], args[1]);
            }else return new CompileArgs(res, null, null);
                //we couldn't have possibly set a path or a name with one flag.
        }
    }
}
