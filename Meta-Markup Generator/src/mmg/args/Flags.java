package mmg.args;

/**
 * @author zkieda
 */
public interface Flags {
    //default flags
    public static final String FLAG_SAVE_SOURCE = "-s";
    public static final String FLAG_IN_MEMORY_COMPILE = "-m";
    
    //takes 1 arg, the name of the java class
    public static final String FLAG_SET_CLASS_NAME = "-c";
    //takes 1 arg, the path the class should be saved
    public static final String FLAG_SAVE_PATH = "-p";
    
    //takes 1 arg, the input script path
    public static final String FLAG_INPUT = "-i";
}
