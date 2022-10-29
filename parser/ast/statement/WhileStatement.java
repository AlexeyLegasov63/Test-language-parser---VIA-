package via.script.parser.ast.statement;

import java.util.*;

import via.script.intermediate.IntermediateGoto;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.*;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class WhileStatement implements IStatement
{
	public final IExpression expression;
	public final IStatement statement;
	public int startL, endL;
	
	public WhileStatement(IExpression expression, IStatement statement) {
		this.expression = expression;
		this.statement = statement;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		startL = compiler.witness(compiler.getLabel());
		expression.expand(compiler);
		IntermediateGoto whileEnd = compiler.makeGoto();
		compiler.makeEquals(whileEnd);	// Start
		statement.expand(compiler);  
		compiler.makeGoto(startL);
		whileEnd.label = compiler.getLabel();
		compiler.popWitness();
		endL = compiler.getLabel();
	}


	@Override
	public void emit(IntermediateProgramBuilder compiler) {
		compiler.witness(endL);
		statement.emit(compiler);
		compiler.popWitness();
	}
}
