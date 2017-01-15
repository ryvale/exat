package com.exa.exat.expressions;

public interface Statement<T> extends com.exa.expression.Operator<Item<?>>, Item<T> {
	Statement<T> asSpecificItem();
}
