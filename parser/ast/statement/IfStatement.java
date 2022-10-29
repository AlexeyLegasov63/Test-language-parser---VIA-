package via.script.parser.ast.statement;

import java.util.*;

import via.script.intermediate.IntermediateGoto;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.*;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class IfStatement implements IStatement
{
	public final IExpression expression;
	public final IStatement statement, unless;
	
	public IfStatement(IExpression expression, IStatement statement, IStatement unless) {
		this.expression = expression;
		this.statement = statement;
		this.unless = unless;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		IntermediateGoto ifEnd = compiler.makeGoto();
		expression.expand(compiler);
		compiler.makeEquals(ifEnd);
		statement.expand(compiler);
		ifEnd.label = compiler.getLabel();
		if (unless != null) {
			//IntermediateGoto elseEnd = compiler.makeGoto();
			unless.expand(compiler);
			//elseEnd.label = compiler.getLabel();
		}
	}

	@Override
	public void emit(IntermediateProgramBuilder compiler) {
		statement.emit(compiler);
		if (unless != null) {
			unless.emit(compiler);
		}
	}
}
