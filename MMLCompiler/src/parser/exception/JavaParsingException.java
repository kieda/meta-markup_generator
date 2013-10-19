/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.exception;

/**
 *
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
