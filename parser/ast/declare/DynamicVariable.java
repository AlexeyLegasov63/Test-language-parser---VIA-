package via.script.parser.ast.declare;

import via.script.parser.ast.IValue;
import via.script.parser.ast.IVariable;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;
import via.script.visitor.IVisitor;

public class DynamicVariable implements IVariable
{
	public final String name;
	public final TypeIndifier type;
	public IValue value;
	
	public DynamicVariable(TypeIndifier type, String name, IValue value) {
		this.name = name;
		this.type = type;
		this.value = value;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public TypeIndifier getType() {
		return type;
	}

	public IValue getValue() {
		return value;
	}
	
	public IValue setValue(IValue value) {
		this.value = value;
		return value;
	}
	
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
}
