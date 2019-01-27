package com.capita.string.calc.app.ops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SubstractOperationTest {

	private Operation<Integer, Integer, Integer> ops;

	@Before
	public void setUp(){
		ops = new SubstractOperation();
	}
	
	@Test
	public void testOperate() throws Exception {
		Assert.assertTrue(5 == ops.operate(15, 10));
	}
	
	@Test
	public void testGetprecedence() throws Exception {
		Assert.assertTrue(1 == ops.getprecedence());
	}

}
