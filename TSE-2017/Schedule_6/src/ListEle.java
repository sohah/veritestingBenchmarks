
public class ListEle {
	Ele first;
	Ele last;
	int number;

	public ListEle(){
		first = new Ele(-1, -1);
		last = new Ele(-1, -1);
		number = 0;
	}
		
	public Ele getFirst() {
		return first.getNext();
	}
	public void setFirst(Ele _first) {
		first.setNext(_first);
	}
	public Ele getLast() {
		return last.getPrev();
	}
	public void setLast(Ele _last) {
		last.setPrev(_last);
	}
	
	public boolean isEmpty(){
		Ele ele = first.getNext();
		if(ele == null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int getNumber(){
		return number;
	}
	
	public void setNumber(int _number){
		number = _number;
	}


//	public int getMem_count() {
//		int number = 0;
//		Ele ele = first.getNext();
//		while(ele != null){
//			number = number + 1;
//			ele = ele.getNext();
//		}
//		return number;
//	}
	
}
