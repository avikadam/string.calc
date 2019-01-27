package com.capita.string.calc.app.val;

public interface Validator<T> {
	public Boolean isValid(T expression);
}
