package org.jace.parser.constant;

import java.io.DataOutputStream;
import java.io.IOException;

public class MethodTypeConstant implements Constant
{
	private final int descriptorIndex;

	public MethodTypeConstant(int descriptorIndex)
	{
		this.descriptorIndex = descriptorIndex;
	}

	public int getDescriptorIndex()
	{
		return descriptorIndex;
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
		output.writeByte(new MethodTypeConstantReader().getTag());
		output.writeShort(descriptorIndex);
	}
}
