package via.script.intermediate;

import via.script.parser.ast.IValue;
import via.script.parser.ast.expression.ConditionalExpression.ConditionalOperator;
import via.script.parser.ast.value.BooleanValue;
import via.script.runtime.RuntimeStack;

public class IntermediateCond implements IntermediateStatement
{
	public ConditionalOperator push;
	
	public IntermediateCond(ConditionalOperator push) {
		this.push = push;
	}

	@Override
	public int exec(RuntimeStack stack, IntermediateProgram program) {
		IValue value0 = stack.popValue(), value1 = stack.popValue();
		switch(push)
		{
			case OR: {
				stack.push(new BooleanValue(value0.jBoolean() || value1.jBoolean()));
				break;
			}
			case AND: {
				stack.push(new BooleanValue(value0.jBoolean() && value1.jBoolean()));
				break;
			}
			case EQEQ: {
				stack.push(new BooleanValue(value0.equals(value1)));
				break;
			}
			case NTEQ: {
				stack.push(new BooleanValue(!value0.equals(value1)));
				break;
			}
			case LT: {
				stack.push(new BooleanValue(value0.jNumber().doubleValue() < value1.jNumber().doubleValue()));
				break;
			}
			case RT: {
				stack.push(new BooleanValue(value0.jNumber().doubleValue() > value1.jNumber().doubleValue()));
				break;
			}
			case LTEQ: {
				stack.push(new BooleanValue(value0.jNumber().doubleValue() <= value1.jNumber().doubleValue()));
				break;
			}
			case RTEQ: {
				stack.push(new BooleanValue(value0.jNumber().doubleValue() >= value1.jNumber().doubleValue()));
				break;
			}
			default:
				break;
		
		}
		return NEUTRAL;
	}
	@Override
	public String toString() {
		return "cmp " + push + "\n\t";
	}
}
