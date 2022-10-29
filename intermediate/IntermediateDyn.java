package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;
import via.script.parser.ast.declare.DynamicVariable;
import via.script.parser.ast.value.NullptrValue;
import via.script.runtime.RuntimeStack;

public class IntermediateDyn implements IntermediateStatement
{
	public final String name;
	public final TypeIndifier type;
	
	public IntermediateDyn(String name, TypeIndifier type) {
		this.name = name;
		this.type = type;
	}
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		stack.increment(new DynamicVariable(type, name, NullptrValue.ZERO));
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "alt %0, [" + type + "," + name + "]\n\t";
	}
}
