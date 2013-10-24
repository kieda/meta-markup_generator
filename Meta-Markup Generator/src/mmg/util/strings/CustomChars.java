package mmg.util.strings;

/**
 * done for 'extreme' efficiency
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
        r = 35+(len<<1);
    }
    public static final char[] back = new char[]{'$','p','a','t','t','e','r','n','s','[',']','=','n','u','l','l',';',
            '$','s','e','q','u','e','n','c','e','s','[',']','=','n','u','l','l',';'
    };
    @Override public int length() {return r-l;}

    
    @Override
    public char charAt(int i) {
        i-=l;
        if(i<0||i>r) throw new IndexOutOfBoundsException("length "+length()+ " index "+i);
        if(i<10) return back[i];
        if(i<=9+len) return seq.charAt(i-10);
        if(i<=27+len) return back[i-len];
        if(i<=27+(len<<1)) return seq.charAt(i-28-len);
        return back[i-(len<<1)];
    }

    @Override
    public CharSequence subSequence(int start, int end) {
        return new CustomChars(seq, l+start, l+end);
    }
}
