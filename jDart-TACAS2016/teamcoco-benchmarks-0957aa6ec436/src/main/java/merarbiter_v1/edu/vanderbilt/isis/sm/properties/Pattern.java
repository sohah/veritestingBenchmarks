package merarbiter_v1.edu.vanderbilt.isis.sm.properties;

import merarbiter_v1.edu.vanderbilt.isis.sm.Interpreter;


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
