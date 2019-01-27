package com.capita.string.calc.app.ops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DivideOperationTest {

	private Operation<Integer, Integer, Integer> ops;
	
	@Before
	public void setUp(){
		ops = new DivideOperation();
	}
	
	@Test
	public void testOperate() throws Exception {
		Assert.assertSame(1, ops.operate(15, 10));
	}
	
	@Test
	public void testGetprecedence() throws Exception {
		Assert.assertSame(2, ops.getprecedence());
	}
}
