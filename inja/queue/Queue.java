package queue;
public class Queue<gene>
{
  private class Node
    {
      gene item;
      Node next;
      public Node(gene item)
         { this.item = item;}
        @Override
          public String toString()
            {
              return this.item.toString()+' '+this.next;
            }
    }
    private Node last = null;
    private Node first  = null;
    public Boolean empty(){return first == null;}
    public void push(gene item)
      {
        Node newnode = new Node(item);
        if(empty())first = newnode;
        else
        last.next = newnode;
        last = newnode;

      }
      public gene pop()
        {
          Node temp = first;
          first = first.next;
          return temp.item;
        }
      public gene end()
      { return last.item;}
    public gene front()
      { return first.item;}
}
