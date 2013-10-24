package mmg.compiler.parser.exception;

/**
 * represents an exception in parsing the java that is embedded in an 
 * mml script
 * @author zkieda
 */
public class JavaParsingException extends MMLParsingException {

    /**
     * Creates a new instance of
     * <code>JavaParsingException</code> without detail message.
     */
    public JavaParsingException() {
    }

    /**
     * Constructs an instance of
     * <code>JavaParsingException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public JavaParsingException(String msg) {
        super(msg);
    }
}
