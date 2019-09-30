package linkedList;
import java.util.*;
public class testing
{
	public static void main(String[] args)
	{
		LinkedList<String> ll = new LinkedList<String>();
		ll.insert("1");
		ll.insert("10",0);
		ll.insert("11",1);
		ll.insert("2");
		ll.insert("3");
		ll.insert("4",4);
		ll.testPrint();
		ll.remove();
		ll.remove();
		ll.remove();
		ll.remove();
		ll.testPrint();
		ll.insert("10",0);
		ll.testPrint();

	}
}
