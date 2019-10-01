package stack;
import java.util.*;
public class Testing
{
   public static void main(String[] args)
   {

     // LinkedStack stack  = new LinkedStack();
     Stack stack  = new Stack();
     System.out.println(stack.empty());
     Scanner in = new Scanner(System.in);
     int n = in.nextInt();
     while(n!=0)
      {
        --n;
        String inp = in.next();
        stack.push(inp);
      }
      while(!stack.empty())
        System.out.println(stack.pop());
   }
}
