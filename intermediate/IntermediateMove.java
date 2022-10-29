package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.runtime.RuntimeStack;

public class IntermediateMove implements IntermediateStatement
{
	public String push;
	
	public IntermediateMove(String push) {
		this.push = push;
	}

	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.getVariable(push).setValue(stack.popValue());
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "mov [" + push + "], %0\n\t";
	}
}
