/*
Problem: Topological Sort (GFG)
Link: https://www.geeksforgeeks.org/problems/topological-sort/1
Pattern: Topological Sort + DFS Traversal

Approach:
Topological sort me hume nodes ko aise order me rakhna hota hai
ki har directed edge:

u -> v

ke liye,

u hamesha v se pehle aaye.

Iske liye DFS based approach use karenge.

Sabse pehle graph ki adjacency list bana lenge.

Saath hi:

- visited boolean array lenge
- ans ArrayList lenge

Ab saare nodes traverse karenge.

for(int i = 0; i < V; i++)

Agar:

!visited[i]

to us node se DFS start karenge.

Yeh loop isliye zaroori hai
kyunki graph me disconnected components ho sakte hain.

DFS Function:

Sabse pehle check karenge:

Agar node already visited hai,

to return kar denge.

Otherwise:

Current node ko visited mark kar denge.

visited[node] = true

Ab current node ke saare neighbours traverse karenge.

Har neighbour ke liye:

Agar neighbour visited nahi hai,

to DFS call kar denge.

dfs(neighbour)

Important Observation:

Current node ko answer me tab add karenge
jab uske saare neighbours process ho chuke hon.

Matlab:

ans.add(node)

DFS ke bilkul end me karenge.

Yeh postorder DFS traversal hai.

Aisa karne se:

Har node answer me
apne saare neighbours ke baad add hota hai.

Lekin topological order me
hume node ko neighbours se pehle rakhna hota hai.

Isliye DFS complete hone ke baad,

ans ko reverse kar denge.

Reverse karne par:

Har node apne outgoing neighbours se pehle aa jayega,
aur valid topological ordering mil jayegi.

At last:

reverse(ans)

Aur answer return kar denge.

Time Complexity: O(V + E)

Space Complexity: O(V)
(visited array + recursion stack + answer list)
*/

class Solution {
    boolean[] visited;
    
    public ArrayList<Integer> topoSort(int V, int[][] edges) {
        // code here
        
        ArrayList<Integer> ans= new ArrayList<>();
        visited= new boolean[V];
        List<List<Integer>> adjlist= new ArrayList<>();
        
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList());
        }
        
        for(int i=0;i<edges.length;i++){
            adjlist.get(edges[i][0]).add(edges[i][1]);
        }
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,adjlist,ans);
            }
        }
        
        Collections.reverse(ans);
        
        return ans;
    }
    
    void dfs(int node,List<List<Integer>> adjlist,List<Integer> ans){
        
        if(visited[node]){
            return;
        }
        visited[node]=true;
        
        for(int neighbour: adjlist.get(node)){
            
            if(!visited[neighbour]){
                dfs(neighbour,adjlist,ans);
            }
        }
        
        ans.add(node);
    }
}