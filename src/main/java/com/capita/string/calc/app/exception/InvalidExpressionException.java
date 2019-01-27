package com.capita.string.calc.app.exception;

/**
 * Exception to mark invalid expression
 * 
 * @author Avinash
 *
 */
public class InvalidExpressionException extends RuntimeException {

	private static final long serialVersionUID = 9179514519961970532L;

	public InvalidExpressionException(String string) {
		super(string);
	}

}
