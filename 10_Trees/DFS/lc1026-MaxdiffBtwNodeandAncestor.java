/*
Problem: Maximum Difference Between Node and Ancestor (LeetCode 1026)
Link: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
Pattern: DFS

Approach:
DFS traversal use karenge.

Har descendant level par current path ka
maximum aur minimum value track karte rahenge.

- Agar current node ki value max se badi hai,
  to max update kar denge.

- Agar current node ki value min se chhoti hai,
  to min update kar denge.

Har node par:
- Current difference nikaalenge using
  abs(max - min)
  aur answer ke saath compare karke maximum store kar lenge.

Phir updated max aur min ke saath
left aur right subtree par DFS call kar denge.

Traversal complete hone ke baad final answer return kar denge.

Time Complexity: O(n)
Space Complexity: O(h)
(h = height of tree / recursion stack)
*/

class Solution {
    int ans=0;
    public int maxAncestorDiff(TreeNode root) {
        
        diff(root,root.val,root.val);
        return ans;

    }
    void diff(TreeNode root,int min,int max){
        if(root==null)return;

        if(root.val>max){
            max=root.val;
            ans=Math.max(ans,max-min);
        }
        else if(root.val<min){
            min=root.val;
            ans=Math.max(ans,max-min);
        }

        diff(root.left,min,max);
        diff(root.right,min,max);
    }
}