package merarbiter_v2.edu.vanderbilt.isis.sm.properties;

import merarbiter_v2.edu.vanderbilt.isis.sm.Interpreter;

public class GlobalScope implements Scope {
	
	public int isActive(Interpreter interpreter) {
		return ACTIVE;
	}
}
