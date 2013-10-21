/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package parser.mml.funs;

import compl.MMLObject;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import parser.exception.InvalidFunName;
import parser.exception.MMLParsingException;

/**
 *
 * @author zkieda
 */
public abstract class Fun{
    private static Pattern funName = Pattern.compile("[_A-Za-z][0-9_A-Za-z]*");
    public Fun(String fun_name){
        if(!funName.matcher(fun_name).matches())
            throw new InvalidFunName(fun_name);

        verify.add(Pattern.compile(fun_name));
        init(verify);
    }
    
    protected abstract void init(List<Pattern> verify);
    
    private List<Pattern> verify = new LinkedList<>();


    /**
     * we check that the input function call matches the specification, and
     * then we call the function itself. The first param should be the 
     * function name. The semicolon should not be included.
     */
    public void call(List<CharSequence> params, MMLObject object){
        if(params.size()!=verify.size()) 
            throw new MMLParsingException(String.format("params are not the correct length\n\tgiven : %d\n\texpected : %d",
                    params.size(), verify.size()));

        CharSequence lastParam;

        Iterator<Pattern> verIt = verify.iterator();
        Iterator<CharSequence> parIt = params.iterator();

        Matcher m = verIt.next().matcher((lastParam = parIt.next()));
            //we know both must have at least one, since we added one elem 
            //in in the constructor, and we know the two lengths are equal

        do{
            if(!m.matches())
                throw new MMLParsingException(String.format("params are not to the correct specification.\n\tgiven : %s\n\texpected to match : %s",
                    lastParam, m.pattern()));
            m.usePattern(verIt.next());
            m.reset((lastParam = parIt.next()));
        }while(parIt.hasNext());//we know they are the same length so we are A-ok.

        fun(params, object);
    }

    protected abstract void fun(List<CharSequence> params, MMLObject object);
}
