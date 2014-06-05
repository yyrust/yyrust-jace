package org.jace.parser.constant;

import java.io.DataOutputStream;
import java.io.IOException;

public class InvokeDynamicConstant implements Constant
{
	private final int bootstrapMethodAttrIndex;
	private final int nameAndTypeIndex;

	public InvokeDynamicConstant(int bootstrapMethodAttrIndex, int nameAndTypeIndex)
	{
		this.bootstrapMethodAttrIndex = bootstrapMethodAttrIndex;
		this.nameAndTypeIndex = nameAndTypeIndex;
	}

	public int getBootstrapMethodAttrIndex()
	{
		return bootstrapMethodAttrIndex;
	}

	public int getNameAndTypeIndex()
	{
		return nameAndTypeIndex;
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
		output.writeByte(new InvokeDynamicConstantReader().getTag());
		output.writeShort(bootstrapMethodAttrIndex);
		output.writeShort(nameAndTypeIndex);
	}
}
