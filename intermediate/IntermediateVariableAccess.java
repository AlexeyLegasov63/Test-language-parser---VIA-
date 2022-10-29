package via.script.intermediate;

import via.script.parser.ast.IVariable;
import via.script.parser.ast.value.LetterValue;
import via.script.runtime.RuntimeStack;

public class IntermediateVariableAccess implements IntermediateStatement
{
	public String name;
	
	public IntermediateVariableAccess(String name) {
		this.name = name;
	}

	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		IVariable variable = stack.getVariable(name);
		if (variable == null) return EXCEPTION_UKNOWN_VARIABLE;
		stack.push(variable.getValue());
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "acs %0," + name + "\n\t";
	}
}
