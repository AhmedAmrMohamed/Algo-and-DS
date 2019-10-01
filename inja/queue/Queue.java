package queue;
public class Queue
{
  private class Node
    {
      String item;
      Node next;
      public Node(String item)
         { this.item = item;}
        @Override
          public String toString()
            {
              return this.item+' '+this.next;
            }
    }
    private Node tst = new Node("null");
    private Node last = null;
    private Node first  = null;
    public Boolean empty(){return first == null;}
    public void push(String item)
      {
        Node newnode = new Node(item);
        if(empty())first = newnode;
        else
        last.next = newnode;
        last = newnode;

      }
      public String pop()
        {
          Node temp = first;
          first = first.next;
          return temp.item;
        }
      public String end()
      { return last.item;}
    public String front()
      { return first.item;}
}
