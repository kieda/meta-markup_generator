package mmg.compiler.parser.mml;

import mmg.compiler.compilation.MMLObject;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * generates an MMLObject from a CharSequence mml script.
 * @author zkieda
 */
public class ParseMML extends MMLObject {
    private static LinkedList<Info> info = new LinkedList<>();
    
    private static final Pattern MML = Pattern.compile(
              "[#$a-zA-Z_][#$a-zA-Z_0-9]*"//single word
            + "(``[^\\n\\\\\\r]*)"//comment
            + "\\(~.*?~\\)|\\(~.*"//java block
            + "/.*?([^\\\\]/|$)"//regex
            + ";"//semicolon
            + ";"//keyvalue
            + "\\s*"//whitespace
            
            , Pattern.MULTILINE|Pattern.DOTALL);
    public ParseMML(CharSequence cs){
//            (~      ~)
//            (`      `)  
//            (\      \)  
//        #1 #2 etc...
        
        Matcher m = MML.matcher(cs);
        
        
    }
    
}
class Info{
    byte type;
    CharSequence text;
}
