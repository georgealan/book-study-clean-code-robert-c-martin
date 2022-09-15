package intention_revealing_names;

import java.util.ArrayList;
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
}
