package via.script.parser.lexer.token;

public class CharacterLiteral extends NumberLiteral
{
	public CharacterLiteral(TokenType tokenType, String value, int lineStart, int lineEnd, int columnStart, int columnEnd) {
		super(tokenType, (int)value.charAt(0), value, lineStart, lineEnd, columnStart, columnEnd);
	}
	
	public Character getCharacter() {
		return (char)getNumber().intValue();
	}
}
