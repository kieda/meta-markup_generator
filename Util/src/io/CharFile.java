package io;

import java.io.File;
import java.io.FileReader;
import strings.SharedChars;

/**
 * @author zkieda
 */
public class CharFile extends SharedChars{
    /**
     * requires path.isFile()
     */
    private static char[] getChars(File path){
        try {
            char[] ret = new char[(int)path.length()];
            FileReader r = new FileReader(path);
            r.read(ret);
            r.close();
            return ret;
        } catch (Exception e) {
            throw new IllegalArgumentException(path + " is not a file, or is invalid.");
        }
    }
    
    /**
     * requires path.isFile()
     */
    public CharFile(File path) {
        super(getChars(path));
    }
    
    public static void main(String[] args) {
        System.out.println(new CharFile(new File("./src/io/CharFile.java")).getChars());
    }
}
