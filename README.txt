==== About ====

The Meta-Markup Generator (MMG) is a system which generates a java class for parsing other markup languages based on a standardized format, mml, or the meta markup language. The java class can then accept a markup language based on the markup language, and produce either a new class or an instance based on the script. For example, you can make a script which defines the way JSON is parsed, and the MMG will generate a new class that will be able to parse JSON scripts, and create an object from them. The object can then be serialized, so the same JSON script would not need to be parsed again. MMG can produce parsers which can produce new classes which can produce new classes, which effectively gives a very skewed version of the popular functional programming technique, currying, except the new function generated is a new compiled class.

MMG is meant as a tool to produce useful and efficient code to handle parsing tasks used commonly in a single project, not as a parser that runs every time. Then, MMG can be used to efficiently generating new objects from a single script.


For example, one could produce a for generating keylisteners. The keylistener script could look something like
    CTRL+P -> {System.out.println("hello world!);}

Could be very helpful for making keylisteners easily. 


==== Meta-Markup Semantics ====

The flow of data is shown below. a => b means "a is generated into b", and a -> b means "b takes a as a parameter"

mml script ==> generated parsing class ==> generated class ==> either a compiled generator class, or a generated object
                                         ->
                                        /
                                       /
                        optional params



The generated parsing class 




=== Project Structure ====

We split the entire project into a few sub-modules that perform their own task.


