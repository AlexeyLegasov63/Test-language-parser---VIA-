package via.script.parser.ast.expression;

import java.util.*;

import via.script.intermediate.IntermediateProgramBuilder;
import via.script.main.CompilerLogic;
import via.script.parser.ast.IExpression;
import via.script.parser.ast.IPass;
import via.script.parser.ast.IStatement;
import via.script.parser.ast.ITyped;
import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class InvokePassExpression implements IExpression, ITyped
{
	public final IExpression[] expression;
	private int position, line;
	public final String name;
	public InvokePassExpression(int line, String name, IExpression... expression) {
		this.expression = expression;
		this.name = name;
		this.line = line;
	}
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	public void add(IExpression ex) {
		expression[position++] = ex;
	}
	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		// Collect callback information
		compiler.makeRowSet(line);
		compiler.makeCollect(CompilerLogic.CALLBACK);
		compiler.makeCollect(position);
		// Collect arguments
		for (int i = 0; i < position; i++) {
			expression[i].expand(compiler);
		}
		compiler.makeCallback(name, position);
	}
}
