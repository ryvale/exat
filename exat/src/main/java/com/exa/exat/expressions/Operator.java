package com.exa.exat.expressions;

public interface Operator<T> extends com.exa.expression.Operator<Item<?>>, Item<T> {

	Operator<T> asSpecificItem();

}