package via.script.main;

import java.io.File;

import via.script.exception.RuntimeError;
import via.script.parser.CompileContext;
import via.script.parser.ViaParser;
import via.script.parser.lexer.ViaInputStream;
import via.script.parser.lexer.ViaLexer;
import via.script.parser.lexer.token.Token;

public class ViaScript
{
	public static void main(String... args) {
		CompileContext context = new CompileContext(new File("test.via"));
		ViaInputStream in = new ViaInputStream();
		ViaLexer lexer = new ViaLexer(context, in.getInput(context.getFile()));
		Token[] tokens = lexer.read();
		int size = lexer.getSize();
		ViaParser parser = new ViaParser(context, tokens, size);
		parser.read();
		long n = System.currentTimeMillis();
		try {
			parser.exec();
		} catch(RuntimeError e) {}
		System.out.println(System.currentTimeMillis() - n);
	}
}
