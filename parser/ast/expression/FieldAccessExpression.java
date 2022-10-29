package via.script.parser.ast.expression;

import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.IAccessible;
import via.script.parser.ast.IExpression;
import via.script.parser.ast.IValue;
import via.script.parser.ast.value.*;
import via.script.parser.lexer.token.*;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class FieldAccessExpression implements IExpression, IAccessible
{
	public final Literal literal;
	
	public FieldAccessExpression(Literal literal) {
		this.literal = literal;
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		compiler.makeFieldAccess(literal.getLiteral());
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public IValue get(RuntimeStack stack) {
		return stack.getVariable(literal.getLiteral()).getValue();
	}

	@Override
	public IValue set(RuntimeStack stack, IValue value) {
		return stack.getVariable(literal.getLiteral()).setValue(value);
	}

	@Override
	public String access() {
		return literal.getLiteral();
	}

}
