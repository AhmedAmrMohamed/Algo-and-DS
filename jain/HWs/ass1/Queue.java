package ass1;
import java.util.*;
public class Queue<item>
{
	private Stack<item> pusher = new Stack<item>();
	private Stack<item> holder = new Stack<item>();
	private int size  = 0;
	
	public void enqueue(item value)
	{
		pusher.push(value);
		++size;
	}
	public void clear()
	{
		pusher.clear();
	}
	private void transfer(Stack src,Stack dst)
	{
		while(!src.isempty())
		{
			item tmp = (item)src.pop();
			dst.push(tmp);
		}
	}
	public item dequeue()
	{
		if(pusher.isempty())return null;
		holder.clear();
		transfer(pusher,holder);
		item top = holder.pop();
		pusher.clear();
		transfer(holder,pusher);
		--size;
		return top;
	}
	public Boolean isempty()
	{
		return pusher.isempty();
	}
	public int size()
	{
		return size;
	}

	
}

