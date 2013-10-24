package mmg.compiler.parser.exception;

/**
 * represents an exception while parsing an mml file
 * 
 * @author zkieda
 */
public class MMLParsingException extends RuntimeException {

    /**
     * Creates a new instance of
     * <code>MMLParsingException</code> without detail message.
     */
    public MMLParsingException() {
    }

    /**
     * Constructs an instance of
     * <code>MMLParsingException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public MMLParsingException(String msg) {
        super(msg);
    }
}
