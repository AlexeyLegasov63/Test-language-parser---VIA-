package via.script.runtime.bridge;

import java.util.ArrayList;
import java.util.Random;

import via.script.exception.RuntimeError;
import via.script.parser.ast.Argument;
import via.script.parser.ast.Arguments;
import via.script.parser.ast.IRef;
import via.script.parser.ast.IValue;
import via.script.parser.ast.Type;
import via.script.parser.ast.declare.PassFunction;
import via.script.parser.ast.declare.PassPrime;
import via.script.parser.ast.value.BooleanValue;
import via.script.parser.ast.value.NullptrValue;
import via.script.runtime.RuntimeStack;

public class ViaScriptBridge
{
	public static final ArrayList<IRef> nodes;
	
	static {
		nodes = new ArrayList<>();
		
		Arguments args = new Arguments();
		args.append(new Argument(Type.STRING.asIndifier(), "test"));
		nodes.add(new PassFunction(null, args, "write", Type.ARRAY.asIndifier()) {
			@Override
			public IValue invoke(RuntimeStack stack, IValue... v) {
				System.out.println(v[0].jString());
				return NullptrValue.ZERO;
			}
		});
		nodes.add(new PassPrime("randBoolean", Type.BOOLEAN.asIndifier(), Type.NUMBER.asIndifier()) {
			@Override
			public IValue invoke1(RuntimeStack stack, IValue... args) {
				return new BooleanValue(new Random().nextFloat() <= args[0].jNumber().doubleValue());
			}
			
		});
		nodes.add(new PassPrime("randomBinaryN", Type.BOOLEAN.asIndifier()) {
			@Override
			public IValue invoke1(RuntimeStack stack, IValue... args) {
				return new BooleanValue(new Random().nextBoolean());
			}
			
		});
		nodes.add(new PassPrime("binary", Type.BOOLEAN.asIndifier()) {
			int i = 1;
			@Override
			public IValue invoke1(RuntimeStack stack, IValue... args) {
				return new BooleanValue(i-- > 0);
			}
			
		});
		nodes.add(new PassPrime("printf", Type.IMPLICIT.asIndifier(), Type.IMPLICIT.asIndifier()) {
			@Override
			public void invoke0(RuntimeStack stack, IValue... args) {
				System.out.printf(args[0].jString() + "\n");
			}
			
		});
		nodes.add(new PassPrime("getaclass", Type.IMPLICIT.asIndifier(), Type.STRING.asIndifier()) {
			@Override
			public void invoke0(RuntimeStack stack, IValue... args) {
				String name = args[0].jString();
				try {
					Class<?> aclass = Class.forName(name);
				
				} catch (ClassNotFoundException ex) {
					throw new RuntimeError(stack, "No such java-class by name \"" + name + "\"");
				}
			}
			
		});
	}
	
	public static void execute(String pass, Object... objects) {
		
	}
}
