/*
Problem: Find Eventual Safe States (LeetCode 802)
Link: https://leetcode.com/problems/find-eventual-safe-states/
Pattern: Graph Cycle Detection + DFS Traversal

Approach:
Hume un nodes ko find karna hai
jinse start karne par kabhi bhi cycle me na pahunch sake.

Isliye hume detect karna hoga
ki kaunse nodes safe hain
aur kaunse nodes cycle ka part hain
ya cycle tak pahunch sakte hain.

Iske liye ek visited integer array lenge.

Yahan:

- 0 = unvisited
- 1 = currently visiting / unsafe
- 2 = safe

Ab saare nodes traverse karenge.

for(int i = 0; i < n; i++)

Agar:

visited[i] == 0

to us node par DFS chalayenge.

DFS ke baad:

- Agar cycle detect nahi hui,

  to yeh safe node hai.

- Agar visited[i] == 2

  to bhi yeh safe node hai.

In dono cases me:

ans.add(i)

kar denge.

At last:

ans return kar denge.

DFS Function:

Sabse pehle check karenge:

Agar:

visited[node] == 1

to matlab yeh node current recursion path me hai
ya pehle hi unsafe declare ho chuka hai.

Iska matlab cycle detect ho gayi.

Isliye:

return true

kar denge.

Ab check karenge:

Agar:

visited[node] == 2

to yeh node pehle hi safe prove ho chuka hai.

Isliye:

return false

kar denge.

Ab current node ko:

visited[node] = 1

mark kar denge.

Yeh denote karta hai
ki node currently process ho raha hai.

Ab current node ke saare neighbours traverse karenge.

Har neighbour ke liye:

Agar:

dfs(neighbour)

true return kare,

to matlab neighbour cycle tak pahunch raha hai.

To current node bhi unsafe hoga.

Isliye:

return true

kar denge.

Agar saare neighbours process ho gaye
aur kahin bhi cycle nahi mili,

to current node safe hai.

Isliye:

visited[node] = 2

mark kar denge.

Yeh denote karta hai
ki is node se kisi cycle tak nahi pahunch sakte.

Aur:

return false

kar denge.

Time Complexity: O(V + E)

Space Complexity: O(V)
(visited array + recursion stack)
*/

class Solution {
    int[] visited;

    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        int n=graph.length;
        visited= new int[n];//0 represents unvisited - 1-currently being processed in stack ,2means visited,safe

        List<Integer> ans= new ArrayList<>();

        for(int i=0;i<n;i++){
            if(visited[i] ==0){
                
                if(!dfscycledetection(i,graph)){
                    ans.add(i);
                }
            }
            else if(visited[i]==2){
                ans.add(i);
            }
        }

        return ans;
    }

    boolean dfscycledetection(int node,int[][] graph){

        if(visited[node]==1){
            return true; //currently being processed , cycle detected;
        }

        if(visited[node]== 2){
            return false;
        }
        visited[node]=1;

        for(int neighbour : graph[node]){

            if(dfscycledetection(neighbour,graph)){
                return true;
            }
        }

        visited[node]=2;

        return false;
    }
}