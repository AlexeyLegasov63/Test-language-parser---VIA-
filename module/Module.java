package via.script.module;

import java.util.*;

import via.script.parser.ast.IRef;

public abstract class Module
{
	private final ArrayList<IRef> nodes;
	private final String alias;

	public Module(String alias) {
		this.alias = alias;
		this.nodes = new ArrayList<>();
	}
	
	protected void set(IRef node) {
		nodes.add(node);
	}
	
	
}
