import java.util.EmptyStackException;

/*
class MinStack<T>
{
   private StackNode<T> top;
   
   public MinStack()
   {
      top = new StackNode<T>(null);
   }
   
   private static class StackNode<T>
   {
      T data;
      StackNode<T> next;
      
      StackNode(T data)
      {
         this.data = data;
      }
   }
   
   public void push(T data)
   {
      if(top == null)
      {
         top = new StackNode<T>(data);
      }
      else
      {
         StackNode<T> t = new StackNode<T>(data);
         t.next = top;
         top = t; 
      }
   }
   
   public T pop()
   {
      if(top == null)
      {
         throw new EmptyStackException();
      }
      
      T data = top.data;
      top = top.next;
      return data;    
   }
   
   public T top()
   {
      if(top == null)
      {
         throw new EmptyStackException();
      }
      
      return top.data;
   }
   
   public T getMin()
   {
      StackNode<T> front = top;
      
      T data = top.data;
      
      while(front != null)
      {
         if(data < front.data)
         {
            data = front.data;
         }
         
         front = front.next;
      }
      
      return data;     
   }
}
*/