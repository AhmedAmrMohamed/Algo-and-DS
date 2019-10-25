package ass1;
import java.util.*;
public class Test
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int counter = 30;
		int nextop, val;
		Queue<Integer> qws = new Queue<Integer>();
		while(counter-- != 0)
		{
			nextop = rand.nextInt(2);
			val    = rand.nextInt(50);
			if(nextop==0)
				System.out.println("poping : "+qws.dequeue());
			else
			{
				System.out.printf("pushing : %d\n",val);
				qws.enqueue(val);
			}
		}

	}
}
