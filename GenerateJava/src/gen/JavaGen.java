package gen;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zkieda
 */
public class JavaGen {
    /* definition:
     * 0 -> imports
     * 1 -> 
     */
    private final LinkedList<String>[] class_def = new LinkedList[1];
    {for(int i=0;i<class_def.length;i++)class_def[i]=new LinkedList<>();}
    
//    public JavaGen(String CLASS_NAME){
//        class_def[1].add("public class ");
//    }
    
    public void setPackage(String pack){
    }
    public void setClassName(String classN){
    }
    public String getClassName(){
    }
    public String getFullName(){
    }
    public void setExtends(String ext){
    }
    public void setImplements(String impl){
    }
    public void addConstructor(String params, String body){
    }
    public void addBodySyntax(String body){
    }
    public void addMethod(String scopes_static, String ret, String params, String body){
    }
    public void addSubClass(String scopes_static, JavaGen other){
    }
    
    
    public void writeTo(String filepath) throws IOException{
        
    }
    public CharSequence toCharSequence(){
        return null;
    }
    
    
}
