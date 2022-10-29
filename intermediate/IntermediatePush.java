package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.runtime.RuntimeStack;

public class IntermediatePush implements IntermediateStatement
{
	public IValue push;
	
	public IntermediatePush(IValue push) {
		this.push = push;
	}

	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.push(push);
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "push %0, " + push.jString() + "\n\t";
	}
}
