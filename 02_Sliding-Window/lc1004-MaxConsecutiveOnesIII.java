/*
Problem: Max Consecutive Ones III (LeetCode 1004)
Link: https://leetcode.com/problems/max-consecutive-ones-iii/
Pattern: Sliding Window

Approach:
We maintain a window using two pointers (left and right).

- right pointer expands the window.
- We keep a count of how many zeros we can still flip (k).

Steps:
1. If nums[right] == 0 → decrement count (we used one flip).
2. If count becomes < 0 → window invalid:
   Move left forward until we remove a zero from window.
   When we pass a zero, increment count back.
3. At every step, compute max window length.
4. Continue expanding right.

This keeps the window valid while maximizing consecutive ones.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int right=0;
        int longest=0;

        while(right<nums.length){

            if(nums[right] !=1){
                k--;
            }

            if(k<0){
                while(nums[left] !=0)left++;
                left++;
                k++;
            }
            longest= Math.max(longest,right-left+1);

            right++;
        }
        return longest;
    }
}