package via.script.exception;

import java.util.Properties;

import via.script.parser.CompileContext;
import via.script.parser.lexer.token.Token;
import via.script.runtime.RuntimeStack;
import via.script.runtime.error.ErrorReport;

public class NoSuchPassError extends RuntimeError
{
	static final ErrorReport report;
	static {
		report = new ErrorReport();
		report.getProps().setProperty(ErrorReport.PROPERTY_CAUSE, "root.errors.NoSuchPassError");
		report.getProps().setProperty(ErrorReport.PROPERTY_MESSAGE, ErrorReport.MESSAGE_INSTANCE_PASS_ACCESS);
	}
	
	public NoSuchPassError(RuntimeStack stack) {
		super(stack, report);
	}
}
