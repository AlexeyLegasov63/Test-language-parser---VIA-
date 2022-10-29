package via.script.exception;

import java.util.Properties;

import via.script.parser.CompileContext;
import via.script.parser.lexer.token.Token;
import via.script.runtime.RuntimeStack;
import via.script.runtime.error.ErrorReport;

public class RuntimeError extends RuntimeException
{
	public RuntimeError(CompileContext context, Token token) {
		super(String.format("Uknown error in executing the file! [%s & (%s:%s)]", context.getFile().getName(), token.getLineStart(), token.getColumnStart()));
	}
	public RuntimeError(CompileContext context, String token) {
		super(String.format("%s [%s & (?:?)]", token, context.getFile().getName()));
	}
	public RuntimeError(RuntimeStack stack, ErrorReport report) {
		super(throwMessage(stack, report.getProps()));
	}
	public RuntimeError(RuntimeStack stack, String message) {
		super(throwMessage(stack, message));
	}
	
	private static String throwMessage(RuntimeStack stack, Properties props) {
		StringBuilder builder = new StringBuilder();
		builder.append(props.get(ErrorReport.PROPERTY_CAUSE));
		builder.append(": ");
		builder.append(props.get(ErrorReport.PROPERTY_MESSAGE));
		stack.printStackTrace(builder.toString());
		return null;
	}
	private static String throwMessage(RuntimeStack stack, String message) {
		stack.printStackTrace(message);
		return null;
	}
}
