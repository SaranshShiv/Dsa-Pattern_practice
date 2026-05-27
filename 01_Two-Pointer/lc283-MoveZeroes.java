/*
Problem: Move Zeroes (LeetCode 283)
Link: https://leetcode.com/problems/move-zeroes/
Pattern: Two Pointers

Approach:
Use two pointers:
- right pointer scans the array.
- left pointer marks the position where the next non-zero element should go.

Whenever nums[right] != 0:
swap nums[left] and nums[right], then increment left.

This ensures all non-zero elements are shifted forward
while zeros automatically move to the end.

Time Complexity: O(n)
Space Complexity: O(1)  (in-place)
*/

class Solution {
    public void moveZeroes(int[] nums) {
        int left=0;
        for(int right=0;right<nums.length;right++){
            if(nums[right]!=0){
                int a=nums[left];
                nums[left]=nums[right];
                nums[right]=a;
                left++;
            }
        }
        return;
    }
}