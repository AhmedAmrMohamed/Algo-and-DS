package maxflow;
import java.util.*;

public class FordFulkerson
{
	private final Flownetwork network;
	private final int src,trg;
	private final int inf = 1<<30;
	private int vis[];
	private int maxflow;
	

	public FordFulkerson(Flownetwork fn)
	{
		network = fn;
		src     = fn.getsource();
		trg     = fn.gettarget();
		vis     = new int[fn.getsize()];
		maxflow = solve();
	}
	public int getmaxflow() { return maxflow; }

	private int findAugmentingPath()
	{
		// return true if a path exists(build path in the process;
		// return false otherwise.	
		vis = new int[network.getsize()];
		for(int i=0;i<network.getsize();i++) vis[i] = -1;

		//PriorityQueue<Integer> queue  = new PriorityQueue<Integer>();
		Stack<Integer> queue = new Stack<Integer>();
		int bottleneck = inf;
		int top;
		int res;
		queue.clear();
		queue.push(src);
		vis[src] = src;
		while(queue.size() != 0)
		{
			top = queue.pop();
			for(Edge edge : network.edges[top])
			{
				res  = edge.getresidual();
				if( vis[edge.v] == -1 && res != 0 )
				{
					vis[edge.v] = top;
					bottleneck  = Math.min(res,bottleneck);
					if(edge.v == trg) return bottleneck;
					queue.push(edge.v);
				}
			}
		}
		return -1 ;
	}
	
	public int solve()
	{
		// return the maximum flow.
		int  bottleneck = findAugmentingPath();
		int  flow = 0;
		int  cur , par;
		Edge edge;

		while (bottleneck != -1)
		{
			System.out.println("BN : " + bottleneck);
			cur   = trg;
			flow += bottleneck;
			while(cur != src) 
			{
				par  = vis[cur];
				edge = network.getEdge(par , cur);
				edge.addflow(bottleneck);
				edge = network.getEdge(cur , par);
				edge.addflow(-bottleneck);
				cur = par;
			}
			bottleneck = findAugmentingPath();
		}
		return flow;
	}

}
