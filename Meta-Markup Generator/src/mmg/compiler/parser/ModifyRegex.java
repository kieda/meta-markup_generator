package mmg.compiler.parser;

import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import mmg.util.strings.StringUtil;

/**
 * @author zkieda
 */
public class ModifyRegex {
    private ModifyRegex(){}
    private static Pattern matchSpecial = Pattern.compile("\\\\/");
    private static final CharSequence slash = "/";
    
    /**
     * replaces all instances of 
     *       \/
     * in a charsequence with
     * 
     *       /
     */
    public static CharSequence modify(CharSequence regex){
        Matcher m = matchSpecial.matcher(regex);
        LinkedList<CharSequence> output = new LinkedList<>();
        
        int prev = 0;
        while(m.find()){
            output.add(regex.subSequence(prev, m.start()));
            output.add(slash);
            
            prev = m.end();
        }
        output.add(regex.subSequence(prev, regex.length()));
        
        return StringUtil.flatten(output);
    }
}
