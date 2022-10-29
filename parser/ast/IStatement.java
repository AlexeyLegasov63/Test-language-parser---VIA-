package via.script.parser.ast;

import via.script.intermediate.IntermediateProgramBuilder;
import via.script.intermediate.IntermediateStatement;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitable;

public interface IStatement extends INode
{
	default void exec(RuntimeStack stack) {}
	
	default void expand(IntermediateProgramBuilder compiler) {}
		
	default void emit(IntermediateProgramBuilder compiler) {}
}
