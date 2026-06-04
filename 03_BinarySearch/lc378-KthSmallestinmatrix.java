/*
Problem: Kth Smallest Element in a Sorted Matrix (LeetCode 378)
Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
Pattern: Binary Search on Answers

Approach:
Lowest value matrix ka first element hoga
aur highest value matrix ka last element hoga.

To:
- low = matrix[0][0]
- high = matrix[n-1][n-1]

Ab normal binary search chalayenge:

while(low < high)

- mid nikaalenge.
- Ek function ki help se count karenge
  ki matrix me kitne elements <= mid hain.

- Agar count < k hai,
  matlab kth element abhi bada hoga,
  to low = mid + 1

- Warna:
  mid possible answer ho sakta hai,
  to high = mid

At last low return kar denge
kyunki wahi kth smallest element hoga.

Count Function:
Is function me hum poori column ko ek saath count karne ki try karte hain.

Start:
- last row se
- aur 0th column se

Matlab:
row = n - 1
col = 0

Ab jab tak:
row >= 0 && col < n

- Agar matrix[row][col] <= mid hai,
  matlab us column me current row ke upar ke saare elements bhi
  mid se chhote ya equal honge
  (kyunki columns sorted hain).

  To:
  count += row + 1
  (upar ke saare elements including current)

  Fir:
  col++ kar denge
  taaki next column check kar saken.

- Warna:
  agar current value > mid hai,
  to row-- kar denge
  taaki upar wali smaller row check kar saken.

Is tarah hum O(n) me count calculate kar lete hain.

Time Complexity: O(n * log(max-min))

Space Complexity: O(1)
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row=matrix.length;
        int col=row;
        int low=matrix[0][0];
        int high= matrix[row-1][col-1];

        while(low<high){

            int mid=low+(high-low)/2;

            int count= countLess(matrix,mid);

            if(count<k){
                low=mid+1;
            }
            else high=mid;  //jb count k ke barabar ya jada ho
        }

        return low;
    }

    int countLess(int[][] matrix,int mid){
        int n=matrix.length;

        int row=n-1;
        int col=0;
        int count=0;

        while(row>=0 && col<n){

            if(matrix[row][col] <=mid){
                count+=row+1;
                col++;
            }
            else row--;
        }
        return count;
    }
}