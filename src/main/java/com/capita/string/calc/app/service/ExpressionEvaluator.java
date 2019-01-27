package com.capita.string.calc.app.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.capita.string.calc.app.exception.InvalidExpressionException;
import com.capita.string.calc.app.ops.Operation;

/**
 * Evaluate string mathematical expression
 * 
 * @author avinahk
 *
 */
public class ExpressionEvaluator {

	private final Map<String, Operation<Integer, Integer, Integer>> operationMap;
	private final ExpressionTokenStack operators;
	private final ExpressionTokenStack values;

	public ExpressionEvaluator(Map<String, Operation<Integer, Integer, Integer>> operationMap) {
		this.operationMap = operationMap;
		this.operators = new ExpressionTokenStack();
		this.values = new ExpressionTokenStack();
	}

	public Integer evaluate(String input) {
		final List<ExpressionToken> tokens = Arrays.asList(input.split("(?=[()-+/*])|(?<=[()-+/*])")).stream()
				.map(item -> new ExpressionToken(String.valueOf(item))).collect(Collectors.toList());

		for (final ExpressionToken nextToken : tokens) {
			if (nextToken.getType() == ExpressionTokenType.NUMBER.getType()) {
				this.values.push(nextToken);
			} else if (nextToken.getType() == ExpressionTokenType.OPERATOR.getType()) {
				if (this.operators.isEmpty() || nextToken.getPrecedence() > this.operators.top().getPrecedence()) {
					this.operators.push(nextToken);
				} else {
					while (!this.operators.isEmpty()
							&& nextToken.getPrecedence() <= this.operators.top().getPrecedence()) {
						final ExpressionToken toProcess = this.operators.popTop();
						this.processOperator(toProcess);
					}
					this.operators.push(nextToken);
				}
			} else if (nextToken.getType() == ExpressionTokenType.LEFT_PARENTHESIS.getType()) {
				this.operators.push(nextToken);
			} else if (nextToken.getType() == ExpressionTokenType.RIGHT_PARENTHESIS.getType()) {
				while (!this.operators.isEmpty()
						&& this.operators.top().getType() == ExpressionTokenType.OPERATOR.getType()) {
					final ExpressionToken toProcess = this.operators.popTop();
					this.processOperator(toProcess);
				}
				if (!this.operators.isEmpty()
						&& this.operators.top().getType() == ExpressionTokenType.LEFT_PARENTHESIS.getType()) {
					this.operators.pop();
				} else {
					throw new InvalidExpressionException("Error: unbalanced parenthesis.");
				}
			}
		}

		while (!this.operators.isEmpty() && this.operators.top().getType() == ExpressionTokenType.OPERATOR.getType()) {
			final ExpressionToken toProcess = this.operators.popTop();
			this.processOperator(toProcess);
		}

		final ExpressionToken result = this.values.popTop();
		if (!this.operators.isEmpty() || !this.values.isEmpty()) {
			throw new InvalidExpressionException("Expression error.");
		} else {
			return result.getValue();
		}
	}

	private void processOperator(ExpressionToken t) {
		final ExpressionToken a = this.values.popTop();
		final ExpressionToken b = this.values.popTop();
		final ExpressionToken R = new ExpressionToken(
				this.operationMap.get(t.getOperator()).operate(a.getValue(), b.getValue()));
		this.values.push(R);
	}

}
