package via.script.intermediate;

import via.script.parser.ast.IPass;
import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.runtime.RuntimeStack;

public class IntermediateCallback implements IntermediateStatement
{
	private final String name;
	private final int arguments;
	public IntermediateCallback(String name, int n) {
		this.name = name;
		this.arguments = n;
	}
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		IPass pass = (IPass) stack.getNode(name, arguments);
		IValue[] args = new IValue[stack.top()];
		for (int i = 0; i < stack.top(); i++) {
			args[i] = stack.popValue();
		}
		stack.push(pass.invoke(stack, args));
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "call [" + name + "," + arguments +"]\n\t";
	}
}
