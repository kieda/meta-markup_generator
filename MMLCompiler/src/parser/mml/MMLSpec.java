package parser.mml;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * designs the specification for the MML.
 * 
 * Note: we will attempt to make this more expandable in the future (with 
 * variable and recursive types, method overloading, etc) but this is currently
 * the fastest to produce given this time frame.
 * 
 * (In fact, we could use the MML to produce a new MML 
 * 
 * @author zkieda
 */
public class MMLSpec {
    private MMLSpec(){}
        
    //the specification from the string function name to a series of bytes
    //which specify the type. The first four bits from the left are used to 
    //encode the function, and the next four bits provide additional information
    //about the parameters specified. Currently, they specify an index to 
    //SYMBOLS
    private static final Map<String, byte[]> functionSpec = new HashMap<>();
    
    /**
     * defines variables, etc before the local function begins
     * 
     * function call : 
     *     local (JAVA) ;
     */
    public static final String FUN_local = "local";
    
    /**
     * defines what should go at the very top of the page
     * 
     * function call :
     *     package (JAVA) ;
     */
    public static final String FUN_package = "package";
    
    /**
     * defines what should go at the very top of the page
     * 
     * function call : 
     *     import (JAVA) ;
     */
    public static final String FUN_import = "import";
    
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
     * defines a method according to its scope/static/final/return type, 
     * method name, and params
     * 
     * method (JAVA) (JAVA) (JAVA) (JAVA) ;
     */
    public static final String FUN_method = "method";
    
    /**
     * defines the way which this class will be compiled, see SYMBOLS[0]
     * default: GenerateClass. Note: when type =
     *           SerializeObject, we must call the function serialize
     *           GenerateObject, we must call the function objectOf
     *           GenerateClass, we must call the function classOf
     *           CustomClass, we must call the function customClass
     * 
     * we may not call more than one function at a time.
     * 
     * function call : 
     *     type (SYMBOL) ;
     */
    public static final String FUN_type = "type";
    
    /**
     * defines syntax in the classes main body. 
     * 
     * function call : 
     *     syntax (INTEGER) (REGEXES) ;
     */
    public static final String FUN_syntax = "syntax";
    
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
    
    public static final byte PARAM_JAVA = 0;//pass java as a parameter
    public static final byte PARAM_REGEXES = 1;//pass regexes as a parameter
    public static final byte PARAM_STRING = 2;//pass a string param
    public static final byte PARAM_INTEGER = 3;//pass a string param
    public static final byte PARAM_SYMBOL = 4;//pass a symbol param. The next byte is the symbols available.
    public static final byte PARAM_BOOL = 5;//pass a symbol param. The next byte is the symbols available.
    
    public static final String[][] SYMBOLS = new String[][]{
        //symbol set 0
        {"SerializeObject", "GenerateObject", "GenerateClass", "CustomClass"}
    };
    
    static{
        final byte[] JUST_JAVA = new byte[]{PARAM_JAVA};//should be a-ok since the byte[] should never be revealed to the client
        
        //local (JAVA) ;
        functionSpec.put(FUN_local, JUST_JAVA);
        //package (JAVA) ;
        functionSpec.put(FUN_package, JUST_JAVA);
        //import (JAVA) ;
        functionSpec.put(FUN_import, JUST_JAVA);
        //class (JAVA) ;
        functionSpec.put(FUN_class, JUST_JAVA);
        //extends (JAVA) ;
        functionSpec.put(FUN_extends, JUST_JAVA);
        //implements (JAVA) ;
        functionSpec.put(FUN_implements, JUST_JAVA);
        //params (JAVA) ;
        functionSpec.put(FUN_params, JUST_JAVA);
        //method (JAVA) (JAVA) (JAVA) (JAVA) ;
        functionSpec.put(FUN_method, new byte[]{PARAM_JAVA, PARAM_JAVA, PARAM_JAVA, PARAM_JAVA});
        //type (SYMBOL) ;
        functionSpec.put(FUN_type, new byte[]{PARAM_SYMBOL});//note that the index of type in SYMBOLS[][] is at index 0
       //syntax (INTEGER) (REGEXES) ;
        functionSpec.put(FUN_syntax, new byte[]{PARAM_INTEGER, PARAM_REGEXES});
        //version (INTEGER) ;
        functionSpec.put(FUN_version, new byte[]{PARAM_INTEGER});

        //serialize () ;
        functionSpec.put(FUN_serialize, new byte[]{});
        //objectOf () ;
        functionSpec.put(FUN_objectOf, new byte[]{});
        //classOf () ;
        functionSpec.put(FUN_classOf, new byte[]{});
        //customClass (JAVA);
        functionSpec.put(FUN_customClass, JUST_JAVA);
    }
    
    public static Set<String> functions(){
        return functionSpec.keySet();
    }
    
    public static byte[] getSpec(String function) {
        byte[] b = functionSpec.get(FUN_type);
        return b==null?null:Arrays.copyOf(b, b.length);
    }
    public static int indexOfByte(byte b){
        return ((b&0xFF)>>4);
    }
    
    public static final String BEGIN_JAVA = "(~";
    public static final String END_JAVA = "~)";
    public static final String BEGIN_REGEXES = "(`";
    public static final String END_REGEXES = "`)";
    public static final String REGEX_GROUP = "#";
    public static final String END_FUNC = ";";
}
