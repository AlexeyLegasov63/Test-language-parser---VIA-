package via.script.parser;

import java.io.File;

public class CompileContext
{
	private final File file;

	public CompileContext(File file) {
		this.file = file;
	}

	public File getFile() {
		return file;
	}
}
