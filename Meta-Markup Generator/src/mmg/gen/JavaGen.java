package mmg.gen;

/**
 * @author zkieda
 */
public interface JavaGen {
    public CharSequence getClassName();
    public void setClassName(CharSequence name);
    public CharSequence getFullName();
    public CharSequence toCharSequence();
}
