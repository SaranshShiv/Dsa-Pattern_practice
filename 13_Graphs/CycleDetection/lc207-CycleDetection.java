/*
Problem: Course Schedule (LeetCode 207)
Link: https://leetcode.com/problems/course-schedule/
Pattern: Graph DFS Cycle Detection

Approach:
Question pooch raha hai
ki kya saare courses complete karna possible hai.

Har prerequisite relation:

u -> v

ka matlab hai
ki ek course complete karne se pehle
dusra course complete karna padega.

Agar graph me cycle present hai,

to kisi point par course khud par hi depend karne lagega,
aur saare courses complete karna impossible ho jayega.

Isliye problem ko cycle detection me convert kar sakte hain.

Sabse pehle prerequisites se
adjacency list bana lenge.

Saath hi ek integer visited array lenge.

Yahan:

- 0 = unvisited
- 1 = currently visiting / unsafe
- 2 = safe

Ab saare courses traverse karenge.

for(int i = 0; i < numCourses; i++)

Agar:

visited[i] == 0

to us node par DFS chalayenge.

Agar DFS true return kar de,

to cycle detect ho gayi.

Matlab valid ordering possible nahi hai.

Isliye:

return false

kar denge.

Agar saare nodes process ho gaye
aur kahin bhi cycle nahi mili,

to saare courses complete kiye ja sakte hain.

At last:

return true

kar denge.

DFS Function:

Sabse pehle check karenge:

Agar:

visited[node] == 1

to matlab current node
already current DFS path me present hai.

Yeh cycle ko indicate karta hai.

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

Agar dono conditions false hain,

to current node ko:

visited[node] = 1

mark kar denge.

Yeh denote karta hai
ki node currently process ho raha hai.

Ab current node ke saare neighbours traverse karenge.

Har neighbour ke liye:

Agar:

dfs(neighbour)

true return kare,

to cycle mil gayi.

Isliye:

return true

kar denge.

Agar saare neighbours process ho gaye
aur kahin bhi cycle nahi mili,

to current node safe hai.

Isliye:

visited[node] = 2

mark kar denge.

Aur:

return false

kar denge.

Time Complexity: O(V + E)

Space Complexity: O(V)
(visited array + recursion stack)
*/

class Solution {
    List<List<Integer>> adjlist;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        adjlist= new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adjlist.add(new ArrayList<>());
        }

        for(int i=0;i<prerequisites.length;i++){
            adjlist.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        int[] visited= new int[numCourses];

        for(int i=0;i<numCourses;i++){

            if(visited[i]==0){

                if(dfs(i,visited)){
                    return false;
                }
            }
        }
        return true;
    }

    boolean dfs(int node,int[] visited){

        if(visited[node]==1){
            return true; //cycle exist;
        }
        if(visited[node]==2){
            return false; //no cycle
        }
        visited[node]=1;

        for(int neighbour: adjlist.get(node)){

            if(dfs(neighbour,visited)){
                return true;
            }
        }
        visited[node]=2;

        return false;
    }
}