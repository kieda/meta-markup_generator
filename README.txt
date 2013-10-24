==== Important Note ====
If this project has changed since you've last seen it, this is because I've updated it. I find this project really interesting, and I am working on it whenever I have some free time (or even when I don't). 

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

The project consists of a few basic packages,

mmg.drivers : entry-points to the mmg
              interesting class : mmg.drivers.Main
mmg.args : deals with the String[] input args to the mmg system 
mmg.compiler : deals with parsing and compilation of mml scripts, and putting these scripts into an intermediate language
               interesting class : mmg.compiler.compilation.CompileJava
mmg.gen : deals with the semantics of generating java code
mmg.util : various utilities, includiing some pretty interesting string utilities. Give them a look!
mmg.test : various tests
lib : utilities not written (or only partially written) by me.


=== Note ===

Most of this project has been designed and coded in 24 hours... please take that into account.

(unfortunately, midterms took up all of my time last week)

=== TODO ===

Finish mmg compilation, placement of mmg objects into java format.
