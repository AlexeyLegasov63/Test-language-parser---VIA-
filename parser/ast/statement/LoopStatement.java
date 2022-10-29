package via.script.parser.ast.statement;

import java.util.*;

import via.script.intermediate.IntermediateGoto;
import via.script.intermediate.IntermediateProgramBuilder;
import via.script.parser.ast.*;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class LoopStatement implements IStatement
{
	public final IStatement statement;
	public int startL, endL;
	public LoopStatement(IStatement statement) {
		this.statement = statement;
	}

	@Override
	public void accept(IVisitor visitor) {
		visitor.visit(this);
	}

	@Override
	public void expand(IntermediateProgramBuilder compiler) {
		startL = compiler.witness(compiler.getLabel());
		statement.expand(compiler);  
		compiler.makeGoto(startL);
		compiler.popWitness();
		endL = compiler.getLabel();
	}


	@Override
	public void emit(IntermediateProgramBuilder compiler) {
		compiler.witness(endL);
		statement.emit(compiler);
		compiler.popWitness();
	}
}
