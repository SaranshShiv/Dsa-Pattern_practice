/*
Problem: Top K Frequent Elements (LeetCode 347)
Link: https://leetcode.com/problems/top-k-frequent-elements/
Pattern: Min Heap + Frequency HashMap

Approach:
Sabse pehle ek hashmap bana lenge
jo har number ki frequency store karega.

Nums array traverse karke:
- Har element ki frequency map me store/update kar denge.

Ab ek PriorityQueue (Min Heap) banayenge.

Heap ki property change karenge:
(a, b) -> map.get(a) - map.get(b)

Isse heap elements ko unki frequency ke according maintain karega.

Ab hashmap traverse karenge:
- Har key ko heap me add karenge.

- Agar kisi point par heap ka size k se bada ho jaye,
  to heap.poll() kar denge.

Isse heap me hamesha top k frequent elements hi bachenge.

Ab ek answer array bana lenge.

0 se k tak traverse karke:
- Heap se elements nikaalenge using poll()
  aur answer array me store kar denge.

At last answer array return kar denge.

Time Complexity: O(n log k)

Space Complexity: O(n)
(HashMap + Heap)
*/

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n=nums.length;

        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        PriorityQueue<Integer> heap= new PriorityQueue<>((a,b) -> map.get(a)-map.get(b));

        for(int key: map.keySet()){

            heap.offer(key);
            if(heap.size()>k)heap.poll();
        }

        int[] ans= new int[k];

        for(int i=0;i<k;i++){
            ans[i]=heap.poll();
        }

        return ans;
    }
}