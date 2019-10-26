package maxflow;
import java.util.*;

public class Flownetwork
{
	private final int size;         //number of verticies
	private int source , target; 
	public  ArrayList<Edge>[] edges;

	public Flownetwork(int size)
	{
		this.size = size;
		this.edges = new ArrayList[size];
		for(int i=0;i<size;++i) this.edges[i] = new ArrayList<Edge>();

	}
	public  int getsource() { return source; }
	public  int gettarget()	{ return target; }
	public  int getsize()   { return size;   }

	public  void setsource(int source) { this.source = source; }
	public  void settarget(int target) { this.target = target; }

	public void addEdge(int u,int v,int capacity)
	{
		Edge edge = new Edge(u,v,capacity);
		//System.out.println("edge");
		edges[u].add(edge);
	}

	public Edge getEdge(int u,int v)
	{
		for(Edge edge : edges[u]) if( edge.v == v) return edge;
		return null;	
	}

	public void printer()
	{
		for(int i=0;i<size;i++)
			for(Edge edge : edges[i])
				System.out.println(edge);
	}

}
