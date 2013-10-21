/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.exception;

/**
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
