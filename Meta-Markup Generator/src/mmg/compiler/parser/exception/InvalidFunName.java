package mmg.compiler.parser.exception;

/**
 * When an mml script attempts to use a function that does not exist or is
 * invalid.
 * 
 * @author zkieda
 */
public class InvalidFunName extends MMLParsingException {

    /**
     * Creates a new instance of
     * <code>InvalidFunName</code> without detail message.
     */
    public InvalidFunName() {
    }

    /**
     * Constructs an instance of
     * <code>InvalidFunName</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidFunName(String msg) {
        super("invalid function name : "+msg);
    }
}
