package src.utils;

public class NumberChecker {
    public static int parseNumber(String str, int line) throws MyException {
        int number = 0;
        String errorMsg1 = (line == 0) ? "Runs number error" : "Aircraft coordinate argument error";
        String errorMsg2 = "Error converting number for input : " + str;

        if (line != 0) {
            errorMsg1 += " in line " + line;
            errorMsg2 += " in line " + line;
        }

        if (!str.matches("^[+]?\\d+")) {
            throw new MyException(errorMsg1);
        }

        try {
            number = Integer.parseInt(str);
        }
        catch (NumberFormatException e) {
            throw new MyException(errorMsg2);
        }

        return number;
    }
}