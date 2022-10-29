package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.parser.ast.value.NumberValue;
import via.script.runtime.RuntimeStack;

public class IntermediatePst implements IntermediateStatement
{
	private int opt;
	
	public IntermediatePst(int opt) {
		this.opt = opt;
	}
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "pst\n\t";
	}
}
