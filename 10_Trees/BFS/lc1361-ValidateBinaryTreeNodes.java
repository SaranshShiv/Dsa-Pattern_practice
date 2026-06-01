/*
Problem: Validate Binary Tree Nodes (LeetCode 1361)
Link: https://leetcode.com/problems/validate-binary-tree-nodes/
Pattern: HashSet + BFS

Approach:
Sabse pehle hume tree ka root find karna hoga.

Observation:
Root kabhi bhi leftChild ya rightChild array me present nahi hoga
kyunki uska koi parent nahi hota.

Isliye:
Ek child HashSet bana lenge
aur leftChild aur rightChild arrays ke saare valid elements
(-1 ko skip karenge)
usme add kar denge.

Ab root = -1 initialize karenge
aur 0 se n-1 tak iterate karenge.

- Agar koi node child set me present nahi hai,
  matlab woh possible root hai.

- Ab check karenge:
  Agar root pehle se assign ho chuka hai,
  to multiple roots exist karte hain,
  directly false return kar denge.

- Warna root = i kar denge.

Iteration ke baad:
- Agar root abhi bhi -1 hai,
  matlab koi valid root hi nahi mila,
  to false return kar denge.

Ab BFS traversal start karenge root se.

Ek visited HashSet maintain karenge
taaki same node dobara visit na ho.

Traversal ke time:
- Agar koi node already visited hai
  aur firse mil raha hai,
  matlab us node ke multiple parents hain
  ya cycle present hai,
  to false return kar denge.

- Warna node ko visited me add kar denge
  aur uske children queue me push kar denge.

At last:
- Check karenge kya visited set ka size == n hai.

Yeh verify karta hai ki:
- saare nodes connected hain
- koi disconnected graph/component present nahi hai.

Agar sab valid raha to true return kar denge.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        HashSet<Integer> visited= new HashSet<>();

        for(int i=0;i<n;i++){
            if(leftChild[i]!=-1)visited.add(leftChild[i]);
            if(rightChild[i]!=-1)visited.add(rightChild[i]);
        }

        //finding root
        int root=-1;
        for(int i=0;i<n;i++){
            if(!visited.contains(i)){
                if(root!=-1)return false;
                root=i;
            }
        }
        if(root==-1)return false;
        visited.clear();

        Queue<Integer> q= new LinkedList<>();
        q.add(root);
        visited.add(root);

        while(!q.isEmpty()){
            int node=q.poll();
            
            int x=leftChild[node];
            if(x!=-1){
                if(visited.contains(x))return false;

                q.offer(x);
                visited.add(x);
            }

            int y=rightChild[node];
            if(y!=-1){
                if(visited.contains(y))return false;

                q.offer(y);
                visited.add(y);
            }
        }
        if(visited.size()!= n)return false;
        return true;
    }
}