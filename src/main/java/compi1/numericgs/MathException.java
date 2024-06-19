/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Exception.java to edit this template
 */
package compi1.numericgs;

/**
 *
 * @author yennifer
 */
public class MathException extends Exception{

    /**
     * Creates a new instance of <code>MathException</code> without detail
     * message.
     */
    public MathException() {
    }

    /**
     * Constructs an instance of <code>MathException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public MathException(String msg) {
        super(msg);
    }
}
