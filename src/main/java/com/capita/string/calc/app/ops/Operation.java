package com.capita.string.calc.app.ops;

public interface Operation<R, F, S> {
	public R operate(F f, S s);
	public int getprecedence();
}
