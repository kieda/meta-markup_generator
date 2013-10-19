package args;

import static args.Flags.FLAG_SAVE_PATH;
import compl.InvalidArgsException;
import java.io.File;

/**
 * parses args dealing with where the source script comes from.
 * args dealing with the methods of compilation itself is handled later.
 * 
 * @author zkieda
 */
public class Args implements Flags{
    /**
     * finds the location of the input script
     */
    public static String parse(String[] args){
        final String err1 = " cannot be at the end of args, since it requires an extra argument";
        String source=null;
        
        for(int i=0;i<args.length;i++){
            if(args[i].equals(FLAG_INPUT)){
                if(++i<args.length){
                    source = args[i];
                    args[i-1]=args[i]=null;
                }else{
                    throw new InvalidArgsException(FLAG_INPUT+err1);
                }
            }
        }
        return source;
    }
}
