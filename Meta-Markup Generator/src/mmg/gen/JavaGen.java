package mmg.gen;

/**
 * A simple class with the ability to generate java.
 * @author zkieda
 */
public interface JavaGen {
    /**
     * This method must be fulfilled, since it is necessary for compilation.
     * @return the class name of this java class
     */
    public CharSequence getClassName();
    
    /**
     * This method must be fulfilled, since it is necessary for compilation.
     * @return the full java name, i.e. "hello.world.MaximumBS"
     */
    public CharSequence getFullName();
    
    /**
     * sets the class name, such that the change in class name is reflected in
     * toCharSequence() as well. 
     * 
     * You may throw an UnsupportedOperationException if the generated class's 
     * name should not be modified, or if this JavaGen is simply backed by a
     * charsequence.
     */
    public void setClassName(CharSequence name);
    
    /**
     * the charsequence that defines the script
     */
    public CharSequence toCharSequence();
}
