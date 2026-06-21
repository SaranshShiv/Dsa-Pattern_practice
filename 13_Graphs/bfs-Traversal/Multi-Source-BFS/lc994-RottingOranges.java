/*
Problem: Rotting Oranges (LeetCode 994)
Link: https://leetcode.com/problems/rotting-oranges/
Pattern: BFS Traversal

Approach:
Ek queue of int[] lenge
jo rotten oranges ke coordinates store karegi.

Queue me:

- 0th index = row
- 1st index = column

Ab poori grid traverse karenge
using two nested loops.

Agar kisi cell par:

- grid[i][j] == 2

milta hai,

to us rotten orange ko queue me add kar denge:

q.offer(new int[]{i, j})

Aur agar:

- grid[i][j] == 1

milta hai,

to fresh oranges count karne ke liye:

fresh++

kar denge.

Ab ek important check karenge:

- Agar fresh == 0

to koi fresh orange hai hi nahi,

isliye directly 0 return kar denge.

Ab ek direction matrix bana lenge
jo 4 directions represent karega:

- up
- down
- left
- right

coordinates ke form me.

Ab BFS traversal start karenge:

while(!q.isEmpty() && fresh > 0)

Yahan fresh > 0 bhi check karte hain
kyunki saare oranges rotten hote hi process stop kar sakte hain.

Har BFS level ek minute represent karega.

Isliye:

- size = q.size()

nikaalenge.

Ab current level ke saare rotten oranges process karenge:

for(int k = 0; k < size; k++)

Queue se current coordinates nikaalenge:

int[] temp = q.poll()

Aur:

i = temp[0]
j = temp[1]

Ab 4 directions par traverse karenge.

Har direction ke liye:

x = i + d[0]
y = j + d[1]

Ab check karenge:

- x >= 0
- y >= 0
- x < m
- y < n
- grid[x][y] == 1

Agar saari conditions satisfy hoti hain,

to matlab ek fresh orange rotten ho sakta hai.

Isliye:

- grid[x][y] = 2
- q.offer(new int[]{x, y})
- fresh--

kar denge.

Current level ke saare nodes process hone ke baad,

ans++

kar denge,

kyunki ek minute pass ho gaya.

BFS complete hone ke baad:

- Agar fresh == 0

to saare oranges successfully rotten ho gaye hain,

isliye ans return kar denge.

Otherwise:

kuch fresh oranges tak kabhi pahunch hi nahi paaye,

isliye -1 return kar denge.

Time Complexity: O(m × n)

Space Complexity: O(m × n)
(queue in worst case)
*/

class Solution {
    public int orangesRotting(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        Queue<int[]> q= new LinkedList<>();
        int fresh=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }

        int ans=0;
        if(fresh==0)return 0;

        int[][] direction = { {1,0},{-1,0},{0,1},{0,-1} };

        while(!q.isEmpty() && fresh>0){
            int size= q.size();

            for(int k=0;k<size;k++){
                
                int[] temp=q.poll();
                int i=temp[0];
                int j=temp[1];

                for(int[] d: direction){
                    int x= i+d[0];
                    int y= j+d[1];

                    if(x>=0 && y>=0 && x<m && y<n && grid[x][y]==1){
                        grid[x][y]=2;
                        q.offer(new int[]{x,y});
                        fresh--;
                    }
                }
            }

            ans++;
        }
        
        return fresh==0?ans:-1;
    }
}