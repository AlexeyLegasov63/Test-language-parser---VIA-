package via.script.parser.ast;

import via.script.main.CompilerLogic;
import via.script.runtime.RuntimeStack;

public class Arguments
{
	private final Argument[] args = new Argument[0x30];
	private int number;
	
	public Arguments() {
		
	}
	
	public void declare(RuntimeStack stack, IValue... args) {
		try {
			if (stack.top() == CompilerLogic.CALLBACK) {
				stack.remove();
				for (int i = 0; i < number; i++) {
					this.args[i].declare(stack, stack.peek());
					stack.pop();
				}
				return;
			}
			if (args.length != number) throw new RuntimeException();
			for (int i = 0; i < number; i++) {
				this.args[i].declare(stack, args[i]);
			}
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public int size() {
		return number;
	}
	public void append(Argument arg) {
		args[number++] = arg;
	}
	public boolean similar(TypeIndifier[] args) {
		if (args.length != number) return false;
		for (int i = 0; i < number; i++) {
			if (!(this.args[i].getType().equals(args[i]))) {
				return false;
			}
		}
		return true;
	}
	
	public boolean similar(IValue[] args) {
		if (args.length != number) return false;
		for (int i = 0; i < number; i++) {
			if (!this.args[i].similar(args[i])) {
				return false;
			}
		}
		return true;
	}
	
	@Override
	public boolean equals(Object arg) {
		return arg != null && arg instanceof Arguments && ((Arguments)arg).args.equals(args);
	}
}
