package com.ardublock.translator.block.makeblock;
import com.ardublock.translator.Translator;
import com.ardublock.translator.block.TranslatorBlock;
import com.ardublock.translator.block.exception.SocketNullException;
import com.ardublock.translator.block.exception.SubroutineNotDeclaredException;

public class MeBluetoothWrite extends TranslatorBlock {

	public MeBluetoothWrite(Long blockId, Translator translator, String codePrefix, String codeSuffix, String label) {
		super(blockId, translator, codePrefix, codeSuffix, label);
	}

	@Override
	public String toCode() throws SocketNullException, SubroutineNotDeclaredException {
		
		translator.addHeaderFile("SoftwareSerial.h");
		
		TranslatorBlock block = this.getRequiredTranslatorBlockAtSocket(0);
		
		String ret = "SoftwareSerial blueToothSerial(3,4);";
		translator.addDefinitionCommand(ret);
		translator.addSetupCommand("blueToothSerial.begin(38400);");
		TranslatorBlock dataBlock = this.getRequiredTranslatorBlockAtSocket(1);
		return "blueToothSerial.write("+dataBlock.toCode()+");\n";
	}

}
