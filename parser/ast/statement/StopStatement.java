package via.script.parser.ast.statement;

import java.util.*;

import via.script.intermediate.IntermediateGoto;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.IExpression;
import via.script.parser.ast.IStatement;
import via.script.parser.ast.IWayCast;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class StopStatement implements IStatement, IWayCast
{
	private IntermediateGoto toStart;
	@Override
	public void accept(IVisitor visitor) {}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		toStart = compiler.makeGoto(compiler.peekWitness());
	}
	@Override
	public void emit(IntermediateProgramBuilder compiler) {
	}
}
