package mmg.compiler.compilation;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import mmg.compiler.parser.ModifyRegex;
import mmg.util.strings.SharedChars;
import mmg.util.strings.StringUtil;

/**
 * @author zkieda
 */
public class MMLObject {
    public int version;
    
    private final Set<Integer> flags = new HashSet<>(8);
    
    public void setFlag(int i){flags.add(i);}
    public boolean hasFlag(int i){return flags.contains(i);}

    private List<CharSequence> header = new LinkedList<>();
    private List<CharSequence> classDef = new LinkedList<>();
    private List<CharSequence> local = new LinkedList<>();
    
    private CharSequence className;
    private CharSequence extend;
    private CharSequence implement;
    private CharSequence params;
    
    public MMLObject addHeader(CharSequence a){
        header.add(a);return this;
    }
    public MMLObject addClassDef(CharSequence a){
        classDef.add(a);
        return this;
    }
    public MMLObject addLocal(CharSequence a){
        local.add(a);
        return this;
    }
    
    public MMLObject setClassName(CharSequence a){
        this.className=a;return this;
    }
    public MMLObject setExtend(CharSequence a){
        this.extend=a;return this;
    }
    public MMLObject setImplement(CharSequence a){
        this.implement=a;return this;
    }
    public MMLObject setParams(CharSequence a){
        this.params=a;
        return this;
    }
    
    
//    //local
//    //header
//    //classDef
//    
//    //serialize
//    //objectOf
//    //classOf
//    //customClass
//    
//    public class Tag{
//        public List<CharSequence> in;//charsequence tag that is the input
//        public Regex regex;
//        public List<CharSequence> out;//our output char sequence tag
//    }
//    public class Parse{
//        public List<CharSequence> in;//charsequence tag that is the input
//        public Regex regex;
//        public List<CharSequence> java;//our java code, broken up for every capture group split
//    }
//    public class Map{
//        public List<CharSequence> in;//charsequence tag that is the input
//        public CharSequence java;
//        public List<CharSequence> out;//our output char sequence tag
//    }
//    public class Regex extends SharedChars{
//        public Regex(CharSequence regexbase){
//            super(StringUtil.toCharArray(ModifyRegex.modify(regexbase)));
//        }
//    }
}
