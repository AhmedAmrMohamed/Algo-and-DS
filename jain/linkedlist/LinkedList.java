package linkedList;
public class LinkedList<gen>
{
	private class node
	{
		node next;
		gen  val;
		public node(gen val,node next)
		{
			this.val = val;
			this.next=next;
		}
	}

	private int  size = 0;
	private node first = null;

	public void insert(gen value)
	{
		node newnode = new node(value,first);
		first = newnode;
		size += 1;
	}
	public void insert(gen value,int pos)
	{
		if(pos==0)
			insert(value);
		else
		{
			node curr = first;
			for(int i=0;i<pos-1;i++)
				curr  = curr.next;
			node newb = new node(value,curr.next);
			curr.next = newb;
			size+=1;
		}
	}
	public gen remove()
	{
		gen ret = first.val;
		first   = first.next;
		return ret;
	}
	public void testPrint()
	{
		System.out.println("/////////start testprint////////");
		node curr = first;
		while(curr!=null){System.out.println(curr.val);curr = curr.next;}
		System.out.println("/////////end testprint////////");
	}
}


 
