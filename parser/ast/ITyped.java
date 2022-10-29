package via.script.parser.ast;

import via.script.runtime.RuntimeStack;

public interface ITyped
{
	default TypeIndifier getType() { return null; }
}
