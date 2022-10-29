package via.script.parser.ast.statement;

import java.util.*;

import via.script.intermediate.IntermediateGoto;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.IDeclaration;
import via.script.parser.ast.IStatement;
import via.script.parser.ast.IWayCast;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class BlockStatement implements IStatement
{
	public final List<IStatement> statements = new ArrayList<>();
	private boolean push;
	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}
	
	public void add(IStatement statement) {
		if (statement instanceof IDeclaration) {
			push = true;
		}
		statements.add(statement);
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		if (push) 
			compiler.makePushReg();
		for (IStatement statement : statements) {
			try {
				statement.expand(compiler);
			} finally {
				if (statement instanceof IWayCast) {		// Safe remove unnecessary statements
					break;
				}
			}
		}
		if (push)
			compiler.makePopReg();
	}


	@Override
	public void emit(IntermediateProgramBuilder compiler) {
		for (IStatement statement : statements)
			statement.emit(compiler);
	}
}
