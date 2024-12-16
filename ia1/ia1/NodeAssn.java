public class NodeAssn extends Node {

	private String id;
	private NodeExpr expr;

	// constructor initializes id, and expr Node
	public NodeAssn(String id, NodeExpr expr) {
		this.id = id;
		this.expr = expr;
	}

	// eval method evaluates the environment
	public int eval(Environment env) throws EvalException {
		return env.put(id, new NodeWr(expr).eval(env));
	}

	// code method returns expression code
	public String code() {
		return id + "=" + expr.code() + ";" + new NodeWr(expr).code();
	}

}
