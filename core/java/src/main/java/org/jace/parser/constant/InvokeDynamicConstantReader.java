package org.jace.parser.constant;

import org.jace.parser.ConstantPool;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class InvokeDynamicConstantReader implements ConstantReader
{
	private final static short TAG = 18;

	@Override
	public int getTag()
	{
		return TAG;
	}

	@Override
	public Constant readConstant(InputStream is, ConstantPool pool) throws ClassFormatError
	{
		int bootstrapMethodAttrIndex;
		int nameAndTypeIndex;

		try
		{
			bootstrapMethodAttrIndex = new DataInputStream(is).readUnsignedShort();
			nameAndTypeIndex = new DataInputStream(is).readUnsignedShort();
		}
		catch (IOException e)
		{
			ClassFormatError exception = new ClassFormatError("Unable to read the InvokeDynamic Constant");
			exception.initCause(e);
			throw exception;
		}

		return new InvokeDynamicConstant(bootstrapMethodAttrIndex, nameAndTypeIndex);
	}
}
