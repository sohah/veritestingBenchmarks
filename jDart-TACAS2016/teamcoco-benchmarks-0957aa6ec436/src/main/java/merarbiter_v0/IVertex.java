package merarbiter_v0;
import java.util.*;

public interface IVertex {
	List<Transition> outgoing();
	List<Transition> incoming();
	void addOutgoing(Transition t);
	void addIncoming(Transition t);
	List<State> getPathToRoot();
	boolean isState();
	boolean isPseudostate();
}
