package maxflow;
public class Edge
{
	public final int u,v;
	private int flow , capacity;
	public Edge(int u,int v,int capacity)
	{
		this.u        = u;
		this.v        = v;
		this.capacity = capacity;
	}

	public int  getcapacity() { return capacity;}
	public int  getflow()     { return flow;    }
	public int  getresidual() { return capacity - flow;}
	public void setcapacity(int val) { this.capacity = capacity;}
	public void addflow(int flow)
	{
		if(this.flow + flow > capacity) throw new RuntimeException("not enough capacity to make this flow.");
		this.flow += flow;
	}
	@Override
	public String toString() { return String.format("%d --(%d/%d)--> %d",u,flow,capacity,v);}
}
