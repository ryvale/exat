package com.exa.exat.expressions;

import com.exa.expression.XPressionException;

public interface Operand<T> extends com.exa.expression.Operand<Item<?>>, Item<T> {

	T value() throws XPressionException;

	Operand<T> asSpecificItem();

	Operand<String> asOPString();

	Operand<String> asOPIdentifier();
	
	Operand<Integer> asOPInteger();
	
	ExpressionOperand asExpressionOperand();

}