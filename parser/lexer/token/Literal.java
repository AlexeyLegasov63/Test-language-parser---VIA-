package via.script.parser.lexer.token;

public class Literal extends Token
{
	protected final String value;
	public Literal(TokenType tokenType, String value, int lineStart, int lineEnd, int columnStart, int columnEnd) {
		super(tokenType, lineStart, lineEnd, columnStart, columnEnd);
		this.value = value;
	}
	public String getLiteral() {
		return value;
	}
}
