package via.script.exception;

import via.script.parser.CompileContext;
import via.script.parser.lexer.token.Token;

public class ParseError extends RuntimeException
{
	public ParseError(CompileContext context, int line, int column) {
		super(String.format("Uknown error in parsing the file! [%s & (%s:%s)]", context.getFile().getName(), line, column));
	}
	public ParseError(CompileContext context, Token token) {
		super(String.format("Uknown error in parsing the file! [%s & (%s:%s)]", context.getFile().getName(), token.getLineStart(), token.getColumnStart()));
	}
}
