package via.script.parser.ast;

import via.script.runtime.RuntimeStack;

public interface IAccessible
{
	IValue get(RuntimeStack stack);
	
	IValue set(RuntimeStack stack, IValue value);
	
	String access();
}
