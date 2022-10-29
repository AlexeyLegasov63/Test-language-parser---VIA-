package via.script.parser.ast.value;

import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;

public class NumberValue implements IValue
{
	private final Number value;
	public NumberValue(Number value) {
		this.value = value;
	}
	@Override
	public Number jNumber() {
		return value;
	}
	@Override
	public String jString() {
		return value.toString();
	}
	@Override
	public Character jCharacter() {
		return (char)value.intValue();
	}
	@Override
	public TypeIndifier getType() {
		return Type.NUMBER.asIndifier();
	}
	@Override
	public boolean equals(IValue object) {
		return object instanceof NumberValue && ((NumberValue)object).value == value;
	}
}
