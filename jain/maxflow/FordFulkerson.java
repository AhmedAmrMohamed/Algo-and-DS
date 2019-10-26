package maxflow;
import java.util.*;

public class FordFulkerson
{
	private final Flownetwork network;
	private final int src,trg;
	public int vis[];
	public Stack<Edge> path;
	private int maxflow;

	public FordFulkerson(Flownetwork fn)
	{
		network = fn;
		src     = fn.getsource();
		trg     = fn.gettarget();
		vis     = new int[fn.getsize()];
		maxflow = solve();
		//boolean flag  = findAugmentingPath();
		//System.out.println("path exsists : " + flag);
		//if(flag) System.out.println("bottleneck : " + buildAugmentingPath());

	}
	public int getmaxflow() { return maxflow; }

	private int findAugmentingPath()
	{
		// return true if a path exists(build path in the process;
		// return false otherwise.	
		vis = new int[network.getsize()];
		for(int i=0;i<network.getsize();i++) vis[i] = -1;

		PriorityQueue<Integer> queue  = new PriorityQueue<Integer>();
		int bottleneck = 1<<30;
		int top;
		int res;
		queue.clear();
		queue.add(src);
		vis[src] = src;
		while(queue.size() != 0)
		{
			top = queue.remove();
			for(Edge edge : network.edges[top])
			{
				res  = edge.getresidual();
				//System.out.printf("top : %d , res : %d \n",top,res);
				if( vis[edge.v] == -1 && res != 0 )
				{
					vis[edge.v] = top;
					bottleneck  = Math.min(res,bottleneck);
					if(edge.v == trg) return bottleneck;
					queue.add(edge.v);
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
