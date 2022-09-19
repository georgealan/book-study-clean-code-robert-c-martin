package function_arguments;

import java.io.IOException;
import java.io.InputStream;

public class IdealNumberOfFunctionsArguments {
    /*
    The ideal number of arguments for a function is:
    zero (niladic)
    one (monadic)
    two (dyadic)
    three (triadic) - this should be avoided where possible.
     */

    /* THE MONADIC FORM
    There are two very common reasons to pass a single argument into a function, let's see:
     */

    // 1º ASKING A QUESTION
    public boolean fileExists(String yourFile) { return true; }

    // 2º OPERATING ON THAT ARGUMENT, TRANSFORM IT IN SOMETHING ELSE AND RETURNING IT
    public InputStream fileOpen(String yourFile) { return InputStream.nullInputStream(); }


    // Other form less common, but still useful form is an EVENT
    void passwordAttemptFailedNtimes(int attempts) {}
    /*
    In this form there is an input argument but no output argument. The overall program is meant to interpret the
    function call as an event and use the argument to alter the state of the system.
    Use this form with care. It should be very clear to the reader that this is an event.
    Choose names and contexts carefully.
     */

    // Try to avoid any monadic functions that don't follow these forms, for example:
    void transform1(StringBuffer out) {} // using an output argument instead of a return value for a transformation is confusing.

    StringBuffer transform2(StringBuffer in) {
        StringBuffer newSt = new StringBuffer();
        return newSt;
    }
    // If a function is going to transform its input argument, the transformation should appear as the return value.


    /* AVOID FUNCTIONS WITH FLAG ARGUMENTS

     */
}

// TODO Continue in page 41, Flag Arguments
