package via.script.intermediate;

import via.script.parser.ast.IExpression;
import via.script.parser.ast.IValue;
import via.script.runtime.RuntimeStack;

public interface IntermediateExpression
{
	IValue eval(RuntimeStack stack, IntermediateProgram program);
}
