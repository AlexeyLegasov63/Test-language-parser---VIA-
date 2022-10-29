package via.script.parser.ast.declare;

import java.util.Arrays;

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

public abstract class PassPrime implements IPass
{
	private final String name;
	private final TypeIndifier[] types;
	private final int length;
	private final TypeIndifier type;
	
	public PassPrime(String name, TypeIndifier type, TypeIndifier... types) {
		this.name = name;
		this.types = types;
		this.length = types.length;
		this.type = type;
	}

	@Override
	public final IValue invoke(RuntimeStack stack, IValue... args) {
		stack.push(); stack.push(this, length);
		
		if (type.equals(Type.IMPLICIT.asIndifier())) {
			invoke0(stack, args);
			stack.pop(); stack.popMachine();
			return NullptrValue.ZERO;
		}
		IValue value = invoke1(stack, args);
		stack.pop(); stack.popMachine();
		return value;
	}
	
	public void invoke0(RuntimeStack stack, IValue... args) {}
	

	public IValue invoke1(RuntimeStack stack, IValue... args) { return null; }
	
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
	public boolean similar(IValue[] args) {
		if (length != args.length) return false;
		for (int i = 0; i < length; i++) {
			if (!args[i].getType().equals(types[i])) {
				return false;
			}
		}
		return true;
	}
	@Override
	public boolean similar(TypeIndifier[] args) {
		return Arrays.equals(args, this.types);
	}

	@Override
	public boolean similar(int args) {
		return args == types.length;
	}
}
