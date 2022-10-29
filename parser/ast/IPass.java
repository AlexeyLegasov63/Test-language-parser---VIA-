package via.script.parser.ast;

import via.script.runtime.RuntimeStack;

public interface IPass extends IRef
{
	IValue invoke(RuntimeStack stack, IValue... args);
	boolean similar(IValue[] args);
	boolean similar(int args);
	boolean similar(TypeIndifier[] args);
}
