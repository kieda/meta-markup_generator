/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmg.gen;

import java.io.IOException;
import java.util.LinkedList;
import mmg.util.strings.CustomChars;

/**
 *
 * @author zkieda
 */
public class JavaSource implements JavaGen{
     /* definition:
     * 0 -> imports
     * 1 -> 
     */
    private final LinkedList<String>[] class_def = new LinkedList[1];
    {for(int i=0;i<class_def.length;i++)class_def[i]=new LinkedList<>();}
    
//    public JavaGen(String CLASS_NAME){
//        class_def[1].add("public class ");
//    }
    
    public void setPackage(CharSequence pack){
    }
    public void setClassName(CharSequence classN){
    }
    public CharSequence getClassName(){
        return null;
    }
    public CharSequence getFullName(){
        return null;
    }
    public void setExtends(CharSequence ext){
    }
    public void setImplements(CharSequence impl){
    }
    public void addConstructor(CharSequence params, CharSequence body){
    }
    public void addBodySyntax(CharSequence body){
    }
    public void addMethod(CharSequence scopes_static, CharSequence ret, CharSequence params, CharSequence body){
    }
    public void addSubClass(CharSequence scopes_static, JavaGen other){
    }
    
    
    public void writeTo(String filepath) throws IOException{
    }
    public CharSequence toCharSequence(){
        return null;
    }
    
    private static void conf(LinkedList<CharSequence> ls, int i) {
        ls.add(new CustomChars(i));
//        "$patterns[0] = ;" +
//"$sequences[0] = hello;";
    }
}
