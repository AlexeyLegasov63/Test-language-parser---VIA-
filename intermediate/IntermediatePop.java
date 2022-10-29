package via.script.intermediate;

import via.script.runtime.RuntimeStack;

public class IntermediatePop implements IntermediateStatement
{
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.popValue();
		return NEUTRAL;
	}
	
	@Override
	public String toString() {
		return "poc %0\n\t";
	}
}
