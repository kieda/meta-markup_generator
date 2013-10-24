package mmg.compiler.parser;

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
    public static LinkedList<CharSequence> patternModify(CharSequence java){
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
    /**
     * if we have a single word, then we return the single word. Otherwise,
     * we modify the java block
     * requires: java is either a single word, or is (~ ... ~)
     * ensures: result will compile iff java is correctly made
     */
    public static CharSequence modify(CharSequence java){
        
        return java;
    }
    
    private static final Pattern SPLITTER = Pattern.compile("#[0-9]*", Pattern.DOTALL|Pattern.MULTILINE);
}
