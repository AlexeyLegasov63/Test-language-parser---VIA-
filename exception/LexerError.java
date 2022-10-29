package via.script.exception;

import via.script.parser.CompileContext;

public class LexerError extends ParseError
{
	public LexerError(CompileContext context, int line, int column) {
		super(context, line, column);
	}
}
