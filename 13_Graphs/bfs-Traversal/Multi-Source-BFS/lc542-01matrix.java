/*
Problem: 01 Matrix (LeetCode 542)
Link: https://leetcode.com/problems/01-matrix/
Pattern: BFS

Approach:
Hume har 1 ke liye nearest 0 ki distance find karni hai.

Sabse pehla thought yeh aa sakta hai
ki har 1 se multi-source BFS chalayen.

Lekin problem yeh hai
ki BFS ke process me values change hoti rahengi,
aur input bhi modify ho jayega,
jisse baaki distances calculate karna difficult ho jayega.

To doosra thought aata hai:

Why not start BFS from all 0s?

Kyuki jab koi 1 first time queue me add hoga,
to jis level par add hoga
wahi uski nearest 0 se minimum distance hogi.

Isliye multi-source BFS from all 0s use karenge.

Sabse pehle poori matrix traverse karenge.

- Agar value 0 hai,

  to uske coordinates queue me add kar denge:

  q.offer(new int[]{i, j})

- Agar value 1 hai,

  to usse -1 kar denge.

Aisa isliye karte hain
taaki matrix ko hi visited array ki tarah use kar sakein.

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

- Current coordinates nikaalenge:

  x = temp[0]
  y = temp[1]

Ab current cell ke 4 neighbours check karenge:

for(int[] direct : directions)

Neighbour coordinates honge:

i = x + direct[0]
j = y + direct[1]

Ab check karenge:

- i >= 0
- j >= 0
- i < m
- j < n
- mat[i][j] == -1

Yahan -1 ka matlab hai
ki yeh cell abhi tak visit nahi hua hai.

Agar saari conditions satisfy ho jayein,

to:

- Neighbour ko queue me add kar denge.
- Aur uski distance update kar denge:

  mat[i][j] = mat[x][y] + 1

Yahan parent chahe 0 ho
ya pehle se calculated distance ho,

current cell usse exactly 1 distance door hoga.

Is tarah BFS level by level chalega
aur har 1 ko nearest 0 ki minimum distance mil jayegi.

Traversal complete hone ke baad,

updated matrix hi answer hogi.

At last mat return kar denge.

Time Complexity: O(m × n)

Space Complexity: O(m × n)
(queue in worst case)
*/

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        
        Queue<int[]> q= new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){

                if(mat[i][j]==0){
                    q.offer(new int[]{i,j});
                }
                else if(mat[i][j]==1){
                    mat[i][j]=-1;
                }
            }
        }

        int[][] direction= {
            {1,0},
            {-1,0},
            {0,1},
            {0,-1}
        };

        while(!q.isEmpty()){
            int size= q.size();
                
            int[] temp= q.poll();
            int x=temp[0];
            int y=temp[1];

            for(int[] direct :direction){

                int i=x+direct[0];
                int j= y+direct[1];

                if(i>=0 && j>=0 && i<m && j<n && mat[i][j]==-1){

                    q.offer(new int[]{i,j});
                    mat[i][j]= mat[x][y] +1;
                }
            }
        }

        return mat;
    }
}