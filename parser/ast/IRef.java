package via.script.parser.ast;

import via.script.visitor.IVisitable;

public interface IRef extends IVisitable, ITyped
{
	String getName();
	default String getFile() {
		return "Uknown source";
	}
}
