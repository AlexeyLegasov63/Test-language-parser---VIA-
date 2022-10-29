package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.runtime.RuntimeStack;

public class IntermediatePopReg implements IntermediateStatement
{
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.pop();
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "popc %1\n\t";
	}
}
