/*
Problem: Longest ZigZag Path in a Binary Tree (LeetCode 1372)
Link: https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/
Pattern: Propagate Information Downwards in DFS

Approach:
Ek zigzag function banayenge with:
(root, left, right)

Yahan left aur right current zigzag lengths represent karenge.

- Agar root == null ho,
  to return kar denge.

Har node par:
- max answer ko update karte rahenge using
  max(left, right)

Ab recursion calls karenge:

1. Left Recursion:
   zigzag(root.left, right + 1, 0)

   Kyunki zigzag length tabhi badegi
   jab previous move right side se aaya ho.
   Isliye:
   left = right + 1
   aur right reset ho jayega = 0

2. Right Recursion:
   zigzag(root.right, 0, left + 1)

   Kyunki zigzag tabhi continue karega
   jab previous move left side se aaya ho.
   Isliye:
   right = left + 1
   aur left reset ho jayega = 0

Agar zigzag continue nahi hota,
to value automatically reset ho jati hai
kyunki ek side hamesha 0 set ho rahi hai.

Traversal complete hone ke baad
final maximum answer return kar denge.

Time Complexity: O(n)
Space Complexity: O(h)
(h = height of tree / recursion stack)
*/

class Solution {
    int ans=0;
    public int longestZigZag(TreeNode root) {
        
        zigzag(root,0,0);
        return ans;
    }
    
    void zigzag(TreeNode root,int left,int right){
        if(root==null)return;

        ans=Math.max(ans,Math.max(left,right));

        zigzag(root.left,right+1,0);
        zigzag(root.right,0,left+1);

        return;
    }
}