package com.capita.string.calc.app.ops;

public class SubstractOperation implements Operation<Integer, Integer, Integer> {

	@Override
	public Integer operate(Integer f, Integer s) {
		return Math.subtractExact(f, s);
	}
	
	@Override
	public int getprecedence() {
		return 1;
	}
}
