package com.exa.exat.expressions;

import com.exa.expression.StackEvaluator;
import com.exa.expression.XPressionException;

public class ExpressionOperand extends com.exa.expression.ExpressionOperand<Item<?>> implements Operand<Object> {

	public ExpressionOperand(StackEvaluator<Item<?>> evaluator) {
		super(evaluator);
	}

	@Override
	public Object value() throws XPressionException {
		return evaluator.compute().asSpecificItem().asOperand().value();
	}
	
	@Override
	public ExpressionOperand asSpecificItem() { return this; }
	
	@Override
	public ExpressionOperand asOperand() { return this; }
	
	@Override
	public Operator<Object> asOperator() { return null; }

	@Override
	public Operand<String> asOPString() { return null; }

	@Override
	public Operand<String> asOPIdentifier() { return null; }

	@Override
	public ExpressionOperand asExpressionOperand() { return this; }

	@Override
	public Operand<Integer> asOPInteger() { return null; }
	
}
