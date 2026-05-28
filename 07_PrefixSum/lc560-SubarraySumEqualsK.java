/*
Problem: Subarray Sum Equals K (LeetCode 560)
Link: https://leetcode.com/problems/subarray-sum-equals-k/
Pattern: Prefix Sum
Tool Used: HashMap

Approach:
Ek prefixSum variable le lenge jo running sum ki tarah kaam karega.

Ek hashmap lenge jisme (prefixSum, frequency) store karenge.
Starting me map me (0,1) daal denge
kyunki agar k khud starting se mil jaye to
prefixSum - k = 0 ho jayega aur usse handle karna zaroori hai.

Ab nums array par iterate karenge:
- Har index par prefixSum update karenge by adding current element.

- Ab hume check karna hai ki koi previous prefix tha kya jisse
  current subarray ka sum k ban sake.
  Isliye need = prefixSum - k nikaalenge.

- Agar yeh need hashmap me present hai,
  to count me uski frequency add kar denge
  (kyunki utni subarrays possible hain).

- Ab current prefixSum ko hashmap me insert kar denge.
  Agar pehle se present hai to frequency increase kar denge
  using getOrDefault.

Finally, count return kar denge jo total valid subarrays batayega.

Time Complexity: O(n)
Space Complexity: O(n)
*/

class Solution {
    public int subarraySum(int[] nums, int k) {
        //value,count
        HashMap<Integer,Integer> map= new HashMap<>();
        map.put(0,1);

        int prefixsum=0; //an integer that have the prefix sum till that index
        int count=0;

        for(int i=0;i<nums.length;i++){
            prefixsum+=nums[i];

            //agr ye need map mai hoga pehle se mtlb weve got an new array
            int need=prefixsum-k;

            if(map.containsKey(need)){
                count+=map.get(need);
            }

            map.put(prefixsum,map.getOrDefault(prefixsum,0)+1);
        }
        return count;
    }
}