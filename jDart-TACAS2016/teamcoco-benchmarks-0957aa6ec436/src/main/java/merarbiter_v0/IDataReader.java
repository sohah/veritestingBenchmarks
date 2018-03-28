package merarbiter_v0;

public interface IDataReader{
	public void setInput();
	public boolean hasData();
	public String readEvent();
	public void writeOutput();
}
