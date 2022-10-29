package via.script.parser.lexer.token;

public class DoubleLiteral extends NumberLiteral
{
	public DoubleLiteral(String value, int lineStart, int lineEnd, int columnStart, int columnEnd) {
		super(TokenType.REAL_NUMBER, Double.parseDouble(value), value, lineStart, lineEnd, columnStart, columnEnd);
	}
}
