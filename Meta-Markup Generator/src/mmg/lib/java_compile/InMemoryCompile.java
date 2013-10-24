/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package mmg.lib.java_compile;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.tools.JavaCompiler;
import javax.tools.JavaFileManager;
import javax.tools.JavaFileObject;
import javax.tools.ToolProvider;

/**
 * original class by Miron Sadziak from javablogging.com
 * 
 * modification by zkieda to fit needs
 * 
 * See : 
 * http://www.javablogging.com/dynamic-in-memory-compilation/
 */
public class InMemoryCompile {
    public static Object compile(String fullName, CharSequence src) throws ClassNotFoundException, InstantiationException, IllegalAccessException{
        // We get an instance of JavaCompiler. Then
            // we create a file manager
            // (our custom implementation of it)
            JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
            JavaFileManager fileManager = new
                ClassFileManager(compiler
                    .getStandardFileManager(null, null, null));

            // Dynamic compiling requires specifying
            // a list of "files" to compile. In our case
            // this is a list containing one "file" which is in our case
            // our own implementation (see details below)
            List<JavaFileObject> jfiles = new ArrayList<JavaFileObject>();
            jfiles.add(new CharSequenceJavaFileObject(fullName, src));

            // We specify a task to the compiler. Compiler should use our file
            // manager and our list of "files".
            // Then we run the compilation with call()
            compiler.getTask(null, fileManager, null, null,
                null, jfiles).call();

            // Creating an instance of our compiled class and
            // running its toString() method
            
                    return fileManager.getClassLoader(null)//todo - change this
                .loadClass(fullName)
                            .newInstance();
    }
}
