package parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import parser.exception.RegexParsingException;
import strings.StringUtil;

/**
 * finds $ if it's in a block of java syntax, not in a comment, and not if it's
 * in a string or char.
 * @author zkieda
 */
public class FindDollar {
    private FindDollar(){}
    
    //line comment : //[^\n\\\r]*
    //block comment : /\\*.*?\\*/|/\\*.*
    //dolla : \\$
    //strings : \".*?([^\\\\]\"|$)
    //chars \'.*?([^\\\\]\'|$)
    private static final Pattern FIND_DOLLAS = Pattern.compile(
                ".*?((\\$)|(\'.*?([^\\\\]\'|$))|(//[^\n\\\r]*)|(/\\*.*?\\*/|/\\*.*)|(\".*?([^\\\\]\"|$)))",
                Pattern.MULTILINE|Pattern.DOTALL);
    
    /**
     * check yourself before you shrek yourself
     */
    public static void check(CharSequence java){
        Matcher m = FIND_DOLLAS.matcher(java);

        int s;
        while(m.find()) if((s=m.start(2))!=-1)//the second grouping matches dolla, which is not what we want
            throw new RegexParsingException(
                    String.format(errMess, StringUtil.getLineNum(java, s), StringUtil.grabLineOf(java, s))
                    );
    }
    
    
    private static final String errMess = "Cannot have a $ sign in mml java syntax outside of comments, strings, or chars.\n    At line:\t%d\n    In syntax:\t%s\n";

    
//    public static void main(String[] args) {//test
//        check(
//                new SharedChars(
//                "{\"asdf$asdf\" as//df\n'$ '$ k '$' 'a$a'} /* $ */ //$\n//$".toCharArray()).getChars()
//                );//should throw an error
////        System.out.println(grabLineOf("asgdjkasdf\ndsdfasdfhkjasdf\nsdfhjasd", 17));
//    }
}
