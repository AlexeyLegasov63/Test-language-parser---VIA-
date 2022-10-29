package via.script.parser.ast.statement;

import java.util.*;

import via.script.intermediate.IntermediateGoto;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.IExpression;
import via.script.parser.ast.IStatement;
import via.script.parser.ast.IWayCast;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class ExitStatement implements IStatement, IWayCast
{
	@Override
	public void accept(IVisitor visitor) {}

	private IntermediateGoto toEnd;
	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		toEnd = compiler.makeGoto(0);
	}
	@Override
	public void emit(IntermediateProgramBuilder compiler) {
		toEnd.label = compiler.peekWitness();
	}
}
