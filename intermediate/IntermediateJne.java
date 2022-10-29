package via.script.intermediate;

import via.script.runtime.RuntimeStack;

public class IntermediateJne implements IntermediateStatement
{
	public IntermediateGoto value;
	
	/**
	 * @param label (When conditional is true)
	 */
	IntermediateJne(IntermediateGoto value) {
		this.value = value;
	}

	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		if (!stack.popValue().jBoolean()) return NEUTRAL;
		return value.label;
	}
	@Override
	public String toString() {
		return "equ %0,0 $- goto " + value.label + "\n\t";
	}
}
