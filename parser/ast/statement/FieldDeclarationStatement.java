package via.script.parser.ast.statement;

import java.util.*;

import via.script.intermediate.IntermediateGoto;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.*;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class FieldDeclarationStatement implements IStatement, IDeclaration
{
	public final IExpression expression;
	public final String name;
	public final TypeIndifier type;
	
	public FieldDeclarationStatement(String name, TypeIndifier type, IExpression expression) {
		this.expression = expression;
		this.name = name;
		this.type = type;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		compiler.makeAlt(type, name);
		if (expression != null) {
			expression.expand(compiler);
			compiler.makeAload(name);
		}
	}

	@Override
	public void emit(IntermediateProgramBuilder compiler) {}
	
}
