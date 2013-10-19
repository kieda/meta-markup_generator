/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author zkieda
 */
public interface SerialiableRunnable extends Runnable, Serializable{
//    private void writeObject(ObjectOutputStream out) throws IOException {
//        out.defaultWriteObject();
//    }
//    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
//        in.defaultReadObject();
//    }
}
