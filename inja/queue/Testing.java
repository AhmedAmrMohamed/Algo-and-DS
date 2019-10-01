package queue;
import java.util.*;
public class Testing
{
   public static void main(String[] args)
   {
     Queue qu = new Queue();
     qu.push("hello");
     System.out.printf("%s %s\n",qu.front(),qu.end());
     qu.push("there");
     System.out.printf("%s %s\n",qu.front(),qu.end());
     qu.push("mr.");
     System.out.printf("%s %s\n",qu.front(),qu.end());
     qu.push("fucker");
     System.out.printf("%s %s\n",qu.front(),qu.end());

     while(!qu.empty())
      {
        System.out.println(qu.pop());
      }

   }
 }
