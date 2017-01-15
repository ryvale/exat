package com.exa.exat.expressions;

import java.util.Iterator;

import com.exa.expression.StackEvaluator;
import com.exa.expression.XPressionException;
import com.exa.parsing.ParsingEvent;

public class Evaluator extends StackEvaluator<Item<?>> {
	protected boolean scriptOn = false;

	public Evaluator() {
		super(new SubExpressionFactory());
	}
	
	public String evaluateWith(String currentWord, Iterator<ParsingEvent> it) throws XPressionException {
		push(currentWord);
		
		while(it.hasNext()) {
			ParsingEvent pev = it.next();
			if(pev.isParent()) continue;
			
			push(pev);
			
		}
		
		return compute().asSpecificItem().asOperand().asOPString().value();
	}
	
	protected void push(ParsingEvent pev) throws XPressionException {
		if(pev.valueIsNull()) return;
		push(pev.getWord());
	}

}
