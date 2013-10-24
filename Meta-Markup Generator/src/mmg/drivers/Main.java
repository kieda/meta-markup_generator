package mmg.drivers;

import mmg.compiler.compilation.CompileJava;
import mmg.compiler.compilation.MMLJavaClass;
import mmg.args.InputArgs;
import mmg.args.InvalidArgsException;
import mmg.util.io.CharFile;
import java.io.File;
import mmg.compiler.parser.mml.ParseMML;
import mmg.util.strings.StringUtil;

/**
 * where the program actually starts
 * @author zkieda
 */
public class Main {
    
    /**
     * Flags : -s               saves the source file
     *         -m               saves the class in memory, rather than compiling it
     *         -c <name>        sets the class name 
     *         -p <path>        sets the save path
     *         -i <path>        sets the input path for the mml script
     * 
     * Throws: InvalidArgsException if the args are not in a proper format,
     * i.e. -c, -i and -p cannot be at the end, and there can not be any unknown
     * args, and the paths and names must be correct.
     * 
     * The -i flag must be specified.
     */
    public static void main(String[] args) {
        File input;
        
        {
        String path = InputArgs.parse(args);
        
        if(path==null) throw new InvalidArgsException("no input script.");
        else if((input = new File(path)).isFile())
            throw new InvalidArgsException(path+" is an invalid input path. It is either a directory or does not exist.");
        }
        
        //create args from the filtered ones.
        CompileJava.CompileArgs parsedArgs = CompileJava.CompileArgs.compile(StringUtil.filterNull(args));
        
        //get the file path, turn it into a character representation, parse it as MML, send the MML to a java representation, and compile it with the given args.
        CompileJava.compile(new MMLJavaClass(new ParseMML(new CharFile(input).getChars())), parsedArgs);
    }
}
