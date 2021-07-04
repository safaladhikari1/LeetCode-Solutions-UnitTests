/*
   Longest Word in Dictionary
   
   Problem Source: https://leetcode.com/problems/longest-word-in-dictionary/
   
   ------
   
   Algorithm:
   
   Source: https://leetcode.com/problems/longest-word-in-dictionary/discuss/634793/Java-The-easiest-to-understand-trie-solution.-100-Explanation
   
   
   1. Since the question asks the longest word that can be built using one character at a time,
      using the words in a string[], we will have to use Trie data structure
      
   2. We first create a TreeNode for our Trie
   
    private class TreeNode
    {
       TreeNode[] children = new TreeNode[26];
       String word;

       TreeNode()
       {

       }
    }
    
    Every tree node has a 26 children TreeNode. 26 for 26 letter alphabets.
    We will also store the String word on that TreeNode.
    
   3. Now we can insert the word from the Strings[] array to our TreeNode
   
   private void insert(String word)
   {
      TreeNode current = root;
      
      for(char c : word.toCharArray())
      {
         if(current.children[c - 'a'] == null)
         {
            current.children[c - 'a'] = new TreeNode();
         }
         
         current = current.children[c - 'a'];
      }
      
      current.word = word;
   }
   
   Let's say we have a String[] array = ["w", "wo", "wor", "worl", "world"]
   
                     root
                     
               w ->  "w" (word field for TreeNode[w])    
           
           o -> "wo"
           
               r -> "wor"
               
           l -> "worl"
         
       d -> "world"
       
   Every level has 26 alphabets, and our current goes to every level on that particular letter.
   
  4. To find the longest Word, we will store all of our words on the above Tree
      
        for(String word : words)
        {
            insert(word);
        }
        
  5. Then we can use dfs(root) to recurse and find the longest word
  
   private void dfs(TreeNode node)
   {
      if(node == null)
      {
         return;
      }
      
      if(node.word != null)
      {
         if(node.word.length() > result.length())
         {
            result = node.word;
         }
         else if(node.word.length() == result.length() && node.word.compareTo(result) < 0)
         {
            result = node.word;
         }
      }
      
      for(TreeNode child : node.children)
      {
         if(child != null && child.word != null)
         {
            dfs(child);
         }
      }
   }
   
   If the node is null, return. This is our base case, that means there is no letter left in the Tree
   
   If the node.word != null, means there is a word that is stored there
   
         if(node.word.length() > result.length()) // If the word in that node is the longest than the result word
         {
            result = node.word;
         }
         else if(node.word.length() == result.length() && node.word.compareTo(result) < 0) // If the length of the word in that node is equal to result, check which one is lexicographically smaller. For example: "apple" or "apply"? apple.
         {
            result = node.word;
         }
         
    If the child is not null, then there are more letters store in the tree in that route. Go look for more words recursively.                               
       
  6. Since the result string is on global variable, it will only store the longest length, and returns it at the end. 

*/

class LongestWordDictionary
{
   private static TreeNode root;
   private static String result = "";
   
   public static void main(String[] args)
   {
      String[] testArray = new String[] {"w", "wo", "wor", "worl", "world"};
      
      root = new TreeNode();
      
      for(String word : testArray)
      {
         insert(word);
      }
      
      dfs(root);
      
      System.out.println(result);
   }
   
   private static void dfs(TreeNode node)
   {
      if(node == null)
      {
         return;
      }
      
      if(node.word != null)
      {
         if(node.word.length() > result.length())
         {
            result = node.word;
         }
         else if(node.word.length() == result.length() && node.word.compareTo(result) < 0)
         {
            result = node.word;
         }
      }
      
      for(TreeNode child : node.children)
      {
         if(child != null && child.word != null)
         {
            dfs(child);
         }
      }
   }
   
   private static void insert(String word)
   {
      TreeNode current = root;
      
      for(char c : word.toCharArray())
      {
         if(current.children[c - 'a'] == null)
         {
            current.children[c - 'a'] = new TreeNode();
         }
         
         current = current.children[c - 'a'];
      }
      
      current.word = word;
   }
}