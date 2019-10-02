package doublelinkedlist;
import java.util.*;
public class testing
{
	public static void main(String args[])
	{
		System.out.println("there was explicit language here so i removed it :(");
		DBL<String> dbl = new DBL<String>();
		dbl.push_front("Amr");
		dbl.push_front("Ahmed");
		dbl.push_back("Mohamed");
		System.out.println(">>>start loop");
		for(String tmpstr : dbl)
			System.out.println(tmpstr);
		System.out.println(">>>end loop");
		dbl.remove("Amr");
		dbl.remove("Ahmed");
		dbl.remove("Mohamed");
		System.out.println(">>>start loop");
		for(String tmpstr : dbl)
			System.out.println(tmpstr);
		System.out.println(">>>end loop");


	}
}
