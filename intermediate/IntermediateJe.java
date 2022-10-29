package via.script.intermediate;

import via.script.runtime.RuntimeStack;

public class IntermediateJe implements IntermediateStatement
{
	public IntermediateGoto value;
	
	/**
	 * @param label (When conditional is true)
	 */
	IntermediateJe(IntermediateGoto value) {
		this.value = value;
	}

	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		if (stack.popValue().jBoolean()) return NEUTRAL;
		return value.label;
	}
	@Override
	public String toString() {
		return "equ %0,1 $- goto " + value.label + "\n\t";
	}
}
