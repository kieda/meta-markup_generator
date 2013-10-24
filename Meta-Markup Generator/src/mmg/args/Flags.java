package mmg.args;

/**
 * The various compilation flag arguments that can be passed into 
 * mml.drivers.Main. Currently, we control the input source, the compilation 
 * type, whether or not we should save the java class, and even the name of the
 * class. 
 * 
 * A flag that takes arguments is followed by the argument, i.e. we specify the
 * class name by 
 *     -s HelloWorld -i "./src/compl/HelloLang.mml"
 * 
 * which sets the generated java's class name to "HelloWorld". Note that these
 * arguments are in the form String[], since we pass them to 
 * mml.drivers.Main.main(String[] args)
 * 
 * so, the example above should look like 
 * 
 *      String[]{"-s", "HelloWorld", "-i", "./src/compl/HelloLang.mml"}
 * 
 * @author zkieda
 */
public interface Flags {
    /**
     * when the -s flag is enabled, we save the source code after it has been
     * generated.
     */
    public static final String FLAG_SAVE_SOURCE = "-s";
    
    /**
     * when the -m flag is specified, we compile the java class in memory, 
     * rather than generating a java .class file.
     */
    public static final String FLAG_IN_MEMORY_COMPILE = "-m";
    
    
    /**
     * the -c flag specifies the java class name that should be used. The -c 
     * flag takes one argument, the name of the java class that should be used.
     */
    public static final String FLAG_SET_CLASS_NAME = "-c";
    
    /**
     * the -p flag specifies the path where the compiled class and saved source
     * file should be saved. This flag takes one argument, the file path that
     * should be used.
     */
    public static final String FLAG_SAVE_PATH = "-p";
    
    /**
     * the -i flag specifies the path to the mml script that will be compiled.
     * The -i flag takes one argument, the path to the input script.
     */
    public static final String FLAG_INPUT = "-i";
    
    
    /*
     * to implement : FLAG_SCRIPT = "-I"
     * 
     * the flag takes the actual script source of an mml file. This will
     * allow other programs to conveniently pass a string to compile an mml
     * script without having the script saved in a file.
     * 
     * for now : call mmg.compiler.compilation.CompileJava.compile
     * 
     * you may specify the args in mmg.compiler.compilation.CompileJava.
     * CompileArgs
     */
}
