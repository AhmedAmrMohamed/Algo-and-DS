package maxflow;
import java.util.*;

public class tester
{
	public static void main(String[] args)
	{
		Flownetwork fn = new Flownetwork(10);
		fn.addEdge(1,2,4);
		fn.addEdge(2,3,4);
		fn.addEdge(3,4,2);
		fn.addEdge(1,6,3);
		fn.addEdge(6,5,6);
		fn.addEdge(5,4,6);
		fn.addEdge(3,6,3);

		fn.setsource(1);
		fn.settarget(4);

		fn.printer(); 

		FordFulkerson ff = new FordFulkerson(fn);
		System.out.println(ff.getmaxflow());

		fn.printer();
	}
}
