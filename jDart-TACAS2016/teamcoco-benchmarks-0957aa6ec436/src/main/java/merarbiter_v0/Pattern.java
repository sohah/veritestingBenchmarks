package merarbiter_v0;


public class Pattern {
	public Scope scope;
	public String id;
	
	public boolean checkProperty(Interpreter interpreter) {
		return true;
	}
	
	// Virtual method to be over-written in generated code
	protected boolean checkExpression(Interpreter interpreter){
		return false;
	}
}
