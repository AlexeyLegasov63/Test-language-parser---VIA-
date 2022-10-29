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

public class BinaryExpression implements IExpression
{
	public final IExpression expression0, expression1;
	public final BinaryOperator operator;
	public final int line;
	
	public BinaryExpression(int line, IExpression expression0, IExpression expression1, BinaryOperator operator) {
		this.expression0 = expression0;
		this.expression1 = expression1;
		this.operator = operator;
		this.line = line;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	public static enum BinaryOperator
	{
		ADDITIVE,
		SUBDITIVE,
		MULTIPLICATIVE,
		DIVIDE,
		DIVIDES,
		DEFINE;
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		switch(operator) {
			case DEFINE: {
				if (!(expression0 instanceof IAccessible)) {
					throw new RuntimeError(compiler.getContext(), "Cannot be define that expression because it is not accessible");
				}
				expression1.expand(compiler);
				compiler.makeAload(((IAccessible)expression0).access());
				compiler.makeFieldAccess(((IAccessible)expression0).access());
				break;
			}
			case ADDITIVE: {
				expression0.expand(compiler);
				expression1.expand(compiler);
				compiler.makeAdd();
				break;
			}
			case DIVIDES: {
				expression0.expand(compiler);
				expression1.expand(compiler);
				compiler.makeDivs();
				break;
			}
			case DIVIDE: {
				expression0.expand(compiler);
				expression1.expand(compiler);
				compiler.makeDiv();
				break;
			}
			case MULTIPLICATIVE: {
				expression0.expand(compiler);
				expression1.expand(compiler);
				compiler.makeMul();
				break;
			}
			case SUBDITIVE: {
				expression0.expand(compiler);
				expression1.expand(compiler);
				compiler.makeSub();
				break;
			}
			default:
				break;
		
		}
	}
}
