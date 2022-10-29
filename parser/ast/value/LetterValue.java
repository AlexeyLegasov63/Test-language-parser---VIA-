package via.script.parser.ast.value;

import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;

public class LetterValue implements IValue
{
	private final String value;
	public LetterValue(String value) {
		this.value = value;
	}
	@Override
	public String jString() {
		return value.toString().replaceAll("\n", "").replaceAll("\r", "").replaceAll("\t", "");
	}
	@Override
	public TypeIndifier getType() {
		return Type.STRING.asIndifier();
	}
	@Override
	public boolean equals(IValue object) {
		return object instanceof LetterValue && ((LetterValue)object).value == value;
	}
}
