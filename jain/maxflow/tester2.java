package maxflow;
import java.util.*;

public class tester2
{
	public static void main(String[] args)
	{
		Flownetwork fn = new Flownetwork(10);
		fn.addEdge(0,1,1);
		fn.addEdge(2,3,1);
		fn.addEdge(0,2,1);
		fn.addEdge(1,3,1);
		fn.addEdge(1,4,1);
		fn.addEdge(3,5,1);
		fn.addEdge(4,5,1);

		fn.setsource(0);
		fn.settarget(5);

		fn.printer(); 

		FordFulkerson ff = new FordFulkerson(fn);
		System.out.println("max flow : " + ff.getmaxflow());

		fn.printer();
	}
}
