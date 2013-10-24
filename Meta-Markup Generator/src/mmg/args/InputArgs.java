package mmg.args;

import static mmg.args.Flags.FLAG_INPUT;

/**
 * This class parses args containing information about the source mml script.
 * Currently, we have one method for parsing the "-i" flag.
 * 
 * We also parse args in mmg.compiler.compilation.CompileJava
 * 
 * however, we want to keep these arguments disjoint, since these arguments 
 * specify parameters about the mml script (and, possibly in the future, 
 * additional parameters about the runtime and setup of the mmg system)
 * 
 * @author zkieda
 */
public class InputArgs implements Flags{
    private InputArgs(){}
    
    /**
     * This method parses for the -i flag and its matching argument. 
     * 
     * If there are multiple -i flags, we return the argument that follows the 
     * last -i flag specified. Every "-i" in args, and its following argument
     * are set to null, so we will not accidentally parse them in future stages. 
     * 
     * @return the string following the last matching -i flag, or null if it 
     * does not exist.
     */
    public static String getInput(String[] args){
        final String err1 = " cannot be at the end of args, since it requires an extra argument";
        
        String source=null;//the file path for the input mml script.
        
        for(int i=0;i<args.length;i++){//iterate through each arg
            
            if(FLAG_INPUT.equals(args[i])){//if we have found the flag for input.
                if(++i<args.length){//if we are not at the end of the string
                    source = args[i];//the source file is the next argument
                    args[i-1]=args[i]=null;//and we set both args to null
                }else{
                    //otherwise we throw an error. We cannot have the -i
                    //flag at the end of the arguments, since the next input 
                    //is the script path
                    throw new InvalidArgsException(FLAG_INPUT+err1);
                }
            }
        }
        return source;//return the source file specified, or null 
    }
    
//    public static void main(String[] args) {
//        String[] s = {"asdf", "as", "-i", "-i", "wer", "-i", "nop"};
//        System.out.println(getInput(s));//should print nop
//        
//        System.out.println(java.util.Arrays.toString(s));
//            //should print ["asdf", "as", null, null, "wer", null, null]
//        
//        System.out.println(getInput(s));//should return null
//        
//        s[s.length-1] = "-i";
//        getInput(s);//should throw an InvalidArgsException.
//        
//        //verified.
//    }
}
