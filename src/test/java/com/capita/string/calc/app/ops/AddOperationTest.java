package com.capita.string.calc.app.ops;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AddOperationTest {

	private Operation<Integer, Integer, Integer> ops;
	
	@Before
	public void setUp(){
		ops = new AddOperation();
	}
	
	@Test
	public void testOperate() throws Exception {
		Assert.assertSame(11, ops.operate(1, 10));
	}
	
	@Test
	public void testGetprecedence() throws Exception {
		Assert.assertSame(1, ops.getprecedence());
	}

}
