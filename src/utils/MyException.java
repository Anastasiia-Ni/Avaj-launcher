package src.utils;

public class MyException extends Exception {

	public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_RED = "\u001B[31m";

    public MyException(String errorMessage) {
		super(ANSI_RED + errorMessage + ANSI_RESET);
	}
}