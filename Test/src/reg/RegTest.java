/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package reg;

import io.CharFile;
import java.io.File;
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
        Pattern ENDS = Pattern.compile("(``)|(\\(~)|(~\\))|(\\{)|(\\})|(/)|(\")|(')|(/\\*)|(\\*/)|(//)");
        Matcher m = ENDS.matcher(cs);
        int g = m.groupCount();
        
        int state=0;//base

        while(m.find()){
//            for(int i = 1; i <= g; i++){
            if(m.start(1)!=-1){//comment
                if(j==0){
                    //find till the end of the line/file
                }
            } else if(m.start(2)!=-1){//java begin
                j++;
            } else if(m.start(3)!=-1){//java end
                j--;
            } else if(m.start(4)!=-1){//keyvalue begin
            } else if(m.start(5)!=-1){//keyvalue end
            } else if(m.start(6)!=-1){//string begin
            } else if(m.start(7)!=-1){//quote begin
            } else if(m.start(7)!=-1){//java comment block begin
            } else if(m.start(7)!=-1){//java comment block end
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
        
    }
}
