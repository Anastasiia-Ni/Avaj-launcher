package src.utils;

/**
 * NumberChecker is a utility class that provides methods for parsing and validating numbers from strings.
 */
public class NumberChecker {

    /** Parses a string into an integer number. */
    public static int parseNumber(String str, int line) throws MyException {
        int number = 0;

        // Error messages
        String errorMsg1 = (line == 0) ? "Runs number error" : "Aircraft coordinate argument error";
        String errorMsg2 = "Error converting number for input : " + str;

        // Append line number to error messages if line != 0
        if (line != 0) {
            errorMsg1 += " in line " + line;
            errorMsg2 += " in line " + line;
        }

        // Validate string format (should be a positive integer)
        if (!str.matches("^[+]?\\d+")) {
            throw new MyException(errorMsg1);
        }

        // Attempt to parse string to integer
        try {
            number = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            throw new MyException(errorMsg2);
        }

        return number;
    }
}