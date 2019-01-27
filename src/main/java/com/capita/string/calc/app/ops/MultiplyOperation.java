package com.capita.string.calc.app.ops;

public class MultiplyOperation implements Operation<Integer, Integer, Integer> {

	@Override
	public Integer operate(Integer f, Integer s) {
		return Math.multiplyExact(f, s);
	}

	@Override
	public int getprecedence() {
		return 2;
	}
}
