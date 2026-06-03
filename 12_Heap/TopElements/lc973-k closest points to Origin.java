/*
Problem: K Closest Points to Origin (LeetCode 973)
Link: https://leetcode.com/problems/k-closest-points-to-origin/
Pattern: Max Heap

Approach:
Ek max heap (PriorityQueue) lenge
jo points ko distance ke according store karega.

Heap comparator:
(a, b) ->
(b[0]*b[0] + b[1]*b[1]) - (a[0]*a[0] + a[1]*a[1])

Iska matlab:
- Heap reverse order me work karega
  yani max heap ban jayega.

- Distance calculate karne ke liye:
  x² + y² use karenge.

Sqrt lene ki zarurat nahi hai
kyunki:
sqrt(25) > sqrt(16)
yeh directly:
25 > 16
se bhi compare ho jata hai.

Ab points array traverse karenge:
- Har point ko heap me add karenge.

- Agar heap ka size k se bada ho jaye,
  to heap.poll() kar denge.

Isse heap me hamesha k closest points hi bachenge.

Ab answer array bana lenge.

Jab tak heap empty nahi ho jata
ya k elements process nahi ho jate:
- heap.poll() karke points answer me store kar denge.

At last answer return kar denge.

Time Complexity: O(n log k)

Space Complexity: O(k)
*/

class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int n=points.length;
        
        PriorityQueue<int[]> pq= new PriorityQueue<>((a,b) -> (b[0]*b[0] + b[1]*b[1])-(a[0]*a[0] + a[1]*a[1]));

        for(int i=0;i<n;i++){
            pq.offer(points[i]);

            if(pq.size()>k)pq.poll();
        }

        int[][] ans= new int[k][2];
        for(int i=0;i<k;i++){
            ans[i] = pq.poll();
        }

        return ans;
    }
}