/*
Problem: Detect Cycle in a Directed Graph (GFG)
Link: https://www.geeksforgeeks.org/problems/detect-cycle-in-a-directed-graph/1
Pattern: Graph DFS Traversal

Approach:
Hume detect karna hai
ki directed graph me cycle exist karti hai ya nahi.

Observation:

Agar DFS traversal ke dauran
hum kisi aise node par pahunch jayein
jo already current DFS path me present ho,

to cycle exist karti hai.

Isliye hume current DFS path track karna padega.

Iske liye:

- visited[] array lenge
- recStack[] array lenge

visited[]:
- Overall visited nodes track karega.

recStack[]:
- Sirf current DFS path ke nodes track karega.

Dono arrays zaroori hain.

Agar sirf recStack use karein,
to same nodes ko baar baar visit kar sakte hain.

Aur agar sirf visited use karein,
to current DFS path track nahi kar paayenge.

Sabse pehle graph ki adjacency list bana lenge.

Har edge ke liye:

adjList.get(u).add(v)

Kyunki graph directed hai,
sirf ek direction me edge add karenge.

Ab saare vertices traverse karenge.

for(int i = 0; i < V; i++)

Agar:

!visited[i]

to us node se DFS start karenge.

Agar DFS kisi bhi point par true return kar de,

to cycle mil gayi hai.

Directly:

return true

kar denge.

Yeh loop isliye zaroori hai
kyunki graph me connected components ho sakte hain.

Agar saare vertices process ho gaye
aur kahin bhi cycle nahi mili,

to:

return false

kar denge.

DFS Function:

Sabse pehle check karenge:

Agar:

recStack[node] == true

to matlab current node already
current DFS path me present hai.

Yeh cycle ko indicate karta hai.

Isliye:

return true

kar denge.

Ab check karenge:

Agar:

visited[node] == true

to matlab yeh node pehle hi process ho chuka hai
aur current DFS path ka part nahi hai.

To cycle nahi bani.

Isliye:

return false

kar denge.

Ab current node ko:

visited[node] = true

Aur:

recStack[node] = true

mark kar denge.

Ab current node ke saare neighbours traverse karenge.

Har neighbour ke liye:

Agar:

dfs(neighbour)

true return kare,

to cycle mil gayi.

Isliye:

return true

kar denge.

Saare neighbours process hone ke baad,

current node DFS path ka part nahi rahega.

Isliye:

recStack[node] = false

kar denge.

Matlab backtracking ke time
isse current DFS path se remove kar diya.

Agar kisi bhi neighbour se cycle nahi mili,

to:

return false

kar denge.

Time Complexity: O(V + E)

Space Complexity: O(V)
(visited array + recStack array + recursion stack)
*/

class Solution {
    List<List<Integer>> adjacencylist;
    boolean[] visited;
    
    public boolean isCyclic(int V, int[][] edges) {
        // code here
        adjacencylist = new ArrayList<>();
        
        visited= new boolean[V];
        boolean[] recstack= new boolean[V];
        for(int i=0;i<V;i++){
            adjacencylist.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adjacencylist.get(edges[i][0]).add(edges[i][1]);
        }
        
        
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(dfs(i,recstack)){
                    return true;
                }
            }
        }
        
        return false;
        
    }
    
    boolean dfs(int node, boolean[] recstack){
        
        if(recstack[node]){
            return true;
        }
        if(visited[node]){
            return false;
        }
        
        visited[node]=true;
        recstack[node]= true;
        
        
        for(int neighbour: adjacencylist.get(node)){
            
            if(dfs(neighbour,recstack)){
                return true;
            }
        }
        
        recstack[node]=false;
        
        return false;
    }
}