package function_arguments;

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
    Flag arguments are ugly. Passing a boolean into a function is a truly terrible practice. It
    immediately complicates the signature of the method, loudly proclaiming that this function
    does more than one thing. It does one thing if the flag is true and another if the flag is false!
     */

    /* Prefer exceptions to returning error codes
    Try/catch blocks are ugly in their own right. They confuse the structure of the code and
    mix error processing with normal processing. So it is better to extract the bodies of the try
    and catch blocks out into functions of their own.
     */
    private void logError(Exception e) {}
    public void delete(Object page) {
        try {
            deletePageAndAllReferences(page);
        } catch (Exception e) {
            logError(e);
        }
    }

    private void deletePageAndAllReferences(Object page) throws Exception {
        deletePage(page);
        deleteReference(page);
    }

    private void deleteReference(Object name) {}
    private void deletePage(Object page) {}

    /*
    In the above, the delete function is all about error processing. It is easy to understand
    and then ignore. The deletePageAndAllReferences function is all about the processes of
    fully deleting a page. Error handling can be ignored. This provides a nice separation that
    makes the code easier to understand and modify.
     */




}

// TODO Continue in page 78, Vertical Openness Between Concepts
