/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.exception;

/**
 *
 * @author zkieda
 */
public class MMLParsingException extends Error {

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
