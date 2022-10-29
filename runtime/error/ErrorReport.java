package via.script.runtime.error;

import java.util.Properties;

public class ErrorReport
{
	public static final String PROPERTY_LINE_NUMBER = "common.line";
	public static final String PROPERTY_CAUSE = "common.cause";
	public static final String PROPERTY_MESSAGE = "common.message";

	public static final String MESSAGE_UNDEFINED_CONST = "That const is not defined!";
	public static final String MESSAGE_CALLBACK = "Uknown error in local callback";
	public static final String MESSAGE_PRIME_CALLBACK = "Uknown error in prime (native) callback";
	public static final String MESSAGE_MODULE_FIELD_ACCESS = "No such field as that field";
	public static final String MESSAGE_MODULE_PASS_ACCESS = "No such pass as that module";
	public static final String MESSAGE_INSTANCE_FIELD_ACCESS = "No such field as that instance";
	public static final String MESSAGE_INSTANCE_PASS_ACCESS = "No such pass as that instance";
	public static final String MESSAGE_INSTANCE_TYPE_ARGUMENT = "Different intance and argument types *(May set implicit-type?)";
	public static final String MESSAGE_DUPLICATE_PASS = "Duplicate of pass";
	public static final String MESSAGE_DUPLICATE_FIELD = "Duplicate of variables";
	public static final String MESSAGE_DUPLICATE_FLAG = "Duplicate of flags";
	
	// Runtime
	public static final String MESSAGE_INSTANCE_NULL = "That instance is null";
	public static final String MESSAGE_THREAD_INTERRUPT = "That thread has interrupted";
	public static final String MESSAGE_THREAD_TIMEOUT = "Thread timeout";
	public static final String MESSAGE_OUT_OF_MEMORY = "Out of memory";
	public static final String MESSAGE_STACK_OVERFLOW = "Stack over flow";
	
	
	
	private final Properties props = new Properties();
	
	public Properties getProps() {
		return props;
	}
}
