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
    void call(Object ret);
}
