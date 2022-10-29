package via.script.runtime;

import java.util.*;

import via.script.exception.RuntimeError;
import via.script.parser.ast.Argument;
import via.script.parser.ast.Arguments;
import via.script.parser.ast.IRef;
import via.script.parser.ast.IPass;
import via.script.parser.ast.IValue;
import via.script.parser.ast.IVariable;
import via.script.parser.ast.Type;
import via.script.parser.ast.TypeIndifier;
import via.script.parser.ast.declare.PassFunction;
import via.script.parser.ast.declare.PassPrime;
import via.script.parser.ast.value.NullptrValue;
import via.script.runtime.bridge.ViaScriptBridge;
import via.script.runtime.error.ErrorReport;

public class RuntimeStack
{
	private final ArrayList<IRef> nodes;
	private final Stack<ArrayList<IRef>> stack = new Stack<>();
	private final Stack<IValue> value = new Stack<>();
	private final Stack<Integer> fast = new Stack<>();
	private final TraceElementSet runtimeTrace = new TraceElementSet();
	
	public RuntimeStack() {
		nodes = new ArrayList<>(ViaScriptBridge.nodes);
	}
	
	public void increment(IRef node) {
		nodes.add(node);
	}
	public IRef getNode(String name, int value) {
		try {
			for (IRef node : nodes) {
				if (node instanceof IPass && node.getName().equals(name) && ((IPass)node).similar(value)) {
					return node;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		throw new RuntimeError(this, "root.error.NoSuchPass: " + ErrorReport.MESSAGE_INSTANCE_PASS_ACCESS);
	}
	public IRef getNode(String name, TypeIndifier[] value) {
		try {
			for (IRef node : nodes) {
				if (node instanceof IPass && node.getName().equals(name) && ((IPass)node).similar(value)) {
					return node;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		throw new RuntimeError(this, "root.error.NoSuchPass: " + ErrorReport.MESSAGE_INSTANCE_PASS_ACCESS);
	}
	public IRef getNode(String name, IValue[] value) {
		try {
			for (IRef node : nodes) {
				if (node instanceof IPass && node.getName().equals(name) && ((IPass)node).similar(value)) {
					return node;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		throw new RuntimeError(this, "root.error.NoSuchPass: " + ErrorReport.MESSAGE_INSTANCE_PASS_ACCESS);
	}
	public IRef getNode(String name) {
		try {
			for (IRef node : nodes) {
				if (node.getName().equals(name)) {
					return node;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		throw new RuntimeError(this, "root.error.NoSuchPass: " + ErrorReport.MESSAGE_INSTANCE_PASS_ACCESS);
	}
	public IVariable getVariable(String name) {
		try {
			for (IRef node : nodes) {
				if (node.getName().equals(name) && node instanceof IVariable) {
					return (IVariable)node;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		throw new RuntimeError(this, "root.error.NoSuchField: " + ErrorReport.MESSAGE_INSTANCE_FIELD_ACCESS);
	}
	public IRef getNode(TypeIndifier type, String name) {
		try {
			for (IRef node : nodes) {
				if (node.getName().equals(name) && node.getType().equals(type)) {
					return node;
				}
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		throw new RuntimeError(this, "root.error.NoSuchPass: " + ErrorReport.MESSAGE_INSTANCE_PASS_ACCESS);
	}
	public void push() {
		stack.push(new ArrayList<>(nodes));
	}
	public void pop() {
		stack.pop();
	}
	public void push(IValue value) {
		this.value.push(value);
	}
	public IValue popValue() {
		try {
			return value.peek();
		} finally {
			value.pop();
		}
	}
	public IValue peek() {
		return value.peek();
	}
	public void collect(int i) {
		fast.push(i);
	}
	public void remove() {
		fast.pop();
	}
	public int top() {
		return fast.peek();
	}
	public int size() {
		return fast.size();
	}
	public int get(int i) {
		return fast.get(i);
	}
	public void popMachine() {
		runtimeTrace.pop();
	}
	public void push(IPass pass, int row) {
		runtimeTrace.push(pass, row);
	}
	public void push(String file, String desc, int row) {
		runtimeTrace.push(file, desc, row);
	}
	public void printStackTrace(String cause) {
		runtimeTrace.printElements(cause);
	}
	public void printStackTrace() {
		runtimeTrace.printElements();
	}
	public static class Callback {
		private final String name;
		private final TypeIndifier[] arguments;
		public Callback(String name, TypeIndifier[] arguments) {
			this.name = name;
			this.arguments = arguments;
		}
		public String getName() {
			return name;
		}
		public TypeIndifier[] getArguments() {
			return arguments;
		}
	}
}
