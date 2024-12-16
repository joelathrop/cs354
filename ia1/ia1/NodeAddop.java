public class NodeAddop extends Node {

	private String addop;

	// Constructor initializes position, addop
	public NodeAddop(int pos, String addop) {
		this.pos=pos;
		this.addop=addop;
	}

	// op method defines plus and minus operators
	public int op(int o1, int o2) throws EvalException {
		if (addop.equals("+"))
			return o1+o2;
		if (addop.equals("-"))
			return o1-o2;
		throw new EvalException(pos,"bogus addop: "+addop);
	}

	public String code() { return addop; }

}
