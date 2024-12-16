// This class is a recursive-descent parser,
// modeled after the programming language's grammar.
// It constructs and has-a Scanner for the program
// being parsed.

public class Parser {

	private Scanner scanner;

	// match matches a String s to a token
	private void match(String s) throws SyntaxException {
		scanner.match(new Token(s));
	}

	// curr returns the current token
	private Token curr() throws SyntaxException {
		return scanner.curr();
	}

	// pos method returns the scanner position
	private int pos() {
		return scanner.pos();
	}

	// parseRelop method parses relationship operations
	// this includes: <, <=, >, >=, <>, ==
	// returns: relop node
	private NodeRelop parseRelop() throws SyntaxException {
		if (curr().equals(new Token("<"))) {
			match("<");
			return new NodeRelop(pos(), "<");
		}
		if (curr().equals(new Token("<="))) {
			match("<=");
			return new NodeRelop(pos(), "<=");
		}
		if (curr().equals(new Token(">"))) {
			match(">");
			return new NodeRelop(pos(), ">");
		}
		if (curr().equals(new Token(">="))) {
			match(">=");
			return new NodeRelop(pos(), ">=");
		}
		if (curr().equals(new Token("<>"))) {
			match("<>");
			return new NodeRelop(pos(), "<>");
		}
		if (curr().equals(new Token("=="))) {
			match("==");
			return new NodeRelop(pos(), "==");
		}
		return null;
	}

	// parseMulop method parses multiplication operations
	// this includes *, /
	// returns: mulop node
	private NodeMulop parseMulop() throws SyntaxException {
		if (curr().equals(new Token("*"))) {
			match("*");
			return new NodeMulop(pos(), "*");
		}
		if (curr().equals(new Token("/"))) {
			match("/");
			return new NodeMulop(pos(), "/");
		}
		return null;
	}

	// parseAddop parses addition operations
	// this includes +, -
	// returns: addop node
	private NodeAddop parseAddop() throws SyntaxException {
		if (curr().equals(new Token("+"))) {
			match("+");
			return new NodeAddop(pos(), "+");
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			return new NodeAddop(pos(), "-");
		}
		return null;
	}

	// parseBoolexpr method parses boolean expressions
	// this includes: >, >=, <, <=, <>, ==
	// returns: boolean expression node
	private NodeBoolexpr parseBoolexpr() throws SyntaxException {
		NodeExpr expr = parseExpr();
		NodeRelop relop = parseRelop();
		if (relop == null)
			return new NodeBoolexpr(expr, null, null);
		NodeExpr expr2 = parseExpr();
		return new NodeBoolexpr(expr, relop, expr2);
	}

	// parseFact method parses facts
	// returns: fact node
	private NodeFact parseFact() throws SyntaxException {
		if (curr().equals(new Token("("))) {
			match("(");
			NodeExpr expr = parseExpr();
			match(")");
			return new NodeFactExpr(expr);
		}
		if (curr().equals(new Token("-"))) {
			match("-");
			NodeFact fact = parseFact();
			return new NodeFactExpr(fact);
		}
		if (curr().equals(new Token("id"))) {
			Token id = curr();
			match("id");
			return new NodeFactId(pos(), id.lex());
		}
		Token num = curr();
		match("num");
		return new NodeFactNum(num.lex());
	}

	// parseTerm method parses terms
	// returns term node
	private NodeTerm parseTerm() throws SyntaxException {
		NodeFact fact = parseFact();
		NodeMulop mulop = parseMulop();
		if (mulop == null)
			return new NodeTerm(fact, null, null);
		NodeTerm term = parseTerm();
		term.append(new NodeTerm(fact, mulop, null));
		return term;
	}

	// parseExpr method parses expressions
	// returns the expression
	private NodeExpr parseExpr() throws SyntaxException {
		NodeTerm term = parseTerm();
		NodeAddop addop = parseAddop();
		if (addop == null)
			return new NodeExpr(term, null, null);
		NodeExpr expr = parseExpr();
		expr.append(new NodeExpr(term, addop, null));
		return expr;
	}

	// parseAssn method parses assignment operators
	// this includes: id, =
	// returns: assignment node
	private NodeAssn parseAssn() throws SyntaxException {
		Token id = curr();
		match("id");
		match("=");
		NodeExpr expr = parseExpr();
		NodeAssn assn = new NodeAssn(id.lex(), expr);
		return assn;
	}

	// parseStmt method parses statements according to the grammar
	// this includes: rd, wr, if, then, else, while, do, begin, end
	// returns: statement node
	private NodeStmt parseStmt() throws SyntaxException {
		NodeAssn assn = parseAssn();
		if (curr().equals(new Token("rd"))) {
			match("rd");
			return new NodeStmt("rd");
		}
		if (curr().equals(new Token("wr"))) {
			match("wr");
			NodeExpr expr = parseExpr();
			return new NodeStmt(new NodeWr(expr));
		}
		if (curr().equals(new Token("if"))) {
			match("if");
			NodeBoolexpr boolexpr = parseBoolexpr();
			match("then");
			NodeStmt stmt = parseStmt();
			if (curr().equals(new Token("else"))) {
				match("else");
				NodeStmt stmt2 = parseStmt();
				return new NodeStmt(new NodeIf(boolexpr, stmt, stmt2));
			}
			return new NodeStmt(new NodeIf(boolexpr, stmt, null));
		}
		if (curr().equals(new Token("while"))) {
			match("while");
			NodeBoolexpr boolexpr = parseBoolexpr();
			match("do");
			NodeStmt stmt = parseStmt();
			return NodeStmt(new NodeWhile(boolexpr, stmt));
		}
		if (curr().equals(new Token("begin"))) {
			match("begin");
			NodeBlock block = parseBlock();
			match("end");
			return;
		}

		match(";");
		NodeStmt stmt = new NodeStmt(assn);
		return stmt;
	}

	// parseBlock method parses a block of code defined by ";"
	// returns: block node
	private NodeBlock parseBlock() throws SyntaxException {
		NodeStmt stmt = parseStmt();
		match(";");
		NodeBlock block = parseBlock();
		return new NodeBlock(stmt, ";", block);
	}

	// parse method parses the entire program block by block
	// args: String program
	// returns: statement node
	public Node parse(String program) throws SyntaxException {
		scanner = new Scanner(program);
		scanner.next();
		NodeBlock block = parseBlock();
		//NodeStmt stmt = parseStmt();
		match("EOF");
		return stmt;
	}

}
