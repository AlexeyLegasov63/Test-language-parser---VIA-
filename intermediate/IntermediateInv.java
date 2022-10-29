package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.parser.ast.value.*;
import via.script.runtime.RuntimeStack;

public class IntermediateInv implements IntermediateStatement
{
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.push(new BooleanValue(!stack.popValue().jBoolean()));
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "inv\n\t";
	}
}
