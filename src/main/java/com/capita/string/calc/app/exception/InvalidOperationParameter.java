package com.capita.string.calc.app.exception;

public class InvalidOperationParameter extends RuntimeException {

	private static final long serialVersionUID = 9179514519961970532L;

	public InvalidOperationParameter(String string) {
		super(string);
	}

}
