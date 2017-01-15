package com.exa.exat;

import com.exa.buffer.ReadingBuffer;
import com.exa.lexing.Language;
import com.exa.lexing.WordIterator;
import com.exa.parsing.ExpMan;
import com.exa.parsing.Parser;
import com.exa.utils.ManagedException;

public class Generator extends Parser<ReadingBuffer> {
	protected OutputMan outputMan;

	public Generator(Language language, OutputMan outputMan) {
		super(language);
		this.outputMan = outputMan;
	}
	
	public Generator(Language language) { this(language, null); }

	@Override
	public ExpMan<ReadingBuffer> createExpMan(WordIterator wi) throws ManagedException {
		return new ExpSolver(outputMan);
	}

	@Override
	public ReadingBuffer parse(WordIterator wi, ExpMan<ReadingBuffer> ires) throws ManagedException {
		outputMan.open();
		ReadingBuffer res = super.parse(wi, ires);
		outputMan.close();
		
		return res;
	}
	
	


}
