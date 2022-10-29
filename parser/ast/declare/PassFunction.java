package via.script.parser.ast.declare;

import via.script.intermediate.IntermediateProgram;
import via.script.parser.ast.Arguments;
import via.script.parser.ast.IPass;
import via.script.parser.ast.IPassFunction;
import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;
import via.script.parser.ast.statement.BlockStatement;
import via.script.parser.ast.value.NullptrValue;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class PassFunction implements IPassFunction
{
	private final Arguments arguments;
	private String name;
	private TypeIndifier type;
	private IntermediateProgram block;
	
	public PassFunction(IntermediateProgram block, Arguments arguments, String name, TypeIndifier type) {
		this.arguments = arguments;
		this.name = name;
		this.type = type;
		this.block = block;
	}

	@Override
	public IValue invoke(RuntimeStack stack, IValue... args) {
		stack.push();
		arguments.declare(stack, args);
		block.exec(stack);
		stack.pop();
		return NullptrValue.ZERO;
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public TypeIndifier getType() {
		return type;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public Arguments arguments() {
		return arguments;
	}

	@Override
	public boolean similar(IValue[] args) {
		return arguments.similar(args);
	}

	@Override
	public boolean similar(TypeIndifier[] args) {
		return arguments.similar(args);
	}

	@Override
	public boolean similar(int args) {
		return args == arguments.size();
	}
}
