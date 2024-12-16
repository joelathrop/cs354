// Class for NodeRd
// read statement

public class NodeRd extends Node {
	private NodeExpr expr;

	public NodeRd(NodeExpr expr) {
		this.expr = expr;
	}

	public int eval(Environment env) throws EvalException {
		int d = expr.eval(env);
		int i = (int) d;

	}
}
