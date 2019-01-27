package com.capita.string.calc.app.val;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.capita.string.calc.app.ops.Operation;

/**
 * Validator implementation to validate string expression
 * 
 * @author Avinash
 *
 */
@Component
public class StringExpressionValidator implements Validator<String> {

	@Autowired
	@Qualifier("operationMap")
	private Map<String, Operation<Integer, Integer, Integer>> operationMap;

	/**
	 * Validate up front
	 * @see com.capita.string.calc.app.val.Validator#isValid(java.lang.Object)
	 */
	@Override
	public Boolean isValid(String expression) {
		if (StringUtils.isEmpty(expression) || StringUtils.containsWhitespace(expression)
				|| isOperator(expression.charAt(0)) || isOperator(expression.charAt(expression.length() - 1))) {
			return false;
		}

		int openBraceCnt = 0;
		boolean lastWasOp = false;
		boolean lastWasOpen = false;

		for (char c : expression.toCharArray()) {
			if (c == '(') {
				openBraceCnt++;
				lastWasOpen = true;
				continue;
			} else if (c == ')') {
				if (openBraceCnt <= 0 || lastWasOp) {
					return false;
				}
				openBraceCnt--;
			} else if (isOperator(c)) {
				if (lastWasOp || lastWasOpen) {
					return false;
				}
				lastWasOp = true;
				continue;
			} else if (!isNumber(c)) {
				return false;
			}
			lastWasOp = false;
			lastWasOpen = false;
		}
		if (openBraceCnt != 0 || lastWasOp || lastWasOpen) {
			return false;
		}
		return true;
	}

	private boolean isOperator(char c) {
		return this.operationMap.keySet().contains(String.valueOf(c));
	}

	private boolean isNumber(char c) {
		return (int) c >= 48 && (int) c <= 57;
	}

}
