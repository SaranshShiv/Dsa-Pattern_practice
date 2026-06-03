/*
Problem: Last Stone Weight (LeetCode 1046)
Link: https://leetcode.com/problems/last-stone-weight/
Pattern: Max Heap

Approach:
Sabse pehle saare elements ko max heap me insert kar denge.

Ab jab tak heap ka size 1 se bada hai:
- Heap se 2 largest elements nikaalenge using poll().

- Agar dono equal hain,
  to dono destroy ho jayenge,
  simply continue kar denge.

- Warna:
  bade element me se chhota subtract karenge
  aur difference ko wapas heap me add kar denge:
  heap.offer(x - y)

Is process se har baar largest stones process hote rahenge.

At last:
- Agar heap empty hai,
  to 0 return kar denge.

- Warna heap.peek() return kar denge
  jo last remaining stone hoga.

Time Complexity: O(n log n)

Space Complexity: O(n)
*/

class Solution {
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> heap= new PriorityQueue<>((a,b)-> b-a);

        for(int stone:stones){
            heap.offer(stone);
        }

        while(heap.size()>1){
            int y=heap.poll();
            int x=heap.poll();

            if(y==x)continue;
            else heap.offer(y-x);
        }

        return heap.isEmpty()?0:heap.peek();
    }
}