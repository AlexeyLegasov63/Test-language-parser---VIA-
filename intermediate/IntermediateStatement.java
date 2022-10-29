package via.script.intermediate;

import via.script.runtime.RuntimeStack;

public interface IntermediateStatement
{
	default void emit(IntermediateProgramBuilder compiler) {}
	/**
	 * @return
	 * 		-3 - stop
	 * 		-2 - repeat
	 * 		-1 - neutral (continue executing)
	 */
	int exec(RuntimeStack stack, IntermediateProgram program);
	
	public static final int NEUTRAL = -1, 
			REPEAT = -2, 
			STOP = -3,
			EXCEPTION_UKNOWN_VARIABLE = -0x34;
}
