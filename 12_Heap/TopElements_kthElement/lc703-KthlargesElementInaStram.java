/*
Problem: Kth Largest Element in a Stream (LeetCode 703)
Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
Pattern: Min Heap

Approach:
Ek global min heap maintain karenge.

Constructor me:
- kth = k store kar lenge
  (heap me maximum kitne elements rakhne hain).

Ab nums array traverse karenge:
- Har element ko heap me add karenge.

- Agar heap ka size k se bada ho jaye,
  to heap.poll() kar denge.

Isse heap me hamesha k largest elements hi rahenge.

Add Function:
- New value ko heap me add karenge.
- Fir again size check karenge.
- Agar size > k ho jaye,
  to smallest element remove kar denge using poll().

At last:
- heap.peek() return kar denge,
  kyunki min heap me top element hi kth largest element hoga.

Time Complexity:
- Constructor: O(n log k)
- add(): O(log k)

Space Complexity: O(k)
*/

class KthLargest {
    PriorityQueue<Integer> minheap= new PriorityQueue<>();
    int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        for(int i=0;i<nums.length;i++){
            minheap.offer(nums[i]);
            if(minheap.size() >k)minheap.poll();
        }
    }
    
    public int add(int val) {
        minheap.offer(val);
        if(minheap.size() >kth)minheap.poll();
        return minheap.peek();
    }
}