package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.parser.ast.value.NumberValue;
import via.script.runtime.RuntimeStack;

public class IntermediateAdd implements IntermediateStatement
{
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		IValue value = stack.peek();
		stack.pop();
		IValue value2 = stack.peek();
		stack.pop();
		stack.push(new NumberValue(value.jNumber().doubleValue() + value2.jNumber().doubleValue()));
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "add\n\t";
	}
}
