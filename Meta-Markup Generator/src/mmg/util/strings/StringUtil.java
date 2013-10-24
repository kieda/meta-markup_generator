/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmg.util.strings;

import java.io.IOException;
import java.io.OutputStream;
import java.util.LinkedList;

/**
 *
 * @author zkieda
 */
public class StringUtil {
    //the line number, starts at 1.
    public static int getLineNum(CharSequence s, int idx) {
        int lines = 0;
        
        char c;
        
        while(idx!=-1){
            do{idx--;}while(idx!=-1&&(c=s.charAt(idx))!='\n'&&c!='\r');
            lines++;
        }
        
        return lines;
    }
    
    //gets the entire line from a certain index
    public static CharSequence grabLineOf(CharSequence s, int idx) {
        //idx is our lower bound.
        
        char c;
        int upper=idx;
        
        //calculate lower bound
        while(idx!=-1&&(c=s.charAt(idx))!='\n'&&c!='\r'){idx--;}
        
        idx++;
        
        while(upper!=s.length()&&(c=s.charAt(upper))!='\n'&&c!='\r'){upper++;}
        
        return s.subSequence(idx, upper);
    }
    
    //flattens a string list out
    public static CharSequence flatten(LinkedList<CharSequence> strs) {
        int len = 0;
        for(CharSequence s: strs){len+=s.length();}
        
        char[] ret = new char[len];
        len = 0;
        int k;
        for(CharSequence s: strs){
            for(k=0;k<s.length();k++){
                ret[len++]=s.charAt(k);
            }
        }
        
        return new SharedChars(ret).getChars();
    }
    
    //writes a string list to the stream as if it were flattened.
    public static void write(LinkedList<String> strs, OutputStream os) throws IOException{
        try {
            for(String s : strs) os.write(s.getBytes());
        } finally {os.close();}
    }
    
    public static String[] filterNull(String[] items){
        int i=0;
        for(String e : items){ if(e==null)i++;}
        String[] s = new String[items.length-i];
        
        String g;int c=0;
        for(i=0;i<items.length;i++){
            if((g=items[i])!=null)s[c++]=g;
        }
        return s;
    }
    
    //throws nullpointer exception if seq is null
    public static char[] toCharArray(CharSequence seq) {
        char[] c = new char[seq.length()];
        for(int i=0;i<c.length;i++){
            c[i] = seq.charAt(i);
        }
        return c;
    }
//    public static void main(String[] args) throws IOException{
//        
////        System.out.println(Arrays.toString(filterNull(new String[]{"asdf", null, "asdfa", "a123", null, null})));
//        
////        LinkedList<CharSequence> s =new LinkedList<>();
////        s.add("asdf");
////        s.add("1234");
////        s.add("qwer");
//////        write(s, new FileOutputStream("./src/test/asdf.tes"));
////        System.out.println(flatten((LinkedList<CharSequence>)s));
//    }
}

