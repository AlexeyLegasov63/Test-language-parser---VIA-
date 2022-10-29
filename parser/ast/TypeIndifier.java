package via.script.parser.ast;

public class TypeIndifier
{
	public static final Type fromWord(String value) {
		Type type;
		switch(value) {
			case "number": type = Type.NUMBER; break;
			case "string": type = Type.STRING; break;
			case "boolean":
			case "bool": type = Type.BOOLEAN; break;
			case "char": type = Type.CHARACTER; break;
			case "array": type = Type.ARRAY; break;
			case "implicit": type = Type.IMPLICIT; break;
			default: type = Type.CLASS; break;
		}
		return type;
	}
	private final Type type;
	private final String name;
	
	public TypeIndifier(Type type, String name) {
		this.type = type;
		this.name = name;
	}
	public Type getType() {
		return type;
	}
	public String getName() {
		return name;
	}
	
	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof TypeIndifier && ((TypeIndifier)obj).name.equalsIgnoreCase(name) && ((TypeIndifier)obj).type.equals(type);
	}
	
	@Override
	public String toString() {
		return String.format("%s %s", type, name);
	}
}
