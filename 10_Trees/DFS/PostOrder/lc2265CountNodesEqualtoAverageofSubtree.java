/*
Problem: Count Nodes Equal to Average of Subtree (LeetCode 2265)
Link: https://leetcode.com/problems/count-nodes-equal-to-average-of-subtree/
Pattern: Postorder Traversal (Propagating Information Upwards)

Approach:
Hume har subtree se 2 information upwards propagate karni hain:
- sum of subtree
- count of nodes

Isliye ek function banayenge jo int[] return karega:
[sum, count]

Ab normal postorder DFS karenge:

- Pehle left subtree se info lo:
  int[] left = func(root.left)

- Fir right subtree se:
  int[] right = func(root.right)

Ab current subtree ka:
- sum calculate karenge:
  sum = root.val + left[0] + right[0]

- count calculate karenge:
  count = 1 + left[1] + right[1]

Ab average check karenge:
- Agar (sum / count) == root.val ho,
  to ans++ kar denge
  (ans global variable hoga).

At last current subtree ki info return kar denge:
new int[]{sum, count}

Original function me final ans return kar denge.

Time Complexity: O(n)
Space Complexity: O(h)
(h = height of tree / recursion stack)
*/

class Solution {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        SumAndCount(root);
        return ans;
    }
    
    int[] SumAndCount(TreeNode root){
        if(root==null)return new int[]{0,0};

        int[] left= SumAndCount(root.left);
        int[] right= SumAndCount(root.right);

        int sum=root.val+ left[0]+right[0];
        int count= 1+ left[1] + right[1];

        if(sum/count ==root.val)ans++;

        return new int[]{sum,count};
    }
}