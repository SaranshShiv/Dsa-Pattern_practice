/*
Problem: Find if Path Exists in Graph (LeetCode 1971)
Link: https://leetcode.com/problems/find-if-path-exists-in-graph/
Pattern: BFS Traversal + Adjacency List

Approach:
Sabse pehle check karenge:

- Agar source == destination

to directly true return kar denge,
kyunki hum already destination par hi hain.

Otherwise,
graph ki adjacency list build karenge.

Adjacency list banane ke liye:

- Pehle n size ki adjacency list bana lenge.

For every node:

adjList.add(new ArrayList<>())

Ab edges array traverse karenge.

Har edge ke liye:

u = edge[0]
v = edge[1]

Kyunki graph undirected hai,

- adjList.get(u).add(v)
- adjList.get(v).add(u)

dono karenge.

Ab BFS traversal perform karenge.

Iske liye:

- Ek visited boolean array lenge.
- Ek queue lenge.

Source node ko queue me add kar denge.

Saath hi usse visited bhi mark kar denge
taaki future me dobara queue me na aaye.

Ab while loop chalayenge:

while(!queue.isEmpty())

Har iteration me:

- Current node ko poll karenge.

Ab current node ke saare neighbours traverse karenge
using adjacency list.

Har neighbour ke liye:

- Agar neighbour already visited nahi hai,

to:

- Queue me add kar denge.
- Visited mark kar denge.

Aisa isliye karte hain
taaki same node multiple baar process na ho.

Saath hi check karenge:

- Agar neighbour == destination

to path mil gaya hai,

isliye true return kar denge.

Agar BFS complete ho jaye
aur destination kahin bhi na mile,

to source se destination tak
koi path exist nahi karta.

At last false return kar denge.

Time Complexity: O(V + E)

Space Complexity: O(V + E)
*/

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source==destination)return true;
        
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<n;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adjlist.get(u).add(v);
            adjlist.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> q= new LinkedList<>();
        q.offer(source);
        visited[source]=true;

        while(!q.isEmpty()){
            int node=q.poll();

            for(int neighbour:adjlist.get(node)){
                if(!visited[neighbour]){
                    visited[neighbour]=true;
                    q.add(neighbour);

                    if(neighbour==destination)return true;
                }
            }
        }
        return false;
    }
}