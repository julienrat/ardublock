package com.ardublock.translator.block.dfrobot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class SharpGP2Y0A21 extends TranslatorBlock {
	
	public SharpGP2Y0A21(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
			TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);

	    	translator.addHeaderFile("DHT.h");
	    
	    	translator.addDefinitionCommand("DHT dht("+translatorBlock.toCode()+", DHT22);");
		translator.addSetupCommand("dht.begin();");
		String ret = "dht.readTemperature()";	
	
		
		return codePrefix + ret + codeSuffix;
	}

}
