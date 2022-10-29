package via.script.parser.ast.value;

import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;

public class NullptrValue implements IValue
{
	public static final NullptrValue ZERO = new NullptrValue();
	@Override
	public TypeIndifier getType() {
		return Type.IMPLICIT.asIndifier();
	}
	@Override
	public boolean equals(IValue object) {
		return object instanceof NullptrValue;
	}
}
