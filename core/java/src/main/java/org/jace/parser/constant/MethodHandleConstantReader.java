package org.jace.parser.constant;

import org.jace.parser.ConstantPool;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MethodHandleConstantReader implements ConstantReader
{
	private final static short TAG = 15;

	@Override
	public int getTag()
	{
		return TAG;
	}

	@Override
	public Constant readConstant(InputStream is, ConstantPool pool) throws ClassFormatError
	{
		int referenceKind;
		int referenceIndex;

		try
		{
			referenceKind = new DataInputStream(is).readUnsignedByte();
			referenceIndex = new DataInputStream(is).readUnsignedShort();
		}
		catch (IOException e)
		{
			ClassFormatError exception = new ClassFormatError("Unable to read the MethodHandle Constant");
			exception.initCause(e);
			throw exception;
		}

		return new MethodHandleConstant(referenceKind, referenceIndex);
	}
}
