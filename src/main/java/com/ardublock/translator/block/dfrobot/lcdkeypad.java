package com.ardublock.translator.block.dfrobot;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class lcdkeypad extends TranslatorBlock {
	
	public lcdkeypad(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label)
	{
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	//@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException
	{
		// r�cup�ration des param�tres du module, ici le message plac� en rang 0
		// on �crit donc le code �  g�n�rer
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0);
		// cr�ation du texte de code correspondant
		translator.addHeaderFile("DHT.h");
		translator.addSetupCommand("DHT dht(2, DHT22);");
		String ret = "dht.readTemperature()";
		return ret;
	}
	
}
