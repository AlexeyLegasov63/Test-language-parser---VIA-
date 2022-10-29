package via.script.parser.lexer.token;

import via.script.parser.ast.Type;

public class TypeLiteral extends Literal
{
	private final Type type;
	public TypeLiteral(String value, int lineStart, int lineEnd, int columnStart, int columnEnd) {
		super(TokenType.IMPLICIT, value, lineStart, lineEnd, columnStart, columnEnd);
		switch(value) {
			case "number": type = Type.NUMBER; break;
			case "string": type = Type.STRING; break;
			case "boolean":
			case "bool": type = Type.BOOLEAN; break;
			case "char": type = Type.CHARACTER; break;
			case "array": type = Type.ARRAY; break;
			default: type = Type.IMPLICIT; break;
		}
	}
	public Type getType() {
		return type;
	}
	public String getString() {
		return value;
	}
}
