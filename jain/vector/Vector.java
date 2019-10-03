package vector;
import java.lang.String;
import java.util.Iterator;
public class Vector<gen>
{
	private int capacity = 2;
	private int length   = 0;
	private gen array[] = (gen[]) new Object[capacity];

	private void rebound()
	{
		if(length == capacity)
			resize(capacity<<1);
		else if (length<<2 == capacity)
			resize(capacity>>1);
	}

	private void resize(int newcap)
	{
		capacity = newcap;
		gen newarray[] = (gen[]) new Object[capacity];
		int ptr = 0;
		while(ptr<length)
			newarray[ptr] = array[ptr++];
		array = newarray;
	}

	private boolean valid(int index)
		{ return (0 <= index && index < length);}
	

	public boolean isEmpty()
		{ return length==0;}
	

	public void clear()
		{ length = 0; resize(2);}
	
	public void setitem(int index, gen value)
	{
		if(valid(index))
			array[index] = value;
	}

	public gen getitem(int index)
	{
		gen ret = null;
		if(valid(index))
			ret = array[index];
		return ret;
	}
	public void append(gen value)
	{
		array[length++] = value;
		rebound();
	}
	public gen pop()
	{
		gen ret = array[--length];
		rebound();
		return ret;
	}

	public int find(gen value)
	{
		for(int i=0;i<length;++i)
			if (array[i] == value)
				return i;
		return -1;
	}	

	public void testprint()
	{
		System.out.println("********** length "+ length+ " capacity "+ capacity);
		for(int i=0;i<length;i++)
			System.out.println(array[i]);
		System.out.println("##########");
	}
	public void testattr()
	{
		System.out.printf("len : %d , cap : %d \n",length,capacity);
	}


}
