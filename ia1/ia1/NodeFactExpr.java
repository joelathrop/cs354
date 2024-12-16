public class NodeFactExpr extends NodeFact {

	private NodeExpr expr;

	// constructor initializes expr node
	// Return:
	// 	expr = expr node
	public NodeFactExpr(NodeExpr expr) {
		this.expr=expr;
	}

	// eval method initializes environment
	// Arguments:
	// 	env = evnironment variable
	// Returns:
	// 	expr evaluating environment
	public int eval(Environment env) throws EvalException {
		return expr.eval(env);
	}

	public String code() { return "("+expr.code()+")"; }

}
