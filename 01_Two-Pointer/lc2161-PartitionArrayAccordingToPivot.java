/*
Problem: Partition Array According to Given Pivot (LeetCode 2161)
Link: https://leetcode.com/problems/partition-array-according-to-given-pivot/
Pattern: Two Pointers

Approach:
Ek answer array lenge
aur left aur right pointers rakhenge
jo answer array me filling positions show karenge.

- left = 0
- right = n - 1

Ab do aur pointers lenge:
- l = 0
- r = n - 1

While loop chalayenge:
while(l < n)

- Agar nums[l] pivot se chhota hai,
  to us value ko ans[left] me daal denge.

  Fir:
  l++
  left++

- Same way:
  agar nums[r] pivot se bada hai,
  to us value ko ans[right] me daal denge.

  Fir:
  right--
  r--

Ab:
Jab tak left <= right, 
(left<= right isliye kyunki right pointer bhi filling position show kar raha hai)
matlab beech ke remaining positions
pivot values ke liye hain.

To:
ans[left] = pivot
aur left++ karte rahenge.

At last final answer array return kar denge.

Time Complexity: O(n)

Space Complexity: O(n)
*/

class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        
        int n=nums.length;
        int[] ans= new int[n];

        int l=0;
        int r=n-1;

        int left=0;
        int right=n-1;

        while(l<n){
            
            //placing smaller element at left
            if(nums[l]<pivot){
                ans[left++]=nums[l];
            }

            //placing larger element at right;
            if(nums[r]>pivot){
                ans[right--]=nums[r];
            }

            l++;
            r--;
        }

        //placeing remaining elements as they would be pivot
        while(left<=right){
            ans[left++]=pivot;
        }

        return ans;
    }
}