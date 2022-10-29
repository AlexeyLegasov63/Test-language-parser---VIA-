package via.script.runtime;

import java.lang.Thread.State;

public class TraceElement
{
	private final String file, pass;
	private final int line;
	private State state;
	
	public TraceElement(String file, String pass, int line) {
		this.file = file;
		this.pass = pass;
		this.line = line;
	}
	
	public void printElement(StringBuilder builder) {
		builder.append("\t- ");
		builder.append(file + "." + pass);
		builder.append('\n');
	}
}
