/*
Problem: Shortest Path in Undirected Graph Having Unit Distance (GFG)
Link: https://www.geeksforgeeks.org/problems/shortest-path-in-undirected-graph-having-unit-distance/1
Pattern: Graph BFS Traversal

Approach:
Hume source node se
har node ki shortest distance find karni hai.

Graph unit weighted hai,

matlab har edge ka weight 1 hai.

Observation:

Unit weighted graph me
BFS hamesha shortest path deta hai,

kyunki BFS level by level traverse karta hai.

Sabse pehle graph ki adjacency list bana lenge
using given edges.

Kyunki graph undirected hai,

Har edge:

u - v

ke liye:

adj.get(u).add(v)

adj.get(v).add(u)

dono karenge.

Ab ek distance array lenge
size V ka.

Initially:

Saari values ko:

-1

mark kar denge.

Yeh denote karega
ki node abhi tak source se reachable nahi hai.

Ab ek queue lenge.

Source node ko queue me add kar denge.

Saath hi:

distance[source] = 0

kar denge.

Aisa isliye
kyunki source apne aap se
0 distance par hota hai.

Ab BFS traversal start karenge.

while(!q.isEmpty())

Queue se current node poll karenge.

Ab current node ke saare neighbours traverse karenge.

Har neighbour ke liye,

check karenge:

Agar:

distance[neighbour] == -1

ya

distance[neighbour] > distance[node] + 1

to current path chhota hai.

Isliye:

distance[neighbour] = distance[node] + 1

kar denge.

Aur neighbour ko queue me add kar denge.

Yahan:

distance[node] + 1

isliye karte hain
kyunki graph unit weighted hai,
to har edge exactly 1 distance contribute karti hai.

BFS complete hone ke baad,

jo nodes source se reachable nahi honge,
unki distance abhi bhi -1 rahegi.

At last:

distance array return kar denge.

Time Complexity: O(V + E)

Space Complexity: O(V + E)
(adjacency list + queue + distance array)
*/

class Solution {
    public int[] shortestPath(int V, int[][] edges, int src) {
        // code here
        int[] distance= new int[V];
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i=0;i<V;i++){
            adjlist.add(new ArrayList<>());
        }
        
        for(int i=0;i<edges.length;i++){
            adjlist.get(edges[i][0]).add(edges[i][1]);
            adjlist.get(edges[i][1]).add(edges[i][0]);
        }
        
        Arrays.fill(distance,-1);
        distance[src]=0;
        
        Queue<Integer> q= new LinkedList<>();
        q.offer(src);
        
        while(!q.isEmpty()){
            
            int x=q.poll();
            
            for(int neighbour : adjlist.get(x)){
                
                if(distance[neighbour]==-1 || distance[neighbour] > distance[x]+1){
                    
                    distance[neighbour]=distance[x]+1;
                    q.offer(neighbour);
                }
            }
        }
        return distance;
    }
}