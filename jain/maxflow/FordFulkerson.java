package maxflow;
import java.util.*;

public class FordFulkerson
{
	private final Flownetwork network;
	public int vis[];
	public Stack<Edge> path;
	private int maxflow;

	public FordFulkerson(Flownetwork fn)
	{
		network = fn;
		vis    = new int[fn.getsize()];
		maxflow = solve();
		//boolean flag  = findAugmentingPath();
		//System.out.println("path exsists : " + flag);
		//if(flag) System.out.println("bottleneck : " + buildAugmentingPath());

	}
	public int getmaxflow() { return maxflow; }

	private boolean findAugmentingPath()
	{
		// return true if a path exists(build path in the process;
		// return false otherwise.	
		vis = new int[network.getsize()];
		for(int i=0;i<network.getsize();i++) vis[i] = -1;

		PriorityQueue<Integer> queue  = new PriorityQueue<Integer>();
		int src = network.getsource();
		int trg = network.gettarget();
		int top;
		queue.clear();
		queue.add(src);
		vis[src] = src;
		while(queue.size() != 0)
		{
			top = queue.remove();
			//System.out.println("top " + top);
			for(Edge edge : network.edges[top])
			{
				//System.out.printf("top : %d , res : %d , v : %d \n" , top,edge.getresidual(),edge.v); 
				if( vis[edge.v]        != -1 ) continue;
				if( edge.getresidual() ==  0 ) continue;
				vis[edge.v] = top;
				queue.add(edge.v);
				if(edge.v == trg) return true;
			}
		}
		return false;
	}
	
	private int buildAugmentingPath()
	{
		int trg = network.gettarget();
		int src = network.getsource();
		int cur = trg;
		int nxt;
		int bottleneck = 1 << 30;
		path = new Stack<Edge>();
		while(cur != src)
		{
			nxt = vis[cur];
			Edge tmp = network.getEdge(nxt,cur);
			//System.out.printf("nxt %d , cur %d\n" , nxt , cur);
			//System.out.println(tmp);
			//System.out.println(tmp == null);
			path.push(tmp);
			bottleneck = Math.min(bottleneck,tmp.getresidual());			
			cur = nxt;
		}

		return bottleneck;
	}
	public int solve()
	{
		// return the maximum flow.
		boolean pathfound = findAugmentingPath();
		int     bottleneck;
		Edge    edge;
		int     flow = 0;
		while (pathfound == true)
		{
			bottleneck = buildAugmentingPath();
			System.out.println("BN : " + bottleneck);
			flow      += bottleneck;
			while(!path.empty())
			{
				edge = path.pop();
				edge.addflow(bottleneck);
			}
			pathfound = findAugmentingPath();
		}
		return flow;
	}

}
