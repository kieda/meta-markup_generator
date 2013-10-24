package mmg.util.strings;

/**
 * done for 'extreme' efficiency. This is just a test for now...
 * I might implement this if there is some significant optimization I can make.
 * @author zkieda
 */
public class CustomChars implements CharSequence{
    private final String seq;
    private final int len;
    private final int l;
    private final int r;
    
    private CustomChars(String seq, int l, int r){
        len = (this.seq = seq).length();
        this.l = l; this.r = r;
    }
    public CustomChars(int i){
        len = (seq = Integer.toString(i)).length();
        l = 0;
        r = 35+(len<<1);//oh man oh no
    }
    public static final char[] back = new char[]{'$','p','a','t','t','e','r','n','s','[',']','=','n','u','l','l',';',
            '$','s','e','q','u','e','n','c','e','s','[',']','=','n','u','l','l',';'
    };
    @Override public int length() {return r-l;}

    
    @Override
    public char charAt(int i) {
        //this literally does bounds checking to simulate the string 
        //"$patterns["+seq+"]=null;$sequences["+seq+"]=null;"
        
        //I guess this would work very well for a sequence that needs to be
        //re-generated in a very similar manner 
        i-=l;
        if(i<0||i>r) throw new IndexOutOfBoundsException("length "+length()+ " index "+i);
        if(i<10) return back[i];
        if(i<=9+len) return seq.charAt(i-10);
        if(i<=27+len) return back[i-len];
        if(i<=27+(len<<1)) return seq.charAt(i-28-len);
        return back[i-(len<<1)];//what speed!!! bitshift to the max!!!
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new CustomChars(seq, l+start, l+end);
    }
}
