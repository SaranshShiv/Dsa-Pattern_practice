/*
Problem: Shortest Path in Binary Matrix (LeetCode 1091)
Link: https://leetcode.com/problems/shortest-path-in-binary-matrix/
Pattern: Graph + BFS Shortest Path

Approach:
Hume top-left cell se
bottom-right cell tak
shortest path find karna hai.

Observation:

Har move ka cost 1 hai,

aur hum 8 directions me move kar sakte hain.

Matlab graph unweighted hai.

Aur hume shortest path chahiye.

Isliye BFS Shortest Path Algorithm use karenge.

Sabse pehle
8 directions ka direction array bana lenge.

Isme include honge:

- up
- down
- left
- right
- top-left
- top-right
- bottom-left
- bottom-right

Ab ek important check karenge:

Agar:

grid[0][0] == 1

ya

grid[n - 1][n - 1] == 1

to starting ya destination cell blocked hai.

Isliye:

return -1

kar denge.

Ek aur edge case:

Agar:

n == 1

to sirf ek hi cell hai.

Aur upar already check kar chuke hain
ki woh blocked nahi hai.

Matlab hum already destination par hain.

Isliye:

return 1

kar denge.

Ab normal BFS Shortest Path start karenge.

Ek queue lenge
jo coordinates store karegi.

Queue me:

{0, 0}

add kar denge.

Saath hi:

grid[0][0] = 1

mark kar denge.

Yahan grid ko hi visited array ki tarah use kar rahe hain.

Ek:

level = 1

lenge.

Kyunki starting cell bhi
path length me count hota hai.

Ab BFS traversal start karenge.

while(!q.isEmpty())

Har BFS level
same path length represent karega.

Current level ke saare cells process karenge.

Queue se current coordinates poll karenge.

Ab current cell ke
8 neighbours traverse karenge
using direction array.

Har neighbour ke liye
boundary conditions check karenge.

Agar:

- i >= 0
- j >= 0
- i < n
- j < n
- grid[i][j] == 0

to yeh valid aur unvisited cell hai.

Ab check karenge:

Agar:

i == n - 1

Aur

j == n - 1

to destination mil gaya.

Directly:

return level + 1

kar denge.

Otherwise:

- Cell ko visited mark kar denge:

grid[i][j] = 1

- Aur queue me add kar denge.

Current level ke saare nodes process hone ke baad,

level++

kar denge.

Agar BFS complete ho jaye
aur destination tak na pahunch paaye,

to koi valid path exist nahi karta.

At last:

return -1;

Time Complexity: O(n²)

Space Complexity: O(n²)
(queue in worst case)
*/

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1 || grid[n-1][n-1]==1)return -1;
        if(n==1)return 1;

        int[][] direction={
            {1,0},
            {0,-1},
            {-1,0},
            {0,1},
            {-1,-1},
            {-1,1},
            {1,-1},
            {1,1}
        };

        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{0,0});
        int level=1;
        grid[0][0]=1;

        while(!q.isEmpty()){
            level++;
            int size=q.size();

            for(int k=0;k<size;k++){

                int[] temp=q.poll();
                int x=temp[0];
                int y=temp[1];

                for(int[] direct: direction){

                    int i=x+direct[0];
                    int j=y+direct[1];

                    if(i>=0 && j>=0 && i<n && j<n && grid[i][j]==0){
                        grid[i][j]=1;
                        q.offer(new int[]{i,j});

                        if(i==n-1 && j==n-1){
                            return level;
                        }
                    }
                }
            }
        }
        return -1;
    }
}