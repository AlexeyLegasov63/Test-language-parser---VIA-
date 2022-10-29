package via.script.parser.lexer.token;

public abstract class NumberLiteral extends Literal
{
	private final Number number;
	
	NumberLiteral(TokenType tokenType, Number number, String value, int lineStart, int lineEnd, int columnStart, int columnEnd) {
		super(tokenType, value, lineStart, lineEnd, columnStart, columnEnd);
		this.number = number;
	}

	public Number getNumber() {
		return number;
	}
}
