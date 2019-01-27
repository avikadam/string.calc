package com.capita.string.calc.app.ops;

public class AddOperation implements Operation<Integer, Integer, Integer> {

	@Override
	public Integer operate(Integer f, Integer s) {
		return Math.addExact(f, s);
	}
	
	@Override
	public int getprecedence() {
		return 1;
	}

}
