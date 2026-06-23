/*
Problem: Number of Provinces (LeetCode 547)
Link: https://leetcode.com/problems/number-of-provinces/
Pattern: DFS Traversal + Connected Components

Approach:
Ek visited boolean array lenge
jo track karega ki kaunsi city already visit ho chuki hai.

Saath hi ek ans variable lenge
jo total provinces count karega.

Ab saari cities par traverse karenge.

Har city i ke liye:

- Agar city pehle se visited nahi hai,

to iska matlab hume ek naya connected component mila hai.

Isliye:

- ans++

kar denge.

Aur city i se DFS traversal start kar denge.

DFS Function:

DFS me pass karenge:

- current city i
- visited array
- isConnected matrix

Sabse pehle current city ko visited mark kar denge:

visited[i] = true

Ab current city ki poori row traverse karenge:

for(int j = 0; j < isConnected.length; j++)

Yahan:

isConnected[i][j] == 1

matlab city i aur city j directly connected hain.

Ab check karenge:

- Agar isConnected[i][j] == 1
- Aur city j abhi tak visited nahi hai

to city j par DFS call kar denge.

Is tarah DFS current city ke connected component ki
saari cities visit kar lega.

Main function me jab traversal continue hoga,

to jo cities already kisi province ka part hongi
wo visited milengi
aur unke liye naya DFS nahi chalega.

Har baar jab kisi unvisited city se DFS start hota hai,
ek naya province milta hai.

At last ans return kar denge.

Time Complexity: O(n²)

Space Complexity: O(n)
(recursion stack + visited array)
*/

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        boolean[] visited = new boolean[n];

        int ans=0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                dfs(i,visited,isConnected);
            }
        }
        return ans;
    }

    void dfs(int i,boolean[] visited, int[][] isConnected){
        visited[i]=true;

        for(int j=0;j<isConnected[i].length;j++){
            if(isConnected[i][j]==1 && !visited[j]){
                dfs(j,visited,isConnected);
            }
        }
        return;
    }
}