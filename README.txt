==== About ====

The Meta-Markup Generator (MMG) is a system which generates a java class for parsing other markup languages based on a standardized format, mml, or the meta markup language. The java class can then accept a markup language based on the markup language, and produce either a new class or an instance based on the script. For example, you can make a script which defines the way JSON is parsed, and the MMG will generate a new class that will be able to parse JSON scripts, and create an object from them. The object can then be serialized, so the same JSON script would not need to be parsed again. MMG can produce parsers which can produce new classes which can produce new classes, which effectively gives a very skewed version of the popular functional programming technique, currying, except the new function generated is a new compiled class.

MMG is meant as a tool to produce useful and efficient code to handle parsing tasks used commonly in a single project, not as a parser that runs every time. Then, MMG can be used to efficiently generating new objects from a single script.


For example, one could produce a for generating keylisteners. The keylistener script could look something like
    CTRL+P -> {System.out.println("hello world!);}

Could be very helpful for making keylisteners easily. 


==== Meta-Markup Semantics ====

A meta-script is passed into the MMG, and produces a class which can parse certain scripts.

Passing params into the class which can parse certain scripts, either a new class is generated, or a class which can generate serialized objects is generated, or an object is generated.

=== Project Structure ====

We split the entire project into a few sub-projects to give better modularity while working on the project. The final version will compile all of the sources into one large, cohesive, project. 

Currently, the sub-projects include

GenerateJava : deals with the semantics of generating java code
Meta-Markup Generator : the part which contains the main class (the 'head' part of the MMG)
MMLCompiler : deals with compilation of mml scripts, and putting it into a java-representation
Util : various string utilities. Some of these are pretty interesting, give them a look!
Test : project for various tests
Lib : utilities not written by me.


=== Note ===

This project is currently not finished. However, this idea, designes, and all of the code has been written in the past 24 hours... please take that into account.

(unfortunately, midterms took up all of my time this week)

=== TODO ===

Finish mmg compilation, placement of mmg objects into java format.
