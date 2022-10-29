package via.script.parser.ast.value;

import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;

public class CharacterValue implements IValue
{
	private final Character value;
	public CharacterValue(Character value) {
		this.value = value;
	}
	@Override
	public Number jNumber() {
		return (int)value;
	}
	@Override
	public String jString() {
		return value.toString();
	}
	@Override
	public Character jCharacter() {
		return value;
	}
	@Override
	public TypeIndifier getType() {
		return Type.CHARACTER.asIndifier();
	}
	@Override
	public boolean equals(IValue object) {
		return object instanceof CharacterValue && ((CharacterValue)object).value == value;
	}
}
