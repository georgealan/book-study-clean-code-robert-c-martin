package intention_revealing_names;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TimeMachine {
    // Below have a bad way to name a variable:
    int d = 0; // This is supposed to be: elapsed time in days

    // Follow below the corrections:
    int elapsedTimeInDays;
    int daysSinceCreation;
    int daysSinceModification;
    int fileAgeInDays;

    /*
    The name of a variable, function, or class, should answer all the big questions. It should tell you:
    * why it exists,
    * what it does, and
    * how it is used.
    If a name requires a comment, then the name does not reveal its intent.

    See the method below and try to gasp the meaning of that method, what is it supposed to do?
     */
    List<int[]> theList = new ArrayList<>();

    public List<int[]> getThem() {
        List<int[]> list1 = new ArrayList<>();

        for (int[] x : theList) {
            if (x[0] == 4) {
                list1.add(x);
            }
        }
        return list1;
    }

    /*
    The code implicitly requires that we know the answers to questions such as:
    1. What kinds of things are in theList?
    2. What is the significance of the zeroth subscript of an item in theList?
    3. What is the significance of the value 4?
    4. How would I use the list being returned?
    Now let's see the improved versions:
     */

    List<int[]> gameBoard = new ArrayList<>();
    int STATUS_VALUE;
    int FLAGGED = 4;

    public List<int[]> getFlaggedCells() {
        List<int[]> flaggedCells = new ArrayList<>();
        for (int[] cell : gameBoard) {
            if (cell[STATUS_VALUE] == FLAGGED) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    /*
    We can go further and write a simple class for cells instead of using an array of ints.
    It can include an intention-revealing function (call it isFlagged) to hide the magic numbers.
    It results in a new version of the function:
     */

    class Cell {
        private int flag;
        Cell(int flag) { this.flag = flag; }
        public boolean isFlagged() { return flag == 4; }
    }
    List<Cell> gameBoard2 = new ArrayList<>();

    public List<Cell> getFlaggedCells2() {
        List<Cell> flaggedCells = new ArrayList<>();
        for (Cell cell : gameBoard2) {
            if (cell.isFlagged()) {
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }

    // Better names for collections which hold a bunch of other objects
    List<String> accountGroup = new ArrayList<>();
    int[] bunchOfAccounts = new int[10];
    List<String> accounts = new ArrayList<>();

    // Beware of using names which vary in small ways.
    int XYZControllerForEfficientHandlingOfStrings = 0;
    int XYZControllerForEfficientStorageOfStrings = 1;

    /* Avoid use lower-case L or uppercase O as a variable names, specially in combination, because they look like
    the constants 1 and 0.
     */
    int l = 1;
    int a = l;
    int O = 0;
    int O1 = 0;
    void onlyForAvoidClassError() {
        if (O == l) {
            a = O1;
        } else {
            l = 01;
        }
    }

    /*
    ##### AVOID NAMING WITH NUMBER-SERIES #####
    Avoid naming with number-series for example: (a1, a2, a3... aN) it's the opposite of intentional naming, they're
    non-informative, they provide no clue to the author's intention. See example below:
     */
    void copyChars(char a1[], char a2[]) {
        for (int i = 0; i < a1.length; i++) {
            a2[i] = a1[i];
        }
    }
    // This is better when:
    void copyCharsBetter(char source[], char destination[]) {
        for (int i = 0; i < source.length; i++) {
            destination[i] = source[i];
        }
    }

    /*
    ##### AVOID NAMING WITH NOISE WORDS #####
    Noise words are meaningless distinction. Imagine that you have a "Product class". If you have another called
    "ProductInfo" or "ProductData", you have made the names different without making them mean anything different.
    "Info" and "Data" are indistinct noise words like "a", "an", and "the".
     */

    int zork;
    int theZork;
    /*
     Those above are bad examples, that you only decide call a variable theZork only because you already have
     another variable named zork. Noise words are redundant.
     */

    /*
    Wich classes below will represent the best path to a custumer payment history?
     */
    class Custumer {}
    class CustumerObject {}

    // Or these functions below:
    void getActiveAccount() {};
    void getActiveAccounts() {};
    void getActiveAccountInfo() {};
    // How are the programmers supposed to know which of these functions to call?

    /*
    ###### USE PRONOUNCEABLE NAMES ######
    Avoid the use of names which can't be easy pronunciation. Se the example below:
     */
    class DtaRcrd102 {
        private Date genymdhms;
        private Date modymdhms;
        private final String pszqint = "102";
        /* ... */
    }
    // to
    class Customer {
        private Date generationTimeStamp;
        private Date modificationTimeStamp;
        private final String recordId = "102";
    }
    // Intelligent conversation is now possible.

    /*
    ####### USE SEARCHABLE NAMES #######
    Avoid call variables with short names, like "a", "an". Single letter names and numeric constants have a
    particular problem, they aren't easy to locate across a body of text.
    Single-letters names can ONLY be used as local variables inside short methods. The length of the name should
    correspond to the size of its scope.

    Single-letters can be use in small scopes like loop counters.

    If a variable or constant might be seen or used in multiple places in a body of code, it is imperative to
    give it a search-friendly name, compare the example below:
     */
    int s;
    int[] t = new int[8];
    void onlyForAvoidClassError2() {
        for (int j = 0; j < 34; j++) {
            s += (t[j] * 4) / 5;
        }
    }
    // To
    int realDaysPerIdealDay = 4;
    final int WORK_DAYS_PER_WEEK = 5;
    final int NUMBER_OF_TASKS = 3;
    int sum = 0;
    int[] taskEstimate = new int[8];
    void onlyForAvoidClassError3() {
        for (int j = 0; j < NUMBER_OF_TASKS; j++) {
            int realTaskDays = taskEstimate[j] * realDaysPerIdealDay;
            int realTaskWeeks = (realTaskDays / WORK_DAYS_PER_WEEK);
            sum += realTaskWeeks;
        }
    }

    /*
    ######## CLASS NAMES ########
    Classes must be named with nouns or noun phrase names like, "Customer", "WikiPage", "Account", and "AddressParser".
    You shouldn't use verbs for name your classes.
    * Verb = actions
    * Nouns = being designation, creature or thing, alive or not.

    ######## METHOD NAMES ########
    Methods should have verb or verb phrase names like postPayment, deletePage, or save.
    Accessors, mutators, and predicates should be named for their value and prefixed with get,
    set, and is according to the javabean standard.

    When constructors are overloaded, use static factory methods with names that
    describe the arguments. For example,
     */
    static class Complex {
        private double realNumber;
        private Complex(double realNumber) {
            this.realNumber = realNumber;
        }
        public static Complex fromRealNumber(double realNumber) {
             return new Complex(realNumber);
        }
    }
    Complex fulcrumPoint = Complex.fromRealNumber(23.0);

    // This form above is better than this below, see:

    Complex fulcrumPoint2 = new Complex(23.0);



}

// TODO Continue in page
