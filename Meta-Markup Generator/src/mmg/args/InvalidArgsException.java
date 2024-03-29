package mmg.args;

/**
 * Thrown to indicate that there is an error in the args being parsed.
 * @author zkieda
 */
public class InvalidArgsException extends IllegalArgumentException {
    /**
     * Creates a new instance of
     * <code>InvalidArgsException</code> without detail message.
     */
    public InvalidArgsException() {
    }

    /**
     * Constructs an instance of
     * <code>InvalidArgsException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public InvalidArgsException(String msg) {
        super(msg);
    }
}
