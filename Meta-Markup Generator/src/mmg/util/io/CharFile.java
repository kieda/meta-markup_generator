package mmg.util.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import mmg.util.strings.SharedChars;

/**
 * a SharedChars charsequence that is instantiated by opening a file.
 * 
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
     * generates a sharedchars object from a file path
     * 
     * requires path.isFile()
     * 
     * throws IllegalArgumentException if path is null, or if path is invalid 
     * or unreadable.
     */
    public CharFile(File path) {
        super(getChars(path));
    }
    
    public static void main(String[] args) {
        System.out.println(new CharFile(new File("./src/io/CharFile.java")).getChars());
    }
}
