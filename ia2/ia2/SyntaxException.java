public class SyntaxException extends Exception {

	private int pos;
	private Token expected;
	private Token found;

	// Constructor initializes position, expected and found tokens
	// Arguments:
	// 	expected = expected token
	// 	found = found token
	public SyntaxException(int pos, Token expected, Token found) {
		this.pos=pos;
		this.expected=expected;
		this.found=found;
	}

	// toString method returns a string detailing SyntaxException
	public String toString() {
		return "syntax error"
			+", pos="+pos
			+", expected="+expected
			+", found="+found;
	}

}
