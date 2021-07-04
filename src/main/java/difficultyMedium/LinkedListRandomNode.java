/*
   Linked List Random Node
   
   Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
   
   Problem Source: https://leetcode.com/problems/linked-list-random-node/
   
   Example:
   
   If we have a Linked List of [1, 2, 3]
   
   Let's say we have a Solution class that receives the above LinkedList's head as constructor,
   and makes an object out of it.
   
   Solution solution = new Solution(head);
   
   Then, solution.getRandom() should return a random node's value from the Linked List.
   
   So, it should look like:
   
   solution.getRandom() = 1
   solution.getRandom() = 3
   solution.getRandom() = 2
   solution.getRandom() = 2
   
   ------
   
   Approach 1 (Brute Force)
   
   1. Inside the getRandom() or the Solution constructor
      
      we can traverse through the elements of the LinkedList
      as we are traversing, we can add the node values on our ArrayList
      
      private ArrayList<Integer> range = new ArrayList<>();
      
      while (head != null) 
      {
         this.range.add(head.val);
         head = head.next;
      }
      
      Then we know how many nodes are in the LinkedList, based on the size of ArrayList
      
   2. We can use our getRandom() method to pick a random node's value from our ArrayList
   
   It's also described on:
   
   Fixed-Range Sampling:  https://leetcode.com/problems/linked-list-random-node/solution/ 
   
   Time-Complexity: O(N), where N is the number of elements in the list
   Space-Complexity: O(N), we are storing N number of elements in our ArrayList.
   
   ---------
   
   Approach 2 (Reservoir Sampling)
   
   1. Same concept as above, but instead of storing our node values in the ArrayList, we will
      tweak our getRandom() method as follows:
      
      Let's say we have a linkedList
      
      1 -> 2 -> 3
      
      Inside of getRandom()
      
      our count will be 0
      we will also instantiate our result variable to 0
      
      while(current != null)
      
         int ran, which stores the random variable = myRand.nextInt(count + 1)
         
         At first loop:
            ran = myRand.nextInt(0 + 1)
                = myRand.nextInt(0 + 1)
                = 0
         
         // If the random value is equal to our count
         // the probability of getting ran (0) equal to count (0) is 1
         // It means, it will happen.
         if(ran == count)
         {
            // we will store the current.val to our result variable
            result = current.val;
         }
         
         count++;
         current = current.next;
         
   2. At second loop,
            
         ran = myRand.nextInt(1 + 1);
             = myRand.nextInt(2); // So it can return either 0 or 1
             
         // the probability of getting ran (0 or 1) equal to count (1) is 1/2
         if(ran == count)    
         {
            result = current.val; // if it's equal we will replace our result.
         }
         
         count increments, which is equal 2
         current = current.next;
            
   3. At third loop,
         
         ran = myRandom.nextInt(2 + 1);   
             = myRandom.nextInt(3)
             
         // the probability of getting ran (0 or 1 or 2) equal to count (2) is 1/3
         if(ran == count)    
         {
            result = current.val; // if it's equal we will replace our result.
         }                         
                                      
    4. So, this way the probability of getting an x node out of n (number of nodes in the list) is
       
       1 / count + 1
       
    5. The other way to put it,
       
       The probability of not getting the first node value:
       
       1 
       
       The probability of not getting the second node value:
       
       1 / 2
       
       The probability of not getting the third node value:
       
       2 / 3 because ( 1 - (1/3))
       
       And so on.
       
    6. Regarding "382. Linked List Random Node" if interviewer asks us why the code works with equal probability we can say
       We want to prove any one node has 1/n probability. Lets prove it for head
       Let assume when x nodes the probability is 1/x
       when next item is seen, then the new item has 1/(x+1) probability of being picked
       Which means (1 - 1/(x+1) prob of head remainng as picked. which is x/(x+1)
       Multiply 1/x and x/(x+1) we have  1/(x+1)
       1/1 probabiliy if n=1, so by above it is valid for n=2, n=3.... So by induction 1/n is the probabiliy with n items  
      
       At first it looks like, the first element has the probability of selection to be 100%. But imagine it as a stream of integers of variable size and not fixed one, then each point will have equal probability of picking ,if we are iterating through the stream.              
       
    7. More resources on this topic:
    
       https://leetcode.com/problems/linked-list-random-node/discuss/85659/Brief-explanation-for-Reservoir-Sampling
       
       https://youtu.be/A1iwzSew5QY   
   
       https://leetcode.com/problems/linked-list-random-node/discuss/85662/Java-Solution-with-cases-explain
       
       https://en.wikipedia.org/wiki/Reservoir_sampling#cite_note-vitter-1
       
    ---------
    Time-Complexity: getRandom() method is O(N), where N is the number of elements in the list
    Space-Complexity: O(1) because we did not use any space on this solution.
       
*/


import java.util.Random;

class LinkedListRandomNode
{
   public static void main(String[] args)
   {
      ListNode myList = new ListNode(1, new ListNode(2, new ListNode(3)));
      
      LinkedListRandomNode myTest = new LinkedListRandomNode(myList);
      
      System.out.println(myTest.getRandom());      
      
   }
   
   private static ListNode head;
   private static Random random;
   
   public static ListNode getHead()
   {
      return head;   
   }
   
   public LinkedListRandomNode(ListNode head)
   {
      this.head = head;
      this.random = new Random();
   }
   
   public static int getRandom()
   {
      int count = 0;
      int result = 0;         
           
      ListNode current = getHead();
      
      while(current != null)
      {
         int ran = random.nextInt(count + 1);
         
         if(ran == count)
         {
            result = current.val;
         }
         
         count++;
         current = current.next;        
      }
         
      return result;
   }
   
   private static class ListNode
   {
      int val;
      ListNode next;
      
      ListNode()
      {
      
      }
      
      ListNode(int val)
      {
         this.val = val;
      }
      
      ListNode(int val, ListNode next)
      {
         this.val = val;
         this.next = next;
      }     
   }
}