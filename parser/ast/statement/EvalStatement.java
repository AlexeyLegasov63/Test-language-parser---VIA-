package via.script.parser.ast.statement;

import java.util.*;

import via.script.intermediate.IntermediateGoto;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.IExpression;
import via.script.parser.ast.IStatement;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class EvalStatement implements IStatement
{
	public final IExpression expression;
	
	public EvalStatement(IExpression expression) {
		this.expression = expression;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		expression.expand(compiler);
	}

}
