import java.io.*;

public class Code {

	// testing an og java comment
//	;; testing a not real comment
//	< testing my custom comment

	// Starts the C code block
	private final String[] prologue={
		"#include <stdio.h>",
		"int main() {",
	};

	// Ends the C code block
	private final String[] epilogue={
		"return 0;",
		"}",
	};

	// body of the C code block
	public Code(String code, Environment env) {
		String fn=System.getenv("Code");
		if (fn==null)
			return;
		try {
			BufferedWriter f=new BufferedWriter(new FileWriter(fn+".c"));
			for (String s: prologue)
				f.write(s+"\n");
			f.write(env.toC());
			f.write(code);
			for (String s: epilogue)
				f.write(s+"\n");
			f.close();
		} catch (Exception e) {
			System.err.println(e);
		}
	}

}
