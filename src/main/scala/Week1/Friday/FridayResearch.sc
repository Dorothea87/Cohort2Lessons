/** Have a look into Pure and Impure functions.
 a. What are the positive and negatives of each?
 b. What is better practice to use? Why? Does this ever change?
 c. Look back over each function written in this afternoon task. Are they pure or impure
 functions? Why? */

//Pure Function
//- The function’s output depends only on its input variables
//- It doesn’t mutate any hidden state
//- It doesn’t have any “back doors”: It doesn’t read data from the outside world (including the console, web services, databases, files, etc.), or write data to the outside world
//- It does not read any other values from “the outside world” — the world outside of the function’s scope — and it does not modify any values in the outside world.
//- very safe and little room for error but maybe also a bit rigid/has limitations

//Impure Function
//- Their output depends on something other than their input parameters.
//- Read hidden inputs, i.e., they access variables and data not explicitly passed into the function as input parameters
//- Write hidden outputs
//- Mutate the parameters they are given
//- Perform some sort of I/O with the outside world
//- Applications need impure functions because they rely on input from the outside world (not very useful if not)

//Best practice:
//Write the core of your application using pure functions, and then write an impure “wrapper” around that core to interact with the outside world. If you like food analogies, this is like putting a layer of impure icing on top of a pure cake.
//-> Helps protect your code/can't be compromised so easily
//pure functions are easier to test, because they always have the same input, no side effects (they don't alter an external state), used with immutable data (no unexpected changes of state)
//keep them separate: clarity in code base, reduces complexity of reasoning
//impure function -> need more documentation, so that other developers know the side effects, use features of functional programming such as higher order functions to encourage purity

//We used a mix of pure and impure functions
//MVP -> pure (no values from the outside world)
//Extension -> impure (receive user input through the command line)