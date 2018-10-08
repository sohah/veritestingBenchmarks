import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Schedule {

	public static final int MAXPRIO = 3;
	
	public static int alloc_proc_num;
	//
//	public static int num_processes;
//	//
//	public static Ele cur_proc;
	//
	public static ListEle[] prio_queue;
	//
	public static Ele[] block_queue;
	public static int block_in;
	public static int block_out;
	public static final int block_length = 3;
//	//
//	public static int rand_prio = 0;
//	//
//	public static double rand_ratio = 0.0;
	
	public static void main(String[] args) {
		mainProcess(6, 1, 2, 5, 3, 4);
	}
	
	//
	public static void initialize(){
		alloc_proc_num = 0;
//		num_processes = 0;
		prio_queue = new ListEle[MAXPRIO+1];
		for(int i=0; i<=MAXPRIO; i++){
			prio_queue[i] = new ListEle();
		}
		block_queue = new Ele[block_length];
		for(int i=0; i<block_length; i++){
			block_queue[i] = null;
		}
		block_in = 0;
		block_out = 0;
		
	}
	public static void mainProcess(int a1, int a2, int a3, int a4, int a5, int a6){
		initialize();
		//
		int[] argv = {0, 20, 18, 19};
		for(int prio=MAXPRIO; prio>0; prio--){
			//
			init_prio_queue(prio, argv[prio]);
		}
		//
		//		
		for(int i=0; i < 6;){
			if(i == 0){
				mainMethod(a1, 2, 0.03);
			}
			else if(i == 1){
				mainMethod(a2, 1, 0.02);
			}
			else if(i == 2){
				mainMethod(a3, 2, 0.01);
			}
			else if(i == 3){
				mainMethod(a4, 1, 0.005);
			}
			else if(i == 4){
				mainMethod(a5, 3, 0.003);
			}
			else if(i == 5){
				mainMethod(a6, 1, 0.001);
			}
			i = i + 1;
		}
	}

	private static void mainMethod(int a, int prio, double ratio) {
		if(a==1){
			//
			unblock_process(ratio);
		}
		else if(a==2){
			//
			block_process();
		}
		else if(a==3){
			//
			add_process(prio);
		}
		else if(a==4){
			//
			upgrade_process_prio(prio, ratio);
		}
		else if(a==5){
			//
			//
			quantum_expire();
		}
		else if(a==6){
			//
			finish_process();
		}

	}
	
	/*
	 * 
	 */
//	private static void finish_all_processes() {
//		Ele cur_proc = scheduleM();
//		while(cur_proc != null){
//			free_ele(cur_proc);
//			cur_proc = scheduleM();
//		}
//	}

	/*
	 * 
	 */
	private static void finish_process() {
		Ele cur_proc = scheduleM();
		if(cur_proc != null){
			free_ele(cur_proc);
//			num_processes = num_processes - 1;
		}
		
	}

	private static void free_ele(Ele cur_proc) {
		cur_proc = null;		
	}

	/**
	 * 
	 */
	private static void quantum_expire() {
		Ele cur_proc = scheduleM();
		if(cur_proc != null){
			int prio = cur_proc.getPriority();
			ListEle prio_queue_prio = prio_queue[prio];
			append_ele(prio_queue_prio, cur_proc);
		}
	}

	/*
	 * 
	 */
	private static void unblock_process(double ratio) {
		//
		Ele proc = block_queue[block_out];
		if(proc != null){
			block_queue[block_out] = null;
			block_out = block_out + 1;
			block_out = block_out % block_length;
			int prio = proc.getPriority();
			ListEle prio_queue_prio = prio_queue[prio];
			append_ele(prio_queue_prio, proc);
		}
//		int count = block_queue.getNumber();
//		int n = (int)(count*ratio + 1);
//		Ele proc = find_nth(block_queue, n);
//		if(proc != null){
//			del_ele(block_queue, proc);
//			int prio = proc.getPriority();
//			ListEle prio_queue_prio = prio_queue[prio];
//			append_ele(prio_queue_prio, proc);
//		}		
	}

	/*
	 * 将
	 */
	private static void block_process() {
		Ele cur_proc = scheduleM();
		if(cur_proc != null){
			block_queue[block_in] = cur_proc;
			block_in = block_in + 1;
			block_in = block_in % block_length;
//			append_ele(block_queue, cur_proc);
		}
	}

	/*
	 * 
	 */
	private static Ele scheduleM() {
		Ele cur_proc = null;
		for(int i=MAXPRIO; i>0; i--){
			ListEle prio_queue_i = prio_queue[i];
			boolean isEmpty = prio_queue_i.isEmpty();
			if(!isEmpty){
				cur_proc = prio_queue_i.getFirst();
				del_ele(prio_queue_i, cur_proc);
				return cur_proc;
			}
		}
		return null;
	}
	
	/**
	 * 
	 */
	private static void upgrade_process_prio(int prio, double ratio) {
		//
		if(prio >= MAXPRIO){
			return;
		}
		ListEle src_queue = prio_queue[prio];
		ListEle dst_queue = prio_queue[prio+1];
		boolean isEmpty = src_queue.isEmpty();
		if(!isEmpty){
			int count = src_queue.getNumber();
			int n = (int) (count * ratio + 1);
			Ele proc = find_nth(src_queue, n);
			if(proc != null){
				del_ele(src_queue, proc);
				//
				proc.setPriority(prio);
				append_ele(dst_queue, proc);
			}
		}
	}

	/**
	 * 
	 */
	private static void del_ele(ListEle src_queue, Ele proc) {
		//
		//
		Ele procNext = proc.getNext();
		Ele procPrev = proc.getPrev();
		if(procNext != null){
			procNext.setPrev(procPrev);
		}
		else{
			src_queue.setLast(procPrev);
		}
		if(procPrev != null){
			procPrev.setNext(procNext);
		}
		else{
			src_queue.setFirst(procNext);
		}
		int number = src_queue.getNumber();
		number = number - 1;
		src_queue.setNumber(number);
	}

	private static Ele find_nth(ListEle src_queue, int n) {
		//
		Ele element = src_queue.getFirst();
		//
		for(int i=1; i<n; i++){
			element = element.getNext();
		}
		return element;
	}
	
	/**
	 * 
	 */
	private static void add_process(int prio) {
		Ele proc = new_Ele(prio);
		ListEle prio_queue_prio = prio_queue[prio];
		append_ele(prio_queue_prio, proc);
		
	}
	
//	/**
//	 * 
//	 */
//	private static int prio_generator(){
//		rand_prio = rand_prio + 1;
//		if(rand_prio >= MAXPRIO){
//			rand_prio = 1;
//		}
//		return rand_prio;
//	}
//	
//	private static double ratio_generator(){
//		rand_ratio = rand_ratio + 0.1;
//		if(rand_ratio > 0.9){
//			rand_ratio = 0.1;
//		}
//		return rand_ratio;
//	}

	/**
	 * Generate an element, prio is the priority, alloc_proc_num is the value of the element
	 */
	private static Ele new_Ele(int prio){
		Ele proc = new Ele(prio, alloc_proc_num);
		alloc_proc_num = alloc_proc_num + 1;
//		num_processes = num_processes + 1;
		return proc;
	}
	
	/**
	 *
	 */
	private static void init_prio_queue(int prio, int num_proc) {
		ListEle queue = new ListEle();
		Ele proc;
		for(int i=0; i<num_proc; i++){
			proc = new_Ele(prio);
			append_ele(queue, proc);
		}
		prio_queue[prio] = queue;
	}

	/**
	 * 
	 */
	private static void append_ele(ListEle queue, Ele proc) {
		// 
		Ele queueLast = queue.getLast();
		//
		proc.setPrev(queueLast);
		if(queueLast != null){
			queueLast.setNext(proc);
		}
		else{
			queue.setFirst(proc);
		}
		queue.setLast(proc);
		//
		proc.setNext(null);
		
		int number = queue.getNumber();
		number = number + 1;
		queue.setNumber(number);
	}

}
