package via.script.intermediate;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

import via.script.parser.ast.IStatement;
import via.script.runtime.RuntimeStack;
import via.script.visitor.IVisitor;

public class IntermediateProgram implements IStatement
{
	private static final Random random = new Random();
	final IntermediateStatement[] result;
	final HashMap<Integer, Integer> labels;
	int position, total, line;
	String ref;

	IntermediateProgram(IntermediateStatement[] result, HashMap<Integer, Integer> labels, int total) {
		this.result = result;
		this.labels = labels;
		this.total = total;
		this.ref = Integer.toHexString(random.nextInt()).toUpperCase();
	}
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer("section 0x" + ref + "\n\t");
		for (int i = 0; i < total; i++) {
			buffer.append(i + "\t" + result[i]);
		}
		buffer.append(total + "\tret\n");
		return buffer.toString();
	}

	@Override
	public void exec(RuntimeStack stack)
	{
		//for (int i = 0; i < total; i++) {
			//System.out.println(result[i]);
		//}
		File dir = new File("E:/Projects/ChernobylCraft/plugins/LuxerEngine/bin/asm/");
		if (!dir.exists()) dir.mkdirs();
		File file = new File("E:/Projects/ChernobylCraft/plugins/LuxerEngine/bin/asm/VIA" + ref + ".s");
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(file.getAbsolutePath()))) {
			writer.write(this.toString());
		} catch(Exception ex) {}
		System.out.println(this);
		System.out.println();
		System.out.println();
		for (int i = 0; i < total;) {
			int r = result[i].exec(stack, this);
			if (r == IntermediateStatement.NEUTRAL) i++;
			else if (r == IntermediateStatement.REPEAT) continue;
			else if (r == IntermediateStatement.STOP) break;
			else i = r;
		}

	}

	@Override
	public void accept(IVisitor visitor) {}
}
