package merarbiter_v0;
import java.util.*;

public interface IRegionParent {
	List<Region> getRegions();
	Region getRegionParent();
	void addRegionChild(Region r);
	boolean isState();
}
