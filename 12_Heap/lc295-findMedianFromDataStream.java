/*
Problem: Find Median from Data Stream (LeetCode 295)
Link: https://leetcode.com/problems/find-median-from-data-stream/
Pattern: Min Heap + Max Heap

Approach:
Do heaps lenge:
- Max Heap
- Min Heap

Max heap:
- Left half of elements maintain karega.
- Kyunki yeh max heap hai,
  iska top (peek) hamesha middle ya near-middle element hoga.

Min heap:
- Right half of elements maintain karega.
- Kyunki yeh min heap hai,
  iska top bhi near-middle element hoga.

Adding Element:
Har baar:
- Pehle element ko max heap me add karenge.

Phir:
- max ka top remove karke min heap me daal denge:
  min.offer(max.poll())

Aisa isliye:
- Max heap hamesha left half ka largest element deta hai,
  jo proper balancing maintain karne me help karta hai.

Ab balancing check karenge:
- Agar min heap ka size max heap se bada ho jaye,
  to:
  max.offer(min.poll())

Isse max heap ya to equal size me rahega
ya ek element zyada maintain karega.

Median Function:
- Agar max heap ka size min heap se bada hai,
  matlab total elements odd hain,
  to median = max.peek()

- Warna:
  even length hai,
  to median dono middle elements ka average hoga:

  (max.peek() + min.peek()) / 2.0

2.0 use karte hain
taaki answer double me aaye.

Time Complexity:
- addNum(): O(log n)
- findMedian(): O(1)

Space Complexity: O(n)
*/

class MedianFinder {
    PriorityQueue<Integer> minheap= new PriorityQueue<>();
    PriorityQueue<Integer> maxheap= new PriorityQueue<>((a,b) -> b-a);
    
    public MedianFinder() {
    }
    
    public void addNum(int num) {

        maxheap.offer(num);
        minheap.offer(maxheap.poll());

        if(minheap.size() >maxheap.size()){
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {

        if(maxheap.size() > minheap.size()){
            return maxheap.peek();
        }
        return (maxheap.peek() +minheap.peek())/2.0;
    }
}