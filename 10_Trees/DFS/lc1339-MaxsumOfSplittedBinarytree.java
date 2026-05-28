/*
Problem: Maximum Product of Splitted Binary Tree (LeetCode 1339)
Link: https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
Pattern: DFS

Approach:
Sabse pehle poore tree ka total sum calculate karenge,
kyunki hume yeh pata hona chahiye ki tree ko kis jagah cut karne par
do parts ka product maximum banega.

Key Point:
Best division wahi hoga jahan dono splitted trees ka difference minimum ho,
kyunki tab unka product maximum aata hai.

Ab second DFS me subtree sums calculate karenge using postorder traversal.

- Pehle left subtree ka sum nikalo.
- Phir right subtree ka sum nikalo.
- Fir current subtree sum nikaalo:
  currSum = root.val + left + right

Ab agar iss edge par tree cut karein,
to doosre part ka sum hoga:
  totalSum - currSum

To current product hoga:
  currSum * (totalSum - currSum)

Har node par maximum product update karte rahenge.

Traversal complete hone ke baad,
final answer ka modulo return kar denge.

Time Complexity: O(n)
Space Complexity: O(h)
(h = height of tree / recursion stack)
*/

class Solution {
    long Totalsum=0;
    long mod=1000000007;
    long ans=0;
    public int maxProduct(TreeNode root) {
        
        sum(root);
        subtree(root);
        return (int)(ans % mod);
    }
    void sum(TreeNode root){
        if(root==null)return;
        
        Totalsum+=root.val;
        sum(root.left);
        sum(root.right);

        return;
    }

    long subtree(TreeNode root){
        if(root==null)return 0;

        long left=subtree(root.left);
        long right=subtree(root.right);

        long currsum=root.val+left+right;
        ans =Math.max(ans,currsum*(Totalsum-currsum));

        return currsum;
    }
}