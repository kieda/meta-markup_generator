package mmg;

/**
 * to be implemented - 
 * 
 * a callback function that a user can specify, such that we instantiate a new 
 * instance of the compiled class and pass it as an argument.
 * 
 * Eventually, we will open a new thread, instantiate the object, and pass it 
 * to the callback. If the time from instantiation till the callback time is 
 * above some threshold, (like 1s) we will call a timeout exception to prevent
 * too many threads from being made and not stopped. (We could also have a flag 
 * to remove timeouts)
 * 
 * @author zkieda
 */
public interface CompilationCallback {
    /**
     * after the class has been instantiated, we pass it to the call method.
     * 
     * We know which constructor in the generated class we should use by the 
     * paramTypes() method. 
     * 
     * We instantiate the constructor using the args() method. 
     * 
     * @param ret the instantiated object.
     */
    void call(Object ret);
    
    /**
     * this method provides the parameter types of the constructor we should 
     * call when instantiating this class. After knowing which types the 
     * constructor is, we instantiate the constructor using the args from 
     * args().
     * 
     * we require args().length == paramTypes().length
     */
    Class<?>[] paramTypes();
    
    /**
     * this method proved the arguments used for instantiating the constructor 
     * of the generated java class.
     */
    Object[] args();
}
