package com.capita.string.calc.app.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.capita.string.calc.app.ApplicationConfigTest;
import com.capita.string.calc.app.exception.InvalidExpressionException;
import com.capita.string.calc.app.val.StringExpressionValidator;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = { ApplicationConfigTest.class, StringExpressionValidator.class, CalculatorServiceImpl.class })
public class CalculatorServiceImplTest {

	@Autowired
	private CalculatorService calculatorService;

	@Test
	public void testCalculate() throws Exception {
		calculatorService.calculate("(9+6)");
	}

	@Test(expected = InvalidExpressionException.class)
	public void testException() throws Exception {
		calculatorService.calculate("9+6");
	}

}
