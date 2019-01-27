package com.capita.string.calc.app.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.capita.string.calc.app.exception.InvalidExpressionException;
import com.capita.string.calc.app.ops.Operation;
import com.capita.string.calc.app.val.Validator;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	@Autowired
	@Qualifier("stringExpressionValidator")
	private Validator<String> validator;

	@Autowired
	@Qualifier("operationMap")
	private Map<String, Operation<Integer, Integer, Integer>> operationMap;

	@Override
	public void calculate(String expression) {
		if (!validator.isValid(expression)) {
			System.out.println("Invalid input expression");
			throw new InvalidExpressionException("Invalid input expression");
		}
		Integer result = new ExpressionEvaluator(operationMap).evaluate(expression);
		System.out.println(String.format("Test case for expression '%s' has passed", expression));
		System.out.println("Result = " + result);
	}

}
