package com.ardublock.translator.block.seeedstudio;

import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class seeed_temperature_sensor extends TranslatorBlock {
	
	public seeed_temperature_sensor(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
		TranslatorBlock translatorBlock = this.getRequiredTranslatorBlockAtSocket(0); //option numéro de pin du capteur
	   	translator.addHeaderFile("DHT.h"); // code inséré au début ( avant le setup pour charger la bibliotheque ), sous la forme #include 
	   	translator.addDefinitionCommand("DHT dht("+translatorBlock.toCode()+", DHT22);"); //code inséré avant le setup, avec le numéro de pin, ici on cree l'objet dht
		translator.addSetupCommand("dht.begin();"); // code dans le setup (on demarre le dth22)
		String ret = "dht.readTemperature()";	// chaine retournée utilisable dans le code			
		return codePrefix + ret + codeSuffix; 
	}
}
