// This class provides a stubbed-out environment.
// You are expected to implement the methods.
// Accessing an undefined variable should throw an exception.

// Hint!
// Use the Java API to implement your Environment.
// Browse:
//   https://docs.oracle.com/javase/tutorial/tutorialLearningPaths.html
// Read about Collections.
// Focus on the Map interface and HashMap implementation.
// Also:
//   https://www.tutorialspoint.com/java/java_map_interface.htm
//   http://www.javatpoint.com/java-map
// and elsewhere.

public class Environment {

	private String[] map = { "x" };

	// put method creates a variable with an integer attached to it
	// Arguments:
	// 	String var = a String to name the integer
	// 	int val = desired int value
	// Returns:
	// 	val = integer assigned to the name
	public int put(String var, int val) {
		return val;
	}

	// get method returns the position of
	// a named variable
	// Arguments:
	// 	pos = position of the variable
	// 	var = name of the variable
	// Returns:
	// 	0
	public int get(int pos, String var) throws EvalException {
		return 0;
	}

	// toC method converts code to C code
	// Returns:
	// 	s = altered string
	public String toC() {
		String s = "";
		String sep = " ";
		for (String v : map) {
			s += sep + v;
			sep = ",";
		}
		return s == "" ? "" : "int" + s + ";\nx=0;x=x;\n";
	}

}
