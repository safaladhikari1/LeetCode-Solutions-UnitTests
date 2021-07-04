/*
   Unique Number Of Occurrences
   
   Problem Source: https://leetcode.com/problems/unique-number-of-occurrences/
   
   ------
   
   Algorithm:
   
   1. We have an input array
   
      [1, 2, 2, 1, 1, 3]
      
      1 - 3
      2 - 2
      3 - 1
      
      Every element's count is unique, so it returns true. Otherwise, false.
      
  2. We will create Map<Integer, Integer>
     key - element
     value - occurrences
     
     Put all the elements from input array to the map
     Now we will have,
     
      1 - 3
      2 - 2
      3 - 1
      
      on our Map
      
  3. Now we can put the map.values() on our HashSet. HashSet does not allow duplicates
  
  4. So we can just check if map.size() == hashset.size()
     
     If all the element's count is unique, their size will also equal. Otherwise no equal, and returns false.
     
     ---------
     
     Time-Complexity: O(N), where N is the number of elements in the array
     Space-Complexity: O(N), for the map and set.     
*/

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

class UniqueNumberOfOccurrences
{
   public static void main(String[] args)
   {
      System.out.println(uniqueOccurrences(new int[] {1, 2}));
   }
   
   public static boolean uniqueOccurrences(int[] arr)
   {
      Map<Integer, Integer> countMap = new HashMap<>();
      
      for(int element : arr)
      {         
         countMap.put(element, countMap.getOrDefault(element, 0) + 1);
      }
      
      Set<Integer> duplicateChecker = new HashSet<>(countMap.values());
      
      return countMap.size() == duplicateChecker.size();
   }
}