/*
Problem: Find Largest Value in Each Tree Row (LeetCode 515)
Link: https://leetcode.com/problems/find-largest-value-in-each-tree-row/
Pattern: BFS

Approach:
Normal level order traversal karenge using queue.

Har level ke liye:
- Ek max variable maintain karenge
  jo current level ka maximum value store karega.

Starting me har naye level par:
- max = Integer.MIN_VALUE kar denge.

Ab current level ke size tak for loop chalayenge.

Loop ke andar:
- Queue se node nikalo.
- max ko update karte raho:
  max = Math.max(max, node.val)

- Agar left child present hai to queue me add karo.
- Agar right child present hai to queue me add karo.

Level complete hone se just pehle:
- max ko answer list me add kar denge.

Saare levels traverse hone ke baad
final answer list return kar denge.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public List<Integer> largestValues(TreeNode root) {
        if(root==null)return new ArrayList<>();

        List<Integer> ans= new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int length=q.size();
            int max=Integer.MIN_VALUE;

            for(int i=0;i<length;i++){
                TreeNode curr=q.poll();

                max=Math.max(max,curr.val);

                if(curr.left!=null)q.offer(curr.left);
                if(curr.right!=null)q.offer(curr.right);
            }

            ans.add(max);
        }
        return ans;
    }
}