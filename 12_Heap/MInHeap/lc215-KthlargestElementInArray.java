/*
Problem: Kth Largest Element in an Array (LeetCode 215)
Link: https://leetcode.com/problems/kth-largest-element-in-an-array/
Pattern: Min Heap

Approach:
Ek min heap (priority queue) lenge of size k.

Ab array ko iterate karenge:

- Agar heap ka size k se chhota hai,
  to current element directly add kar denge.

- Agar heap ka size already k hai,
  to current element add karenge
  aur fir ek element remove kar denge.

Is process me:
- Heap me hamesha sirf k largest elements hi rahenge.
- Aur kyunki yeh min heap hai,
  to heap ka top element un k elements me sabse chhota hoga.

Matlab:
Heap ka top automatically kth largest element ban jayega.

At last:
heap.peek() return kar denge.

Time Complexity: O(n log k)
Space Complexity: O(k)
*/

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n=nums.length;

        //using min heap;
        PriorityQueue<Integer> heap= new PriorityQueue<>();

        for(int i=0;i<n;i++){

            if(heap.size()==k){
                heap.offer(nums[i]);
                heap.poll();
            }
            else heap.offer(nums[i]);
        }
        return heap.peek();
    }
}