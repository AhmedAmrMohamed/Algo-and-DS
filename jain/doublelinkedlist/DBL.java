package doublelinkedlist;
import java.lang.String;
import java.util.Iterator;
public class DBL<gen> implements Iterable<gen>
{
	private class Node
	{
		Node next;
		Node prev;
		gen  value;
		public Node(gen value,Node next,Node prev)
		{
			this.value = value;
			this.next=next;
			this.prev=prev;
		}
	}
	private class iterfactory implements Iterator<gen>
	{
		private Node ptr = head;
		public boolean hasNext() {return ptr != null;}
		public gen next()
		{
			gen ret =  ptr.value;
			ptr = ptr.next;
			return ret;
		}
	}
	private int  size = 0;
	private Node head = null;
	private Node tail = null;

	public Iterator<gen> iterator() {return new iterfactory();}

	public boolean isEmpty()
		{return size==0;}

	public int getsize()
		{return size;}	
	
	public void clear()
		{tail = null; head = null;}

	private void pushfirst(gen value)
	{
		Node newnode = new Node(value,null,null);
		head = newnode;
		tail = newnode;
	}

	public void push_back(gen value)
	{
		Node newnode;
		if(isEmpty())
			pushfirst(value);
		else
		{
			newnode = new Node(value,null,tail);
			tail.next = newnode;
			tail = newnode;
		}
		++size;
	}

	public void push_front(gen value)
	{
		Node newnode;
		if(isEmpty())
			pushfirst(value);
		else
		{
			newnode = new Node(value,head,null);
			head.prev = newnode;
			head = newnode;
		}
		++size;
	}
	
	
	
	private Node getref(gen value)
	{
		Node curr = head;
		while(curr!=null)
			if(curr.value == value)
				return curr;
			else
				curr = curr.next;
		return new Node(null,null,null);
	}

	public boolean contains(gen value)
	{
		Node node = getref(value);
		return node.value != null;
	}
	public gen remove(gen value)
	{
		Node node = getref(value);
		if(node.value == null)
			return null;

		if(node.next == null)
			tail = node.prev;
		else
			node.next.prev = node.prev; 

	     if(node.prev == null)
			head = node.next;
		else
			node.prev.next = node.next;
		--size;
	    return node.value;
	}

	public void testprint()
	{
		System.out.println("----start testprint-----");
		Node curr = head;
		while(curr!=null)
		{
			System.out.println(curr.value);
			curr = curr.next;
		}
		System.out.println("----end testprint-----");
	}
	

	//public void insert(gen value,int pos)
	//{
	//}
	//public gen remove()
	//{
	//}
	
	//@Override 
	//public void testPrint()
	//{
		//String ret = "{";
		//for(int i=0;i<size;++i) ret += (String) 

	//}
}


 
