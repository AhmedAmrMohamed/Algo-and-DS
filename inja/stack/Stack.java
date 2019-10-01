package stack;
public class Stack
{
    private String[] stack;
    private int idx=0;
    private int capacity = 2;
    public Stack()
      {
        stack = new String[capacity];
      }
      public Boolean empty()
      {
        return idx==0;
      }
      private void reSize(int newcapacity)
        {
          String[] temp = new String[newcapacity];
          for(int i=0;i<idx;++i)
            temp[i]=stack[i];
          stack=temp;
        }

        public void push(String item)
          {
            if(idx==stack.length)
              reSize(2*stack.length);
            stack[idx++]=item;
          }
          public String top()
          {
            return stack[idx-1];
          }
          public String pop()
            {
              if(idx>1&&idx==capacity/4)
                reSize(stack.length/2);
              return stack[--idx];
            }
            public int getcapacity(){return stack.length;}
  }
