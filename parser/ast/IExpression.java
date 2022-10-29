package via.script.parser.ast;

import via.script.intermediate.IntermediateProgramBuilder;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitable;

public interface IExpression extends INode
{	
	void expand(IntermediateProgramBuilder compiler);
}
