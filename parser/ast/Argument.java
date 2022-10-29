package via.script.parser.ast;

import java.util.Objects;

import via.script.parser.ast.declare.DynamicVariable;
import via.script.runtime.RuntimeStack;

public class Argument implements IArgument
{
	private final TypeIndifier type;
	private final String name;
	
	public Argument(TypeIndifier type, String name) {
		this.type = type;
		this.name = name;
	}
	public void declare(RuntimeStack stack, IValue ex) {
		try {
			stack.increment(new DynamicVariable(type, name, ex));
		} catch(Exception exc) {
			exc.printStackTrace();
		}
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Argument other = (Argument) obj;
		return type == other.type;
	}
	public boolean similar(IValue value) {
		return value != null && value.getType().equals(type);
	}
	@Override
	public TypeIndifier getType() {
		return type;
	}
}
