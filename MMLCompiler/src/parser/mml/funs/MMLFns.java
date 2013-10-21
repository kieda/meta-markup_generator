package parser.mml.funs;

import compl.MMLObject;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import parser.ModifyJava;
import parser.exception.MMLParsingException;

/**
 * designs the specification for the MML.
 * 
 * Note: we will attempt to make this more expandable in the future (with 
 * variable and recursive types, method overloading, etc) but this is currently
 * the fastest to produce given this time frame.
 * 
 * (In fact, we could use the MML to produce a new MML 
 * 
 * all of the functions, except for serialize, objectOf, classOf, and customClass
 * define how syntax is set up within the parsing class itself.
 *  
 * The functions serialize, objectOf, classOf, and customClass define how syntax
 * is set up in the class our generated class generates.
 * 
 * @author zkieda
 */
public class MMLFns {
    private MMLFns(){}
    
    //a function from the name of the function to the function itself
    private static final Map<String, Fun> functionSpec = new HashMap<>();
    
    /**
     * defines syntax in the local function
     * 
     * function call : 
     *     local (JAVA) ;
     */
    public static final String FUN_local = "local";
    
    
    /**
     * defines what should go at the very top of the page.
     * 
     * If a package is desired, place it at the very top of the header.
     * 
     * function call :
     *     package (JAVA) ;
     */
    public static final String FUN_header = "header";
    
    /**
     * defines the class name. Default is $SCRIPT_NAME
     * 
     * function call : 
     *     class (JAVA) ;
     */
    public static final String FUN_class = "class";
    
    /**
     * defines which class this one should extend
     * 
     * extends (JAVA) ;
     */
    public static final String FUN_extends = "extends";
    
    /**
     * defines which interfaces this class should implement
     * 
     * function call : 
     *     implements (JAVA) ;
     */
    public static final String FUN_implements = "implements";
    
    /**
     * defines the input params. Do not surround with parentheses
     * 
     * function call : 
     *     params (JAVA) ;
     */
    public static final String FUN_params = "params";
    
    /**
     * define java syntax within the class itself.
     */
    public static final String FUN_classDef = "classDef";
    
    /**
     * defines parse in the classes main body. 
     * 
     * function call : 
     *     parse (INTEGER) (REGEXES) ;
     */
    public static final String FUN_parse = "parse";
    
    /**
     * defines the version of the MML, to avoid non-backwards compatable 
     * conflicts. Default : 0. 
     * 
     * function call : 
     *     version (INTEGER) ;
     */
    public static final String FUN_version = "version";
    
    /**
     * when this class is instantiated, we create a new object according 
     * to the specification and serialize it
     * 
     * function call : 
     *     serialize () ;
     */
    public static final String FUN_serialize = "serialize";
    
    /**
     * when this class is called, we create a new object according to the
     * specification
     * 
     * function call : 
     *     objectOf () ;
     */
    public static final String FUN_objectOf = "objectOf";

    /**
     * the class is generated according to specification
     * 
     * function call : 
     *     classOf () ;
     */
    public static final String FUN_classOf = "classOf";
    
    /**
     * the complete class is defined by the user
     * 
     * function call : 
     *     customClass (JAVA);
     */
    public static final String FUN_customClass = "customClass";
    
    /**
     * the complete class is defined by the user
     * 
     * function call : 
     *     customClass (JAVA) (JAVA) (JAVA);
     */
    public static final String FUN_map = "map";
    
    private static Pattern PAT_REGEX = Pattern.compile("/.*?([^\\\\]/|$)");
    private static Pattern PAT_JAVA = Pattern.compile("([a-zA-Z_][a-zA-Z_0-9]*)|(\\(~.*?~\\))");
    private static Pattern PAT_INTEGER = Pattern.compile("[0-9]+");

