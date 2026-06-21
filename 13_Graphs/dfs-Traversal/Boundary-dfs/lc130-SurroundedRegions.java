/*
Problem: Surrounded Regions (LeetCode 130)
Link: https://leetcode.com/problems/surrounded-regions/
Pattern: DFS

Approach:
Hume un 'O' cells ko 'X' me convert karna hai
jo completely surrounded hain.

Observation:

Jo 'O' kisi boundary wale 'O' se connected hai,
use kabhi surround nahi kiya ja sakta.

Isliye:

Hum surrounded regions dhoondhne ki jagah
safe regions dhoondhenge.

Matlab:

Jo bhi 'O' boundary se connected hai,
use mark kar denge.

Sabse pehle:

- First row
- Last row

traverse karenge.

for(int j = 0; j < m; j++)

Agar:

board[0][j] == 'O'

to DFS chala denge.

Similarly:

board[n - 1][j] == 'O'

to bhi DFS chala denge.

Ab isi tarah:

- First column
- Last column

par bhi traverse karenge.

Agar kisi boundary cell par 'O' milta hai,
to DFS start kar denge.

DFS Function:

Sabse pehle boundary conditions check karenge.

Agar:

- i < 0
- j < 0
- i >= n
- j >= m

Ya:

- board[i][j] != 'O'

to return kar denge.

Agar valid 'O' mila,

to usse:

board[i][j] = 'S'

kar denge.

Yahan:

'S' = Safe

Matlab yeh boundary se connected hai
aur surround nahi ho sakta.

Ab DFS ko 4 directions me chalayenge:

dfs(i + 1, j, board);   // down

dfs(i - 1, j, board);   // up

dfs(i, j + 1, board);   // right

dfs(i, j - 1, board);   // left

Is tarah saare boundary-connected 'O'
safe mark ho jayenge.

Ab DFS complete hone ke baad
poori board ko dobara traverse karenge.

Agar:

board[i][j] == 'O'

to matlab yeh boundary se connected nahi tha
aur completely surrounded tha.

Isliye:

board[i][j] = 'X'

kar denge.

Aur agar:

board[i][j] == 'S'

to yeh safe cell tha.

Isliye:

board[i][j] = 'O'

wapas restore kar denge.

At last board required form me modify ho chuki hogi.

Time Complexity: O(m × n)

Space Complexity: O(m × n)
(recursion stack in worst case)
*/

class Solution {
    public void solve(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        //for 1st and last row;
        for(int j=0;j<m;j++){

            if(board[0][j]== 'O'){
                dfs(board,0,j);
            }
            if(board[n-1][j]== 'O'){
                dfs(board,n-1,j);
            }
        }

        //for 1st and last col;
        for(int i=0;i<n;i++){

            if(board[i][0]== 'O'){
                dfs(board,i,0);
            }
            if(board[i][m-1]== 'O'){
                dfs(board,i,m-1);
            }
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){

                if(board[i][j]== 'O'){
                    board[i][j]= 'X';
                }
                if(board[i][j]== 'S'){
                    board[i][j]= 'O';
                }
            }
        }
    }

    void dfs(char[][] board,int i,int j){

        if(i<0 || j<0 || i>=board.length || j>=board[i].length || board[i][j] != 'O'){
            return;
        }

        board[i][j]= 'S';

        dfs(board,i+1,j);
        dfs(board,i-1,j);
        dfs(board,i,j+1);
        dfs(board,i,j-1);
    }
}
