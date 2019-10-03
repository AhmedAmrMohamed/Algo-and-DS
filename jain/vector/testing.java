package vector;
import java.util.*;
import java.lang.*;
public class testing
{
	public static void main(String args[])
	{
		Vector<String> vec = new Vector<String>();
		Scanner inp = new Scanner(System.in);
		int op;
		String re;
		System.out.println("append : 1\npop   : 2");
		while(true)
		{
			op = inp.nextInt();
			if(op == 0) vec.append(inp.next());
			if(op == 1) vec.pop();
			vec.testattr();
		}



		//Vector<Integer> vec = new Vector<Integer>();
		//for(int i=0;i<5;i++)
			//vec.append(i);
		//vec.testprint();
		//System.out.println("idx 3 : " + vec.getitem(3));
		//while(!vec.isEmpty())System.out.println(vec.pop());
		//vec.testprint();
		//for(int i=0;i<5;i++)
			//vec.append(i);
		//vec.setitem(3,10);
		//vec.testprint();
		//vec.clear();
		//vec.testprint();


	}
}
