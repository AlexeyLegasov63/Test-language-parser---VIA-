package via.script.parser.ast;

public interface IValue
{
	default Number jNumber() {
		throw new RuntimeException(this.toString());
	}
	default Exception jException() {
		throw new RuntimeException();
	}
	default String jString() {
		throw new RuntimeException();
	}
	default Character jCharacter() {
		throw new RuntimeException();
	}
	default Boolean jBoolean() {
		throw new RuntimeException();
	}
	default IValue[] jArray() {
		throw new RuntimeException();
	}
	
	boolean equals(IValue object);
	TypeIndifier getType();
}
