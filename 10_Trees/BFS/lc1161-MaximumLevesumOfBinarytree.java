/*
Problem: Maximum Level Sum of a Binary Tree (LeetCode 1161)
Link: https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
Pattern: Level Order Traversal

Approach:
Normal BFS level order traversal karenge using queue.

Ek level variable rakhenge
jo current level number track karega.

Har while traversal ke start par:
- localSum = 0 initialize kar denge
  (current level ka sum store karne ke liye).

Ab current level ke size tak for loop chalayenge.

Loop ke andar:
- Queue se node nikalo.
- Uski value localSum me add kar do.

- Agar left child present hai to queue me add karo.
- Agar right child present hai to queue me add karo.

Level traversal complete hone ke baad:
- Agar localSum > sum hai,
  to:
  sum = localSum
  ans = level

Phir level++ kar denge next level ke liye.

At last ans return kar denge.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int maxLevelSum(TreeNode root) {
        int sum=Integer.MIN_VALUE;

        Queue<TreeNode> q= new LinkedList<>();
        q.offer(root);
        int ans=1;
        int level=0;

        while(!q.isEmpty()){
            level++;
            int localsum=0;
            int length=q.size();

            for(int i=0;i<length;i++){
                TreeNode curr=q.poll();
                localsum+=curr.val;

                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
            }

            if(localsum>sum){
                sum=localsum;
                ans=level;
            }
        }
        return ans;
    }
}