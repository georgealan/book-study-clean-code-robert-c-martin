package meaningful_distinctions;

/*
Consider the method in Listing 2-1. Do the variables need a more meaningful context?
The function name provides only part of the context; the algorithm provides the rest.
Once you read through the function, you see that the three variables, number, verb, and
pluralModifier, are part of the "guess statistics" message. Unfortunately, the context must
be inferred. When you first look at the method, the meanings of the variables are opaque.
 */
class GuessStatisticsWithUnclearMethod {
    private void printGuessStatistics(char candidate, int count) {
        String number;
        String verb;
        String pluralModifier;

        if (count == 0) {
            number = "no";
            verb = "are";
            pluralModifier = "s";
        } else if (count == 1) {
            number = "1";
            verb = "is";
            pluralModifier = "";
        } else {
            number = Integer.toString(count);
            verb = "are";
            pluralModifier = "s";
        }

        String guessMessage = String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
        System.out.print(guessMessage);
    }
}

/*
The function is a bit too long and the variables are used throughout. To split the function
into smaller pieces we need to create a GuessStatisticsMessage class and make the
three variables fields of this class. This provides a clear context for the three variables. They
are definitively part of the GuessStatisticsMessage. The improvement of context also allows
the algorithm to be made much cleaner by breaking it into many smaller functions. See below:
 */

public class GuessStatisticsMessage {
    private String number;
    private String verb;
    private String pluralModifier;

    public String make(char candidate, int count) {
        createPluralDependentMessageParts(count);
        return String.format("There %s %s %s%s", verb, number, candidate, pluralModifier);
    }

    private void createPluralDependentMessageParts(int count) {
        if (count == 0) {
            thereAreNoLetters();
        } else if (count == 1) {
            thereIsOneLetter();
        } else {
            thereAreManyLetters(count);
        }
    }

    private void thereAreManyLetters(int count) {
        number = Integer.toString(count);
        verb = "are";
        pluralModifier = "s";
    }

    private void thereIsOneLetter() {
        number = "1";
        verb = "is";
        pluralModifier = "";
    }

    private void thereAreNoLetters() {
        number = "no";
        verb = "are";
        pluralModifier = "s";
    }

    public static void main(String[] args) {
        GuessStatisticsMessage statisticsMessage = new GuessStatisticsMessage();
        String guessing1 = statisticsMessage.make('A', 3);
        String guessing2 = statisticsMessage.make('B', 0);
        String guessing3 = statisticsMessage.make('C', 1);
        System.out.println(guessing1);
        System.out.println(guessing2);
        System.out.println(guessing3);
    }
}
