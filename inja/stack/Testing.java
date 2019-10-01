package stack;
import java.util.*;
public class Testing
{
   public static void main(String[] args)
   {

     Stack<Integer> stack  = new Stack<Integer>();
     System.out.println(stack.empty());
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     while(n!=0)
      {
        --n;
        int inp = in.nextInt();
        stack.push(inp);
      }
      while(!stack.empty())
        System.out.println(stack.pop());
   }
}
