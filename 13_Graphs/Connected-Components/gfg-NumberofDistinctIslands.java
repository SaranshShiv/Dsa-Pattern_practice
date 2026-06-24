/*
Problem: Number of Distinct Islands (GFG)
Link: https://www.geeksforgeeks.org/problems/number-of-distinct-islands/1
Pattern: Connected components DFS Traversal + HashSet

Approach:
Hume distinct islands count karne hain.

Yahan:

Do islands same tab maane jayenge
jab unka shape same ho.

Position matter nahi karti,
sirf relative structure matter karta hai.

Isliye hume har island ka ek unique representation store karna hoga.

Sabse pehle poori grid traverse karenge.

Jab bhi kisi cell par land mile:

grid[i][j] == 1

to us island par DFS chala denge.

DFS call me pass karenge:

dfs(grid, i, j, baseRow, baseCol, shape)

Yahan:

- baseRow = i
- baseCol = j

matlab island ka starting point.

Saath hi ek List<String> lenge
jo island ka encoded shape store karegi.

DFS Function:

Sabse pehle normal boundary conditions check karenge.

Agar:

- i < 0
- j < 0
- i >= n
- j >= m

Ya:

- grid[i][j] != 1

to return kar denge.

Agar valid land cell mila,

to usse visited mark kar denge:

grid[i][j] = 0

(ya kisi aur marker se mark kar sakte hain)

Ab current cell ka relative position store karenge:

shape.add((i - baseRow) + "," + (j - baseCol))

Aisa isliye karte hain
kyunki hume actual coordinates nahi,
relative coordinates chahiye.

Base row aur base column
island ke starting point ko represent karte hain.

Jab DFS island me left, right, up ya down move karega,
to relative coordinates change honge
aur island ka unique shape generate ho jayega.

Ab DFS ko 4 directions me chalayenge:

dfs(i + 1, j, ...);   // down

dfs(i - 1, j, ...);   // up

dfs(i, j + 1, ...);   // right

dfs(i, j - 1, ...);   // left

DFS complete hone ke baad
poore island ka shape List<String> me store ho chuka hoga.

Ab is shape ko HashSet me add kar denge.

Agar same shape pehle se set me present hoga,
to set usse dobara store nahi karega.

Aur agar naya shape hoga,
to set me add ho jayega.

Kyuki HashSet sirf distinct values store karta hai,

isliye:

set.size()

actually distinct islands ki count represent karega.

At last:

return set.size();

Time Complexity: O(n × m)

Space Complexity: O(n × m)
(HashSet + recursion stack + shape storage)
*/

class Solution {
    public int countDistinctIslands(char[][] grid) {
        // code here
        int n=grid.length;
        int m=grid[0].length;
        int distinct=0;
        
        HashSet<List<String>> set= new HashSet<>();
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                
                if(grid[i][j] == 'L'){
                    List<String> a= dfs(grid,i,j,i,j, new ArrayList<>());
                    
                    set.add(a);
                }
            }
        }
        
        return set.size();
    }
    
    List<String> dfs(char[][] grid , int i, int j ,int baserow,int basecol,List<String> list){
        
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j] !='L'){
            return list;
        }
        
        grid[i][j]='M'; // m denotes marked;
        
        list.add((i-baserow) +"," + (j-basecol));
        
        dfs(grid,i-1,j,baserow,basecol,list);
        dfs(grid,i+1,j,baserow,basecol,list);
        dfs(grid,i,j-1,baserow,basecol,list);
        dfs(grid,i,j+1,baserow,basecol,list);
        
        return list;
    }
}