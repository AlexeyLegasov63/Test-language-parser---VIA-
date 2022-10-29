package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.runtime.RuntimeStack;

public class IntermediateRemove implements IntermediateStatement
{
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.remove();
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "rem\n\t";
	}
}
