/*
Problem: Find Minimum in Rotated Sorted Array (LeetCode 153)
Link: https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
Pattern: Binary Search

Approach:
Yahan hume rotated sorted array ka minimum element find karna hai.

Start = 0 aur End = n-1 le lo.

Binary search chalayenge:

- Mid nikaalo.
- Agar nums[mid] > nums[end] hai,
  matlab mid left wale (bade) part me hai,
  aur rotation right side me hai,
  to start = mid + 1 kar do.

- Agar nums[mid] < nums[end] hai,
  matlab mid smallest ho sakta hai ya uske left me answer hai,
  to end = mid kar do (mid ko eliminate nahi karenge).

Jab start == end ho jayega,
wahi index minimum element ka hoga.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int findMin(int[] nums) {
        int start=0;
        int end=nums.length-1;

        while(start<end){
            int mid=start+(end-start)/2;

            if(nums[mid]>nums[end]){
                start=mid+1;
            }
            else
            end=mid;
        }
        return nums[start];
    }
}