public class Ele {
	Ele prev;
	Ele next;
	int val;
	int priority;
	
	public Ele(int prio, int val){
		this.priority = prio;
		this.prev = null;
		this.next = null;
		this.val = val;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int _val) {
		val = _val;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int _priority) {
		priority = _priority;
	}

	public Ele getPrev() {
		return prev;
	}

	public void setPrev(Ele _prev) {
		prev = _prev;
	}

	public Ele getNext() {
		return next;
	}

	public void setNext(Ele _next) {
		next = _next;
	}

}
