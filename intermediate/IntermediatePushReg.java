package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.runtime.RuntimeStack;

public class IntermediatePushReg implements IntermediateStatement
{
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.push();
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "pushc %1\n\t";
	}
}
