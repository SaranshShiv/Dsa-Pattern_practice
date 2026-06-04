/*
Problem: Kth Smallest Element in a Sorted Matrix (LeetCode 378)
Link: https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
Pattern: Min Heap of int[] Array

Approach:
Is question me har row sorted list ki tarah behave karti hai.

Isliye ek min heap (PriorityQueue) banayenge
jo int[] format me values store karega:

{currentValue, row, col}

Heap automatically currentValue ke according
minimum element top par rakhega.

Sabse pehle:
- Har row ka 0th column value heap me add kar denge.

Matlab:
{matrix[i][0], i, 0}

Ab heap me har row ka smallest available element present hoga.

Ab jab tak k > 1:
- Heap ka smallest element poll karenge.

- Poll karne ke baad:
  uska row aur col access karenge.

- Agar col + 1 < n hai,
  matlab us row me next element exist karta hai,
  to us next element ko heap me add kar denge:

  {matrix[row][col + 1], row, col + 1}

- Har iteration me k-- karte rahenge.

Is process me:
- Heap hamesha rows ke current smallest elements maintain karta hai.
- Hum har baar globally smallest element remove karte hain
  aur us row ka next element insert kar dete hain.

Jab k == 1 reh jayega,
to heap.peek()[0] hi kth smallest element hoga.

At last wahi return kar denge.

Time Complexity: O(k log n)

Space Complexity: O(n)
*/

class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        
        //value,row,col;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0]-b[0]);
        int n=matrix.length;

        for(int i=0;i<n;i++){
            pq.offer(new int[]{matrix[i][0],i,0});
        }

        while(k>1){
            int[] curr= pq.poll();

            int value=curr[0];
            int row=curr[1];
            int col= curr[2];

            if(col+1<n){
                pq.offer(new int[]{matrix[row][col+1],row,col+1});
            }

            k--;
        }
        return pq.peek()[0];
    }
}