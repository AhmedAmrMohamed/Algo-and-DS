package ass1;
import java.util.*;
public class Test
{
	public static void main(String[] args)
	{
		Random rand = new Random();
		int counter = 10;
		int nextop, val;
		Queuewith2stacks<Integer> qws = new Queuewith2stacks<Integer>();
		while(counter-- != 0)
		{
			nextop = rand.nextInt(2);
			val    = rand.nextInt(50);
			System.out.printf("op : %d , val : %d\n",nextop,val);
			if(nextop==0)
				System.out.println("poping : "+qws.pop()+"\n");
			else
				qws.push(val);
		}

	}
}
