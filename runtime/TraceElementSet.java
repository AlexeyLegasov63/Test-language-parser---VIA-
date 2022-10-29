package via.script.runtime;

import via.script.parser.ast.IPass;

public class TraceElementSet
{
	final TraceElement[] elements = new TraceElement[0x80];
	private int position;
	
	public void pop() {
		elements[--position] = null;
	}
	public void push(IPass pass, int row) {
		elements[position++] = new TraceElement(pass.getFile(), pass.getName(), row);
	}
	public void push(String file, String desc, int row) {
		elements[position++] = new TraceElement(file, desc, row);
	}
	public void printElements() {
		printElements("Uknown");
	}
	public void printElements(String cause) {
		StringBuilder builder = new StringBuilder(cause + ":\n");
		for (int i = 0; i < position; i++) {
			elements[i].printElement(builder);
		}
		System.out.println(builder);
	}
}
