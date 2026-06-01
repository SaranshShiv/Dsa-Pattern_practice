/*
Problem: Find Duplicate Subtrees (LeetCode 652)
Link: https://leetcode.com/problems/find-duplicate-subtrees/
Pattern: DFS

Approach:
Ek hashmap bana lenge jo har subtree ki string representation
store karega along with its frequency.

Ek function banayenge jo har node ki subtree string return karega.

Function Logic:
- Agar root == null ho,
  to "n" return kar denge as a string
  (null ko represent karne ke liye).

- Ab current subtree ki string banayenge:
  current value + left subtree ki string + right subtree ki string

  Left aur right dono recursion calls se aayenge.

Example:
s = root.val + "," + left + "," + right

Ab check karenge:
- Agar hashmap me yeh string already present hai
  aur uski frequency 1 hai,
  to iska matlab yeh duplicate subtree second time mili hai,
  to current node ko answer list me add kar denge.

- Fir hashmap me us string ki frequency update kar denge
  using getOrDefault.

At last current subtree ki string return kar denge
taaki parent apni string bana sake.

Final me answer list return kar denge.

Time Complexity: O(n)
Space Complexity: O(n)
(HashMap + recursion stack + subtree strings)
*/

class Solution {
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        
        HashMap<String,Integer> map= new HashMap<>();
        getSubTreeString(root,map);
        return ans;
    }

    String getSubTreeString(TreeNode root,HashMap<String,Integer> map){
        if(root==null)return "n";

        String s= Integer.toString(root.val) + ","+getSubTreeString(root.left,map)+ ","+getSubTreeString(root.right,map);

        if(map.containsKey(s) && map.get(s)==1){
            ans.add(root);
        }
        map.put(s,map.getOrDefault(s,0)+1);

        return s;
    }
}