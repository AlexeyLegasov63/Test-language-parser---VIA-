package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.parser.ast.value.NumberValue;
import via.script.runtime.RuntimeStack;

public class IntermediateNeg implements IntermediateStatement
{
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.push(new NumberValue(-stack.popValue().jNumber().doubleValue()));
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "neg\n\t";
	}
}
