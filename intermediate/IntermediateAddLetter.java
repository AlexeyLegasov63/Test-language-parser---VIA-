package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.parser.ast.value.LetterValue;
import via.script.parser.ast.value.NumberValue;
import via.script.runtime.RuntimeStack;

public class IntermediateAddLetter implements IntermediateStatement
{
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		IValue value = stack.peek();
		stack.pop();
		IValue value2 = stack.peek();
		stack.pop();
		stack.push(new LetterValue(value.jString() + value2.jString()));
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "addl\n\t";
	}
}
