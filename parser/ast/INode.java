package via.script.parser.ast;

import via.script.visitor.IVisitable;

public interface INode extends IVisitable
{
	default String getFile() {
		return "Uknown source";
	}
}
