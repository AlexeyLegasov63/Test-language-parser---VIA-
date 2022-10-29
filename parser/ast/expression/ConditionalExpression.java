package via.script.parser.ast.expression;

import via.script.exception.RuntimeError;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.IAccessible;
import via.script.parser.ast.IExpression;
import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.value.*;
import via.script.parser.lexer.token.*;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class ConditionalExpression implements IExpression
{
	public final IExpression expression0, expression1;
	public final ConditionalOperator operator;
	
	public ConditionalExpression(IExpression expression0, IExpression expression1, ConditionalOperator operator) {
		this.expression0 = expression0;
		this.expression1 = expression1;
		this.operator = operator;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	public static enum ConditionalOperator
	{
		OR,
		AND,
		LTEQ,
		EQEQ,
		RTEQ,
		NTEQ,
		RT,
		LT,
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		expression0.expand(compiler);
		expression1.expand(compiler);
		compiler.makeCmp(operator);
	}
}
