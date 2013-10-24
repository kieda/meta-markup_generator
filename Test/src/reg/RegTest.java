/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reg;

import mmg.util.io.CharFile;
import java.io.File;
import java.math.MathContext;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author zkieda
 */
public class RegTest {
    private static LinkedList<CharSequence> extract(CharSequence cs, Matcher m) {
        LinkedList<CharSequence> chars = new LinkedList<>();
        
        int prev = 0;
        while(m.find()){
            chars.add(cs.subSequence(prev, m.start()));
            prev = m.end();
//            System.out.println(m.group());
        }
        chars.add(cs.subSequence(prev, cs.length()));
        
        return chars;
    }
    
//    private static Pattern OPEN_JAVA = Pattern.compile("\\(~");
//    private static Pattern CLOSE_JAVA = Pattern.compile("~\\)");
//    
//    private static Pattern REGEX = Pattern.compile("/");
//    private static Pattern IGNORE_REGEX = Pattern.compile("\\/");
//    
//    private static Pattern OPEN_KV = Pattern.compile("{");
//    private static Pattern CLOSE_KV = Pattern.compile("}");
//    private static Pattern IGNORE_BEGIN_KV = OPEN_JAVA;
//    private static Pattern IGNORE_END_KV = CLOSE_JAVA;
    
    public static void main(String[] args) {
        CharSequence cs = new CharFile(new File("./asdf.mml")).getChars();
//        Matcher m = Pattern.compile("(``[^\\n\\\\\\r]*)").matcher(cs);
//        Pattern ENDS = Pattern.compile("(``)|(\\(~)|(~\\))|(\\{)|(\\})|(/)|(\")|(')|(/\\*)|(\\*/)|(//)");
//        Pattern ENDS = Pattern.compile("|(\")|(')|(/\\*)|(\\*/)|(//)");
//        Pattern S0 = Pattern.compile("(``)|(\\(~)|(~\\))|(\\{)|(\\})|(/)|(;)|([a-zA-Z_][a-zA-Z_0-9]*)");
        
//        int state=0;//base
//        
//        Pattern S[] = new Pattern[]{
//            Pattern.compile("([\\n\\\\\\r])"),//0 : new line
//            Pattern.compile("(~\\))|(\")|(')"),//1 : end java
//        };
        new Parse(cs);
    }
        private static class Parse{
            private LinkedList<CharSequence> parsed = new LinkedList<>();
            public Parse(CharSequence in){
                final int i =Pattern.MULTILINE|Pattern.DOTALL;
                final Pattern newline = Pattern.compile("($)",i);
                
final MatchType CLOSE_JAVA = new MatchType(Pattern.compile("(~\\))|(\")|(')|(//)|(/\\*)",i), 
new MatchType[]{
    //case ~)
    null,
    //case "
    new MatchType(Pattern.compile("(\")|([\\n][\\\r])|($)",i), new MatchType[]{null, FAIL, FAIL}),
    //case '
    new MatchType(Pattern.compile("(')|([\\n][\\\r])|($)",i), new MatchType[]{null, FAIL, FAIL}),
    //case //
    new MatchType(newline, new MatchType[]{ null}),
    //case /*
    new MatchType(Pattern.compile("(\\*/)|($)",i), new MatchType[]{null, FAIL}),
}
);

MatchType KEYVAL=null;

parse(Pattern.compile("").matcher(in), 
new MatchType(
    Pattern.compile("(``)|(\\(~)|(~\\))|(\\{)|(\\})|(/)|(;)|([a-zA-Z_][a-zA-Z_0-9]*)"),
    new MatchType[]{
        //case ``
        new MatchType(newline, new MatchType[]{
            null,//case new line
        }),
        
        //case (~
        CLOSE_JAVA,
        
        //case ~)
        FAIL,
        
        //case {
        (KEYVAL=new MatchType(Pattern.compile("([a-zA-Z_][a-zA-Z_0-9]*)|(\\})",i),
            new MatchType[]{
                
            //case word
            new MatchType(Pattern.compile("(:)"), 
                new MatchType[]{
                    //case :
                    new MatchType(Pattern.compile("(\\(~)|([a-zA-Z_][a-zA-Z_0-9]*)"),
                        new MatchType[]{
                            //case (~
                            CLOSE_JAVA,
                            //case word
                            KEYVAL
                        }
                )}),
            
            //case }
            null}
        )),
        
        //case }
        FAIL,
        
        //case /
        new MatchType(Pattern.compile("(.*?[^\\\\]/|($))",i), new MatchType[]{
            //case /
            null,
            //case end of line
            FAIL}),
        
        //case ;
        null,
        
        //case word
        null
    }
),
null);
            }
//            private MatchType matches;
            
            private void parse(Matcher m, MatchType mt, LinkedList<CharSequence> parsed){
                if(mt==FAIL){throw new Error("");}
                if(mt==null){
                    return;
                }
//                System.out.println(mt.pat);
                m.usePattern(mt.pat);
                System.out.println(m.find() + m.group());
                for(int i = 1; i <= m.groupCount();i++){
                    if(m.start(i)!=-1){
                        System.out.println(i + " "+ mt.pat);
//                        MatchType temp = matches;
//                        matches = matches.next[i-1];
                        parse(m,mt.next[i-1], parsed);
                    }
                }
            }
            private final static MatchType FAIL = new MatchType(null, null);
            static class MatchType{
                public MatchType(Pattern p, MatchType[] next){
                    this.next = next;
                    this.pat = p;
                }
                MatchType[] next;
                Pattern pat;
            }
        }
        
//       
//        LinkedList<CharSequence> c = extract(cs, m);
//        
//        m = Pattern.compile("[^;]*;").matcher(cs);
//        
//        
////        System.out.println();
//        
        
//    }
}
