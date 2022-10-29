package via.script.parser.ast.value;

import java.util.Arrays;

import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;

public class BooleanValue implements IValue
{
	private final Boolean value;
	public BooleanValue(Boolean value) {
		this.value = value;
	}
	@Override
	public Boolean jBoolean() {
		return value;
	}
	@Override
	public String jString() {
		return value.toString();
	}
	@Override
	public TypeIndifier getType() {
		return Type.BOOLEAN.asIndifier();
	}
	@Override
	public boolean equals(IValue object) {
		return object instanceof BooleanValue && ((BooleanValue)object).value == value;
	}
}
