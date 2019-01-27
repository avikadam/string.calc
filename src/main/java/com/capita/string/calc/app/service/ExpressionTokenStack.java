package com.capita.string.calc.app.service;

import java.util.ArrayList;
import java.util.List;

public class ExpressionTokenStack {
	private List<ExpressionToken> tokens;

	public ExpressionTokenStack() {
		this.tokens = new ArrayList<ExpressionToken>();
	}

	public boolean isEmpty() {
		return tokens.size() == 0;
	}

	public ExpressionToken top() {
		return tokens.get(tokens.size() - 1);
	}

	public void push(ExpressionToken t) {
		tokens.add(t);
	}

	public void pop() {
		tokens.remove(tokens.size() - 1);
	}
	
	public ExpressionToken popTop() {
		ExpressionToken t = tokens.get(tokens.size() - 1);
		tokens.remove(tokens.size() - 1);
		return t;
	}
}
