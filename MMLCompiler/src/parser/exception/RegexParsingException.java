/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.exception;

/**
 *
 * @author zkieda
 */
public class RegexParsingException extends MMLParsingException {

    /**
     * Creates a new instance of
     * <code>RegexParsingException</code> without detail message.
     */
    public RegexParsingException() {
    }

    /**
     * Constructs an instance of
     * <code>RegexParsingException</code> with the specified detail message.
     *
     * @param msg the detail message.
     */
    public RegexParsingException(String msg) {
        super(msg);
    }
}
