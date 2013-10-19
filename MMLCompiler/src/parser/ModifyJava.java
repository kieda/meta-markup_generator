package parser;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zkieda
 */
public class ModifyJava {
    private ModifyJava(){}

    /**
     * suppose we had some string A#nB where A is a sequence of characters, B is 
     * some sequence of characters, and n is a sequence of digits. Then, we 
     * split the class into 
     * 
     *      A ---> n ---> B
     * 
     * in the returned linked list. 
     * 
     * If # does not have a number following it, we split it into 
     * 
     *      A ---> "" ---> B
     * 
     * This will replace characters in comments, strings, characters and body 
     * syntax.
     * 
     * The syntax alternates from the original strings and the numbers, and will
     * always start and end with a string.
     */
    public static LinkedList<CharSequence> modify(CharSequence java){
        LinkedList<CharSequence> chas = new LinkedList<>();
        Matcher m = SPLITTER.matcher(java);
        int prev = 0;
        
        while(m.find()){
            chas.add(java.subSequence(prev, m.start()));
            chas.add(m.group().substring(1));
            prev = m.end();
        }
        
        chas.add(java.subSequence(prev, java.length()));
        
        return chas;
    }
    
    private static final Pattern SPLITTER = Pattern.compile("#[0-9]*", Pattern.DOTALL|Pattern.MULTILINE);
    
//    public static void main(String[] args) {//test
//        System.out.println(modify("#"));
//        System.out.println(modify("asd#1asdf##34"));
//        System.out.println(modify("asd#1asdf##34as"));
//    }
}
