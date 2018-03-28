package merarbiter_v1.edu.vanderbilt.isis.sm;

public interface IDataReader{
	public void setInput();
	public boolean hasData();
	public String readEvent();
	public void writeOutput();
}
