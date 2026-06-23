/*
Problem: Number of Islands (LeetCode 200)
Link: https://leetcode.com/problems/number-of-islands/
Pattern: DFS + Connected Components

Approach:
Grid ko hi visited array ki tarah use karenge.

Yahan:

- '1' represent karta hai unvisited land.
- '0' represent karta hai water ya already visited land.

Ab poori grid traverse karenge
using two nested loops:

- i for rows
- j for columns

Har cell par check karenge:

- Agar grid[i][j] == '1'

to iska matlab hume ek naya island mila hai.

Isliye:

- ans++

kar denge.

Aur us island ke saare connected cells visit karne ke liye:

dfs(i, j, grid)

call kar denge.

DFS Function:

Sabse pehle base condition check karenge.

Agar:

- i < 0
- j < 0
- i >= grid.length
- j >= grid[i].length

matlab hum grid ke bahar chale gaye hain.

Ya:

- grid[i][j] == '0'

matlab current cell water hai
ya pehle hi visit ho chuka hai.

In sab cases me:

return

kar denge.

Otherwise:

Current land cell ko visited mark kar denge:

grid[i][j] = '0'

Aisa isliye karte hain
taaki future me dobara isi cell par DFS na chale.

Ab current cell ke saare connected neighbours explore karenge
using 4-directional DFS:

dfs(i + 1, j, grid);   // down

dfs(i - 1, j, grid);   // up

dfs(i, j + 1, grid);   // right

dfs(i, j - 1, grid);   // left

Is tarah DFS poore island ke saare connected land cells ko
visit kar lega.

Main function me jab traversal continue hoga,
to same island ke cells already '0' ban chuke honge,
isliye unhe dobara count nahi kiya jayega.

Har baar jab kisi naye '1' se DFS start hota hai,
ek naya island milta hai.

At last ans return kar denge.

Time Complexity: O(m × n)

Space Complexity: O(m × n)
(recursion stack in worst case)
*/

class Solution {
    public int numIslands(char[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int ans=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]=='1'){
                    ans++;
                    dfs(i,j,grid);
                }
            }
        }
        return ans;
    }

    void dfs(int i,int j,char[][] grid){

        if(i<0 || j<0 ||i>=grid.length || j>=grid[i].length || grid[i][j]=='0')return;

        grid[i][j]='0';

        dfs(i+1,j,grid);
        dfs(i-1,j,grid);
        dfs(i,j+1,grid);
        dfs(i,j-1,grid);
    }
}