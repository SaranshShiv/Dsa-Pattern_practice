/*
Problem: All Nodes Distance K in Binary Tree (LeetCode 863)
Link: https://leetcode.com/problems/all-nodes-distance-k-in-binary-tree/
Pattern: Mapping + DFS + BFS Traversal

Approach:
Target ke neeche wale nodes check karna easy hai,
but ancestors side check nahi kar sakte directly,
isliye pehle parent mapping banani padegi.

DFS traversal ki help se:
- Har child node ko uske parent se map kar denge.

Matlab:
- Agar left child null nahi hai:
  map.put(root.left, root)

- Agar right child null nahi hai:
  map.put(root.right, root)

Isse har node se uske parent tak bhi ja sakte hain.

Mapping complete hone ke baad:
Ab BFS level order traversal target node se start karenge.

Ek visited set/array maintain karenge
taaki same node dobara queue me add na ho
(warna parent-child cycle ban jayegi).

BFS me:
- Left child
- Right child
- Parent node

teeno directions me move karenge.

Yeh process sirf k levels tak chalayenge.
Jaise hi current distance k ho jayega,
BFS stop kar denge.

Ab queue me jitne nodes bache honge,
woh sab distance k par honge.

Un sabki values answer list me add karke return kar denge.

Time Complexity: O(n)
Space Complexity: O(n)
(mapping + queue + visited)
*/

class Solution {
    HashMap<TreeNode,TreeNode> map= new HashMap<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer> ans= new ArrayList<>();
        makegraph(root);

        Queue<TreeNode> q= new LinkedList<>();
        int[] visited = new int[501];

        q.add(target);
        visited[target.val]++;
        int level=0;

        while(!q.isEmpty()){

            if(level==k)break;

            int size=q.size();
            for(int i=0;i<size;i++){
                TreeNode curr= q.poll();

                //add left child
                if(curr.left!=null && visited[curr.left.val]==0){
                    q.add(curr.left);
                    visited[curr.left.val]++;
                }

                //adding right child
                if(curr.right!=null && visited[curr.right.val]==0){
                    q.add(curr.right);
                    visited[curr.right.val]++;
                }

                //adding parent node through map
                if(map.containsKey(curr) && visited[map.get(curr).val]==0){
                    q.add(map.get(curr));
                    visited[map.get(curr).val]++;
                }
            }
            level++;
        }

        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }

    void makegraph(TreeNode root){
        if(root==null)return;

        if(root.left!=null)map.put(root.left,root);
        if(root.right!=null)map.put(root.right,root);

        makegraph(root.left);
        makegraph(root.right);

        return;
    }
}