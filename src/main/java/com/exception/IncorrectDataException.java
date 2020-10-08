package com.exception;

public class IncorrectDataException extends Exception {
	private static final long serialVersionUID=1L;
	String workBookName;

public IncorrectDataException (String workBookName) {
this.workBookName =workBookName;
}
	public String toString() {
		return ("Incorrect Data available in:"+workBookName);
	}

}
