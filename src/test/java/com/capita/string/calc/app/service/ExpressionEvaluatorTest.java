package com.capita.string.calc.app.service;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.capita.string.calc.app.ApplicationConfigTest;
import com.capita.string.calc.app.ops.Operation;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = { ApplicationConfigTest.class})
public class ExpressionEvaluatorTest {
	
	@Autowired
	private Map<String, Operation<Integer, Integer, Integer>> operationMap;

	private ExpressionEvaluator expressionEvaluator;
	
	@Before
	public void setUp(){
		expressionEvaluator = new ExpressionEvaluator(operationMap);
	}

	@Test
	public void testEvaluate() throws Exception {
		expressionEvaluator.evaluate("1+4");
	}

	@Test
	public void testEvaluatorWithInvalidExpression() throws Exception {
		expressionEvaluator.evaluate("1+");
	}

}
