package com.capita.string.calc.app.service;

/**
 * Class to create token (separated by operator and parenthesis) from expression
 * 
 * @author Avinash
 *
 */
public class ExpressionToken {
	private int type;
	private Integer value;
	private String operator;
	private int precedence;

	public ExpressionToken() {
		this.type = ExpressionTokenType.UNKNOWN.getType();
	}

	/**
	 * Expression token constructor </br>
	 * TODO: To make to dynamic operator would be evaluated outside this
	 * construct so logic needs to be moved to {@code ExpressionEvaluator}
	 * 
	 * @param contents
	 */
	public ExpressionToken(String contents) {
		switch (contents) {
		case "+":
			this.type = ExpressionTokenType.OPERATOR.getType();
			this.operator = contents;
			this.precedence = 1;
			break;
		case "-":
			this.type = ExpressionTokenType.OPERATOR.getType();
			this.operator = contents;
			this.precedence = 1;
			break;
		case "*":
			this.type = ExpressionTokenType.OPERATOR.getType();
			this.operator = contents;
			this.precedence = 2;
			break;
		case "/":
			this.type = ExpressionTokenType.OPERATOR.getType();
			this.operator = contents;
			this.precedence = 2;
			break;
		case "(":
			this.type = ExpressionTokenType.LEFT_PARENTHESIS.getType();
			break;
		case ")":
			this.type = ExpressionTokenType.RIGHT_PARENTHESIS.getType();
			break;
		default:
			this.type = ExpressionTokenType.NUMBER.getType();
			try {
				this.value = Integer.valueOf(contents);
			} catch (final Exception ex) {
				this.type = ExpressionTokenType.UNKNOWN.getType();
			}
		}
	}

	public ExpressionToken(Integer x) {
		this.type = ExpressionTokenType.NUMBER.getType();
		this.value = x;
	}

	public int getType() {
		return this.type;
	}

	public Integer getValue() {
		return this.value;
	}

	public int getPrecedence() {
		return this.precedence;
	}

	public String getOperator() {
		return this.operator;
	}

}
