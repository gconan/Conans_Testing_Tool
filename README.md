# Conans_Testing_Tool Exterminator

This side project is inspired by the Software Testing (EE 360T) class I completed at The University of Texas at Austin. I really enjoyed the class and a lot of the material interested me. Mutation testing in particular interested me, and it sounded like a challenge to automate the process.

Exterminator is aimed at java projects. The logger can be used with any java file, but is not recommended for test files. The mutation testing is to be used with JUnit test suites. I plan to write a script wich runs exterminator, recompiles code, and runs with exterminator code to produce the desired output.

Parts of the project:

-Generic command line interface (a utility for this project and others to follow)
--this will allow me to reuse this in any other projects that interfaces with a user from the command line


-Logging (preprocess a java file, allow for different degrees of logging, and add thelogging code to a new java file)
--part one of the testing tool is to log with lines of code are executed
--this logging can translate to [graph] coverage information for the user (such as node coverage, edge coverage, path coverage...)
--logging can also assist with narrowing down errors by utilizing the information about a variable values or object state


-Mutation Testing (create additional tests in a test suite which contain mutants of the supplied test suite | *need to figure out how to "strongly/weakly" kill mutants and report to the user)
--it has come to my attention that there are not many mutation testing tools, so I decided to build one
--my goal is to allow the user to specify which type of mutation testing he or she wants and specify how many mutant tests to create
--one way to determine the mutant report could be to verify the mutant infection using a logger, then before a juint assert, classify the mutant as weakly or strongly killed


