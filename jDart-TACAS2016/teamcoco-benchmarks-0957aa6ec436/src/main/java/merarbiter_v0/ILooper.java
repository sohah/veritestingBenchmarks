package merarbiter_v0;

public interface ILooper {
	void setInterpreter(Interpreter interpreter);	
	void doEventLoop();
	void doDataAndEventLoop();
}
