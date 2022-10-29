package via.script.parser.ast.expression;

import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.IExpression;
import via.script.parser.ast.IValue;
import via.script.parser.ast.value.*;
import via.script.parser.lexer.token.*;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class PrimaryExpression implements IExpression
{
	public final Literal literal;
	
	public PrimaryExpression(Literal literal) {
		this.literal = literal;
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		if (literal instanceof NumberLiteral) {
			compiler.makePush(new NumberValue(((NumberLiteral)literal).getNumber()));
			return;
		} else if (literal instanceof StringLiteral) {
			compiler.makePush(new LetterValue(((StringLiteral)literal).getString()));
			return;
		} else if (literal instanceof CharacterLiteral) {
			compiler.makePush(new CharacterValue(((CharacterLiteral)literal).getCharacter()));
			return;
		} else if (literal instanceof BooleanLiteral) {
			compiler.makePush(new BooleanValue(((BooleanLiteral)literal).getBoolean()));
			return;
		}
		throw new RuntimeException();
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

}
