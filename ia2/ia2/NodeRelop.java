// This class instantiates relationship operations

public class NodeRelop extends Node {
	
	private String relop;

	//constructor initializes position, relop
	public NodeRelop(int pos, String relop) {
		this.pos = pos;
		this.relop = relop;
	}

	// op method defines the following operators:
	// 	less than: <
	// 	less than or equal to: <=
	// 	greater than: >
	// 	greater than or equal to: >=
	// 	not equal: <>
	// 	equal: ==
	public double op(double o1, double o2) throws EvalException {
		if (relop.equals("<")) {
			if (o1 < o2){
				return 1.0;
			} else {
				return 0.0;
			}
		}
		if (relop.equals("<=")) {
			if (o1 <= o2) {
				return 1.0;
			} else {
				return 0.0;
			}
		}
		if (relop.equals(">")) {
			if (o1 > o2) {
				return 1.0;
			} else {
				return 0.0;
			}
		}
		if (relop.equals(">=")) {
			if (o1 >= o2) {
				return 1.0;
			} else {
				return 0.0;
			}
		}
		if (relop.equals("<>")) {
			if (o1 != o2) {
				return 1.0;
			} else {
				return 0.0;
			}
		}
		if (relop.equals("==")) {
			if (o1 == o2) {
				return 1.0;
			} else {
				return 0.0;
			}
		}
	}

	public String code() { return relop; }

