/*
Problem: Map of Highest Peak (LeetCode 1765)
Link: https://leetcode.com/problems/map-of-highest-peak/
Pattern: Multi Source BFS

Approach:
Question me diya hai ki kisi bhi cell ki height
apne neighbouring cells se at most 1 zyada ho sakti hai.

Saath hi:

- Water cells ki height fixed hai = 0

Iska matlab:

Har land cell ki height ultimately
uske nearest water cell par depend karegi.

Yeh exactly Multi Source BFS wali situation ban jaati hai.

Hum saare water cells se ek saath BFS start karenge.

Sabse pehle poori isWater matrix traverse karenge.

Agar:

- isWater[i][j] == 1

matlab water cell hai.

To uske coordinates queue me add kar denge:

q.offer(new int[]{i, j})

Aur uski height 0 hi rehne denge.

Agar:

- isWater[i][j] == 0

matlab land cell hai.

To usse:

isWater[i][j] = -1

kar denge.

Yahan -1 ka matlab hai
ki yeh cell abhi tak visit nahi hua hai.

Ab ek directions array bana lenge
jo 4 directions represent karega:

- up
- down
- left
- right

Ab BFS traversal start karenge:

while(!q.isEmpty())

Har iteration me:

- Queue ka front element poll karenge.

int[] temp = q.poll()

Current coordinates:

x = temp[0]
y = temp[1]

Ab current cell ke saare neighbours check karenge
using directions array.

Har direction ke liye:

i = x + direct[0]
j = y + direct[1]

Ab check karenge:

- i >= 0
- j >= 0
- i < n
- j < m
- isWater[i][j] == -1

Yahan -1 ka matlab hai
ki neighbour abhi tak visit nahi hua hai.

Agar saari conditions satisfy ho jaayein,

to:

- Neighbour ko queue me add kar denge.

q.offer(new int[]{i, j})

Aur uski height assign kar denge:

isWater[i][j] = isWater[x][y] + 1

Aisa isliye karte hain
kyunki BFS me current cell tak minimum distance already known hoti hai.

To uska neighbour
current cell se exactly 1 height zyada hoga.

Is tarah BFS level by level chalega
aur har land cell ko nearest water cell ke according
maximum valid height mil jayegi.

Traversal complete hone ke baad,

isWater matrix hi required height matrix ban chuki hogi.

At last isWater return kar denge.

Time Complexity: O(m × n)

Space Complexity: O(m × n)
(queue in worst case)
*/

class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n= isWater.length;
        int m= isWater[0].length;

        Queue<int[]> q= new LinkedList<>();

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(isWater[i][j]==1){
                    q.offer(new int[]{i,j});
                    isWater[i][j]=0;
                }
                else{  // cell is 0
                    isWater[i][j]=-1;
                }
            }
        }

        int[][] direction = {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while(!q.isEmpty()){

            int[] temp= q.poll();
            int x=temp[0];
            int y= temp[1];

            for(int[] direct: direction){

                int i= x+direct[0];
                int j=y+ direct[1];

                if(i>=0 && j>=0 && i<n && j<m && isWater[i][j] == -1){

                    q.offer(new int[]{i,j});
                    isWater[i][j]= isWater[x][y] +1;
                }
            }
        }
        return isWater;
    }
}
