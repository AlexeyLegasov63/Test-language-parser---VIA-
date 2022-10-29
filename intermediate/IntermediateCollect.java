package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.runtime.RuntimeStack;

public class IntermediateCollect implements IntermediateStatement
{
	public int push;
	
	public IntermediateCollect(int push) {
		this.push = push;
	}

	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.collect(push);
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "col " + push + "\n\t";
	}
}
