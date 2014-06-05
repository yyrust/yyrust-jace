package org.jace.parser.constant;

import java.io.DataOutputStream;
import java.io.IOException;

public class MethodHandleConstant implements Constant
{
	private final int referenceKind;
	private final int referenceIndex;

	public MethodHandleConstant(int referenceKind, int referenceIndex)
	{
		this.referenceKind = referenceKind;
		this.referenceIndex = referenceIndex;
	}

	public int getReferenceKind()
	{
		return referenceKind;
	}

	public int getReferenceIndex()
	{
		return referenceIndex;
	}

	@Override
	public Object getValue()
	{
		return "Not yet implemented.";
	}

	@Override
	public int getSize()
	{
		return 1;
	}

	@Override
	public void write(DataOutputStream output) throws IOException
	{
		output.writeByte(new MethodHandleConstantReader().getTag());
		output.writeByte(referenceKind);
		output.writeShort(referenceIndex);
	}
}
