package via.script.parser.lexer.token;

public class IntLiteral extends NumberLiteral
{
	public IntLiteral(String value, int lineStart, int lineEnd, int columnStart, int columnEnd) {
		super(TokenType.DECIMAL_NUMBER, Integer.parseInt(value), value, lineStart, lineEnd, columnStart, columnEnd);
	}
}
