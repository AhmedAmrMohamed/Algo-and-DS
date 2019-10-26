package maxflow;
import java.util.*;

public class tester2
{
	public static void main(String[] args)
	{
		Flownetwork fn = new Flownetwork(10);
		fn.addEdge(0,1,5);
		fn.addEdge(1,2,3);
		fn.addEdge(2,4,1);
		fn.addEdge(4,3,5);
		fn.addEdge(5,4,5);
		fn.addEdge(1,4,5);
		fn.addEdge(2,6,3);
		fn.addEdge(0,6,5);

		fn.setsource(0);
		fn.settarget(3);

		fn.printer(); 

		FordFulkerson ff = new FordFulkerson(fn);
		System.out.println(ff.getmaxflow());

		fn.printer();
	}
}
