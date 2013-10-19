package io;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author zkieda
 */
public class SaveFile {
    private SaveFile(){}
    
    /**
     * requires : file's parent exists. 
     */
    public static void save(File file, CharSequence args){
        try {
            FileWriter fw = new FileWriter(file);
            for(int i=0;i<args.length();i++){
                fw.append(args.charAt(i));
            }
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
