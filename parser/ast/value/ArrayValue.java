package via.script.parser.ast.value;

import java.util.Arrays;

import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;

public class ArrayValue implements IValue
{
	private final IValue[] value;
	public ArrayValue(IValue[] value) {
		this.value = value;
	}
	public IValue[] jArray() {
		return value;
	}
	@Override
	public String jString() {
		return Arrays.toString(value);
	}
	@Override
	public TypeIndifier getType() {
		return Type.ARRAY.asIndifier();
	}
	@Override
	public boolean equals(IValue object) {
		return object instanceof ArrayValue && Arrays.equals(((ArrayValue)object).value, value);
	}
}
