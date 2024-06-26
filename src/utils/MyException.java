package src.utils;


/**
 * MyException is a custom exception class inheriting from Exception.
 * It is used to represent specific errors or exceptional conditions in the application.
 */
public class MyException extends Exception {

    public MyException(String errorMessage) {
		super(errorMessage);
	}
}