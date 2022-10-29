package via.script.parser.ast;

public enum Type
{
	IMPLICIT(""),
	NUMBER("number"),
	STRING("string"),
	BOOLEAN("boolean"),
	CHARACTER("char"),
	ARRAY("array"),
	ERROR("throw"),
	CLASS("uknown");
	
	private TypeIndifier type;
	
	private Type(String t) {
		type = new TypeIndifier(this, t);
	}
	
	public boolean isSimilar(Type type) {
		return type == this || (type == IMPLICIT || this == IMPLICIT);
	}
	
	public TypeIndifier asIndifier() {
		return type;
	}
}
