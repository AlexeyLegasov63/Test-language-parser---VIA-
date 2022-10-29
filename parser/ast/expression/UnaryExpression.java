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

public class UnaryExpression implements IExpression
{
	public final IExpression expression;
	public final UnaryOperator operator;
	
	public UnaryExpression(IExpression expression, UnaryOperator operator) {
		this.expression = expression;
		this.operator = operator;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	public static enum UnaryOperator
	{
		NEG,
		INV,
		LPP,
		RPP,
		LMM,
		RMM,
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		expression.expand(compiler);
		switch(operator)
		{
		case INV: compiler.makeInv(); break;
		case NEG: compiler.makeNeg(); break;
		case LMM: {
			if (!(expression instanceof IAccessible)) throw new RuntimeException();
			IAccessible acc = (IAccessible)expression;
			compiler.makePush(new NumberValue(1));
			compiler.makeSub();
			compiler.makeAload(acc.access());
			compiler.makeFieldAccess(acc.access());
			break;
		}
		case LPP: {
			if (!(expression instanceof IAccessible)) throw new RuntimeException();
			IAccessible acc = (IAccessible)expression;
			compiler.makePush(new NumberValue(1));
			compiler.makeAdd();
			compiler.makeAload(acc.access());
			compiler.makeFieldAccess(acc.access());
			break;
		}
		case RMM: {
			if (!(expression instanceof IAccessible)) throw new RuntimeException();
			IAccessible acc = (IAccessible)expression;
			compiler.makePop();
			compiler.makePush(new NumberValue(1));
			compiler.makeSub();
			compiler.makeAload(acc.access());
			break;
		}
		case RPP: {
			if (!(expression instanceof IAccessible)) throw new RuntimeException();
			IAccessible acc = (IAccessible)expression;
			compiler.makePop();
			compiler.makePush(new NumberValue(1));
			compiler.makeAdd();
			compiler.makeAload(acc.access());
			break;
		}
		default:
			break;
		
		}
	}
}
