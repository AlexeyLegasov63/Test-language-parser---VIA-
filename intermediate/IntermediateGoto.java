package via.script.intermediate;

import via.script.runtime.RuntimeStack;

public class IntermediateGoto implements IntermediateStatement
{
	public int label;
	
	public IntermediateGoto(int label) {
		this.label = label;
	}

	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		return label;
	}
	@Override
	public String toString() {
		return "goto " + label + "\n\t";
	}
}
