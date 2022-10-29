package via.script.parser.lexer.token;

public class HexLiteral extends NumberLiteral
{
	public HexLiteral(String value, int lineStart, int lineEnd, int columnStart, int columnEnd) {
		super(TokenType.HEX_NUMBER, Long.parseLong(value, 16), value, lineStart, lineEnd, columnStart, columnEnd);
	}
}
