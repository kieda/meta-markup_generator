package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;

/**
 *
 * @author zkieda
 */
public class SerTest {
    private static void writeto(String s) throws Exception{
        SerialiableRunnable r = new SerialiableRunnable() {
            @Override
            public void run() {
                System.out.println("shat");
        }};
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(s));
        oos.writeObject(r);
        oos.close();
    }
    private static void read(String s) throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(s));
        Runnable r = ((Runnable)ois.readObject());
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
        new Thread(r).start();
    }
    
    public static void main(String[] args) throws Exception{
        writeto("./src/test/asdf.run");
        read("./src/test/asdf.run");
        
//        OutputStreamWriter oow = new OutputStreamWriter();
    }
}
