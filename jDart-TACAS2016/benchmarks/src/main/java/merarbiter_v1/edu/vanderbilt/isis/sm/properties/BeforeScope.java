package merarbiter_v1.edu.vanderbilt.isis.sm.properties;

import merarbiter_v1.edu.vanderbilt.isis.sm.Interpreter;

public class BeforeScope implements Scope {

	private int active = UNKNOWN;

	public int isActive(Interpreter interpreter) {
		if (active == POST_ACTIVE){
			active = INACTIVE;
		}
		if (active == UNKNOWN && checkBeforeExpression(interpreter)){
			active = POST_ACTIVE;
		}
		return active;
	}
	
	public boolean checkBeforeExpression(Interpreter interpreter){
		return true;
	}
}
