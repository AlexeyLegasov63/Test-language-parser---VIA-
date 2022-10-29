package via.script.parser.ast;

public interface IVariable extends IRef
{
	IValue setValue(IValue value);
	IValue getValue();
}
