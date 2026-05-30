/*
Problem: Maximum Width of Binary Tree (LeetCode 662)
Link: https://leetcode.com/problems/maximum-width-of-binary-tree/
Pattern: BFS Traversal

Note:
Agar kisi node ka index i hai,
to uska:
- left child index = 2 * i
- right child index = 2 * i + 1

(Level order indexing concept)

Approach:
Ek Pair class bana lenge
jisme node aur uska index store hoga.

Ab normal BFS level order traversal karenge using queue.

Har level ke start par:
- firstIndex = q.peek().index
- endIndex = firstIndex

Ab for loop chalayenge current level ke size tak.

Loop ke andar:
- Queue se pair nikalo.
- Current index lo.
- endIndex ko current index se update karte raho.

- Agar left child present hai,
  to usse queue me add kar do with index = 2 * index

- Agar right child present hai,
  to usse queue me add kar do with index = 2 * index + 1

Har level traversal ke baad:
- Current width calculate karenge:
  endIndex - firstIndex + 1

Aur max answer update karte rahenge.

At last final maximum width return kar denge.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {

    class pair{
        TreeNode node;
        long index;

        pair(TreeNode node,long index){
            this.node=node;
            this.index=index;
        }
    }

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null)return 0;

        Queue<pair> q= new LinkedList<>();
        q.add(new pair(root,1));
        int ans=0;

        while(!q.isEmpty()){

            int length=q.size();
            long start=q.peek().index;
            long end=start;

            for(int i=0;i<length;i++){
                pair p=q.poll();
                TreeNode temp=p.node;
                long index=p.index;

                end=index;
                
                if(temp.left !=null)q.offer(new pair(temp.left,2*index));
                if(temp.right !=null)q.offer(new pair(temp.right,2*index +1));

            }
            ans=Math.max(ans,(int)(end-start+1));
        }
        return ans;
    }
}