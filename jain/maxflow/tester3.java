package maxflow;
import java.util.*;

public class tester3
{
	public static void main(String[] args)
	{
		Flownetwork fn = new Flownetwork(10);
		fn.addEdge(0,1,100000);
		fn.addEdge(1,2,100000);
		fn.addEdge(0,3,100000);
		fn.addEdge(1,3,1);
		fn.addEdge(3,2,100000);

		fn.setsource(0);
		fn.settarget(2);

		fn.printer(); 

		FordFulkerson ff = new FordFulkerson(fn);
		System.out.println(ff.getmaxflow());

		fn.printer();
	}
}