    private static final Fun LOCAL = new Fun(FUN_local) { 
        protected void init(List<Pattern> v){
            v.add(PAT_JAVA);
        } 
        protected void fun(List<CharSequence> params, MMLObject object) {
            object.addLocal(ModifyJava.modify(params.get(0)));
        }
    };
    private static final Fun HEADER = new Fun(FUN_header) {
        protected void init(List<Pattern> v){
            v.add(PAT_JAVA);
        } 
        protected void fun(List<CharSequence> params, MMLObject object) {
            object.addHeader(ModifyJava.modify(params.get(0)));
        }
    };
    private static final Fun CLASS = new Fun(FUN_class) {
        protected void init(List<Pattern> v){
            v.add(PAT_JAVA);
        } 
        protected void fun(List<CharSequence> params, MMLObject object) {
            object.setClassName(ModifyJava.modify(params.get(0)));
        }
    };
    private static final Fun EXTENDS = new Fun(FUN_extends) {
        protected void init(List<Pattern> v){v.add(PAT_JAVA);} 
        protected void fun(List<CharSequence> params, MMLObject object) {
            object.setExtend(ModifyJava.modify(params.get(0)));
        }
    };
    private static final Fun IMPLEMENTS = new Fun(FUN_implements) {
        protected void init(List<Pattern> v){v.add(PAT_JAVA);} 
        protected void fun(List<CharSequence> params, MMLObject object) {
            object.setImplement(ModifyJava.modify(params.get(0)));
        }
    };
    private static final Fun PARAMS = new Fun(FUN_params) {
        protected void init(List<Pattern> v){v.add(PAT_JAVA);} 
        protected void fun(List<CharSequence> params, MMLObject object) {
            object.setParams(ModifyJava.modify(params.get(0)));
        }
    };
    private static final Fun CLASSDEF = new Fun(FUN_classDef) {
        protected void init(List<Pattern> v){v.add(PAT_JAVA);} 
        protected void fun(List<CharSequence> params, MMLObject object) {
            object.addClassDef(ModifyJava.modify(params.get(0)));
        }
    };
    private static final Fun PARSE = new Fun(FUN_parse) {
        protected void init(List<Pattern> v){
            v.add(PAT_JAVA);
            v.add(PAT_REGEX);
            v.add(PAT_JAVA);
        } 
        protected void fun(List<CharSequence> params, MMLObject object) {
            
        }
    };
    private static final Fun VERSION = new Fun(FUN_version) {
        protected void init(List<Pattern> v){ v.add(PAT_INTEGER); } 
        protected void fun(List<CharSequence> params, MMLObject object) {
            object.version=Integer.parseInt(params.get(0).toString());
        }
    };
    private static final Fun SERIALIZE = new Fun(FUN_serialize) {
        protected void init(List<Pattern> v){
        } 
        protected void fun(List<CharSequence> params, MMLObject object) {
        }
    };
    private static final Fun OBJECTOF = new Fun(FUN_objectOf) {
        protected void init(List<Pattern> v){
        } 
        protected void fun(List<CharSequence> params, MMLObject object) {
        }
    };
    private static final Fun CLASSOF = new Fun(FUN_classOf) {
        protected void init(List<Pattern> v){
        }
        protected void fun(List<CharSequence> params, MMLObject object) {
        }
    };
    private static final Fun CUSTOMCLASS = new Fun(FUN_customClass) { 
        protected void init(List<Pattern> v){v.add(PAT_JAVA);} 
        protected void fun(List<CharSequence> params, MMLObject object) {
        }
    };
    
    private static final Fun MAP = new Fun(FUN_map) {
        protected void init(List<Pattern> v){
            //map JAVA JAVA JAVA
            v.add(PAT_JAVA);
            v.add(PAT_JAVA);
            v.add(PAT_JAVA);//need 3 java patterns.
        } 
        protected void fun(List<CharSequence> params, MMLObject object) {
            if(!object.hasFlag(0)) {//add dependancy
                object.setFlag(0);
                object.addClassDef(SMAP[0]);
            }
            Iterator<CharSequence> c;
            (c = params.iterator()).next();//first is the name
            object.addLocal(SMAP[1])
                  .addLocal(ModifyJava.modify(c.next()))//todo -- convert java to parsed java
                  .addLocal(COMMA)
                  .addLocal(SMAP[2])
                  .addLocal(ModifyJava.modify(c.next()))//todo -- convert java to parsed java
                  .addLocal(SMAP[3]);
        }
    };
    private static final CharSequence SMAP[] = new CharSequence[]{
          "private static interface CharParse${CharSequence $parse(CharSequence elem);} public static LinkedList<CharSequence> $map(LinkedList<CharSequence> i, CharParse$ p){LinkedList<CharSequence> dup = new LinkedList<>();for(CharSequence elem : i) dup.add(p.$parse(elem));return dup;}"
        , "$map("
        , "new CharParse$(){public CharSequence $parse(CharSequence elem){"
        , "});"
    };
    private static final CharSequence COMMA = String.valueOf(',');
    static{
        functionSpec.put(FUN_local, LOCAL);
        functionSpec.put(FUN_header, HEADER);
        functionSpec.put(FUN_class, CLASS);
        functionSpec.put(FUN_extends, EXTENDS);
        functionSpec.put(FUN_implements, IMPLEMENTS);
        functionSpec.put(FUN_params, PARAMS);
        functionSpec.put(FUN_classDef, CLASSDEF);
        functionSpec.put(FUN_parse, PARSE);
        functionSpec.put(FUN_version, VERSION);
        functionSpec.put(FUN_serialize, SERIALIZE);
        functionSpec.put(FUN_objectOf, OBJECTOF);
        functionSpec.put(FUN_classOf, CLASSOF);
        functionSpec.put(FUN_customClass, CUSTOMCLASS);
        functionSpec.put(FUN_map, MAP);
    }
    public static void execute(List<CharSequence> params, MMLObject obj){
        if(params.size()==0)return;//do nothing
        Fun f = functionSpec.get(params.get(0).toString());
        if(f==null) throw new MMLParsingException("function "+params.get(0)+" is not found.\n\tList of functions : "+new ArrayList(functionSpec.keySet()));
        f.call(params, obj);
    }
}
