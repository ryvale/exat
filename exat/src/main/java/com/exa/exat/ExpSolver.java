package com.exa.exat;

import java.util.Iterator;
import java.util.List;

import com.exa.buffer.ReadingBuffer;
import com.exa.exat.expressions.Evaluator;
import com.exa.parsing.ExpMan;
import com.exa.parsing.ParsingEntity;
import com.exa.parsing.ParsingEvent;
import com.exa.utils.ManagedException;

public class ExpSolver extends ExpMan<ReadingBuffer> {
	public static final String SCRIPT_START = "@{";
	//private ByteBuffer res;
	//private boolean scriptOn = false;
	protected Evaluator eval;
	protected OutputMan outputMan;
	//protected Buffer buffer;
	
	public ExpSolver(OutputMan outputMan) {
		super(null);
		
		this.outputMan = outputMan;
		eval = new Evaluator();
	}
	
	@Override
	public ParsingEntity push(ParsingEntity currentPE, List<ParsingEvent> pevs) throws ManagedException {
		Iterator<ParsingEvent> it = pevs.iterator();
		while(it.hasNext()) {
			ParsingEvent pev = it.next();
			if(pev.isParent()) continue;
			
			if(pev.valueIsNull()) continue;
			
			String word = pev.getWord();
			if(SCRIPT_START.equals(word)) word = eval.evaluateWith(word, it);
			
			outputMan.write(word);
			
			
		}
		/*for(ParsingEvent pev : pevs) {
			if(pev.isParent()) continue;
			
			String word = pev.getWord();
			if(scriptOn) {
				eval.push(word);
				continue;
			}
			
			if(SCRIPT_START.equals(word)) {	scriptOn = true; continue; }
			
			try {
				outputMan.write(word);
			} catch (IOException e) {
				e.printStackTrace();
				throw new ManagedException(e);
			}
		}*/
		
		return currentPE;
	}
	
	@Override
	public ReadingBuffer compute() throws ManagedException {
		return outputMan.result();
		
	}
	
}
