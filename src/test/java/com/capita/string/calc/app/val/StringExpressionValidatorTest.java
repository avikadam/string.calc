package com.capita.string.calc.app.val;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.junit4.SpringRunner;

import com.capita.string.calc.app.ApplicationConfigTest;

@RunWith(SpringRunner.class)
@SpringJUnitConfig(classes = {ApplicationConfigTest.class, StringExpressionValidator.class})
public class StringExpressionValidatorTest {

	@Autowired
	private Validator<String> stringExpressionValidator;
	
	@Test
	public final void testValidExpression() throws Exception {
		Assert.assertTrue("Valid expression", stringExpressionValidator.isValid("(3+4)"));
	}
	
	@Test()
	public final void testInvalidValid() throws Exception {
		Assert.assertFalse("Valid expression", stringExpressionValidator.isValid("3+4)"));
	}
	

}
