package com.capita.string.calc.app.service;

/**
 * Types of tokens from expression
 * 
 * @author Avinash
 *
 */
public enum ExpressionTokenType {
	UNKNOWN(-1), NUMBER(0), OPERATOR(1), LEFT_PARENTHESIS(2), RIGHT_PARENTHESIS(3);

	private int type;

	private ExpressionTokenType(int type) {
		this.type = type;
	}
	
	public int getType(){
		return this.type;
	}
}
