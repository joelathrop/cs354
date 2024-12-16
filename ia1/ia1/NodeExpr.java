public class NodeExpr extends Node {

	private NodeTerm term;
	private NodeAddop addop;
	private NodeExpr expr;

	// constructor initializes Node term, Node addop, and Node expr
	// Arguments:
	// 	term = node term
	// 	addop = node addop
	// 	expr = node expr
	public NodeExpr(NodeTerm term, NodeAddop addop, NodeExpr expr) {
		this.term=term;
		this.addop=addop;
		this.expr=expr;
	}

	// append method adds the expr node to the end of an expr
	// or the end of an addop node if null
	// Arguments:
	// 	exppr = node expr
	public void append(NodeExpr expr) {
		if (this.expr==null) {
			this.addop=expr.addop;
			this.expr=expr;
			expr.addop=null;
		} else
			this.expr.append(expr);
	}

	// eval method evaluates the environment
	// Arguments:
	// 	env = Environment variable
	public int eval(Environment env) throws EvalException {
		return expr==null
			? term.eval(env)
			: addop.op(expr.eval(env),term.eval(env));
	}

	// code method returns the code string
	public String code() {
		return (expr==null ? "" : expr.code()+addop.code())+term.code();
	}

}
