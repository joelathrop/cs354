public class EvalException extends Exception {

	private int pos;
	private String msg;

	// Constructor initializes position and message variables
	public EvalException(int pos, String msg) {
		this.pos=pos;
		this.msg=msg;
	}

	// Creates a neat prompt including the position
	// and error message
	// Returns:
	// 	altered string
	public String toString() {
		return "eval error"
			+", pos="+pos
			+", "+msg;
	}

}
