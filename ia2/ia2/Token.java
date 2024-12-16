// This class models a token, which has two parts:
// 1) the token itself (e.g., "id" or "+")
// 2) the token's lexeme (e.g., "foo")

public class Token {

	private String token;
	private String lexeme;

	// overloaded constructor initializes token & its lexeme
	// Arguments:
	// 	token = name of the token
	// 	lexeme = name of the lexeme
	public Token(String token, String lexeme) {
		this.token=token;
		this.lexeme=lexeme;
	}

	// constructor initializes token
	// Arguments:
	// 	token = name of the token 
	public Token(String token) {
		this(token,token);
	}

	// getter for the token
	public String tok() { return token; }

	// getter for the lexeme
	public String lex() { return lexeme; }

	// equals method compares two tokens recursively
	// Arguments:
	// 	t = token to compare
	// Returns:
	// 	recursive call to equals
	public boolean equals(Token t) {
		return token.equals(t.token);
	}

	// toString method returns token and lexeme names in a string
	public String toString() {
		return "<"+tok()+","+lex()+">";
	}

}
