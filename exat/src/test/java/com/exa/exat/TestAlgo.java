package com.exa.exat;

import java.io.IOException;

import com.exa.buffer.ReadingBuffer;
import com.exa.parsing.ebnf.CompiledRule;
import com.exa.parsing.ebnf.RuleParser;
import com.exa.parsing.ebnf.predefs.PreParser;
import com.exa.utils.ManagedException;

public class TestAlgo {

	public static String parseRAMTextOutput(OutputMan om, String strToParse) throws ManagedException, IOException {
		RuleParser  ebnfParser = new RuleParser(new PreParser().addCommonParsingEntity("LX_ID", PreParser.PE_LX_IDENTIFIER).addCommonParsingEntity("LX_INT", PreParser.PE_LX_INTEGER).parseFile("C:/recherches/exat/exat/src/main/java/com/exa/exat/default0.2.parser"), false);
    	CompiledRule cr = ebnfParser.parse(ebnfParser.getRulesConfig().getRule("root").src());
    	
    	Generator gen = new Generator(cr.language(), om);
		
    	ReadingBuffer res  = gen.parse(strToParse);
    	
    	return res.string();
	}
	
	public static String parseFileTextOutput(OutputMan om, String fileName) throws ManagedException, IOException {
		RuleParser  ebnfParser = new RuleParser(new PreParser().addCommonParsingEntity("LX_ID", PreParser.PE_LX_IDENTIFIER).addCommonParsingEntity("LX_INT", PreParser.PE_LX_INTEGER).parseFile("C:/recherches/exat/exat/src/main/java/com/exa/exat/default0.2.parser"), false);
    	CompiledRule cr = ebnfParser.parse(ebnfParser.getRulesConfig().getRule("root").src());
    	
    	Generator gen = new Generator(cr.language(), om);
		
    	ReadingBuffer res  = gen.parseFile(fileName);
    	
    	return res.string();
	}
}
