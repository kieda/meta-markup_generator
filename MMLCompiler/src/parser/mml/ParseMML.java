package parser.mml;

import compl.MMLObject;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * generates an MMLObject from a CharSequence mml script.
 * @author zkieda
 */
public class ParseMML extends MMLObject {
    private static final Pattern MML = Pattern.compile("", Pattern.COMMENTS|Pattern.DOTALL);
    public ParseMML(CharSequence cs){
//            (~      ~)
//            (`      `)  
//            (\      \)  
//        #1 #2 etc...
        
        Matcher m = MML.matcher(cs);
        
    }
}
