package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.parser.ast.value.NumberValue;
import via.script.runtime.RuntimeStack;

public class IntermediateRow implements IntermediateStatement
{
	private final int row;
	
	public IntermediateRow(int row) {
		this.row = row;
	}
	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		program.line = row;
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "nline " + row + "\n\t";
	}
}
