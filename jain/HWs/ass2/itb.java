package ass2;
import java.util.*;
public class itb
{
	public static String dec2bin(int value)
	{
		if(value==0) return "0";
		if(value==1) return "1";
		return dec2bin(value>>1) + (value&1);
	}
	public static void main(String[] argv)
	{
		Scanner scan = new Scanner(System.in);
		System.out.printf("Enter int value : ");
		int inp 	 = scan.nextInt();
		System.out.printf("binary value : %s\n",dec2bin(inp));
	}
}
