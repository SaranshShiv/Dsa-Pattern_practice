/*
Problem: Find First and Last Position of Element in Sorted Array (LeetCode 34)
Link: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
Pattern: Binary Search

Approach:
Yahan hum 2 binary search use karenge.

- Pehli binary search starting index find karne ke liye hogi.
  Isme (start < end) wala logic use karenge.
  Agar target mil bhi jaye to bhi left side me search continue karenge
  taaki first occurrence mile.

- Dusri binary search first wale se mile index se start hogi
  aur last element tak chalegi.
  Isme normal binary search logic use karenge.
  Jab target milega to right side me move karte rahenge
  taaki last occurrence mil jaye.

Edge Cases:
- Agar array empty hai to [-1, -1] return karenge.
- Agar element present nahi hai to bhi [-1, -1] return karenge.

Time Complexity: O(log n)
Space Complexity: O(1)
*/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
         if (n == 0)
            return new int[]{-1, -1};

        int start=0;
        int end=n-1;
        int[] ans = new int[2];

        //first binary search to find the start index.
        while(start<end){
            int mid= start+(end-start)/2;

            if(nums[mid] <target)
            start=mid+1;
            else
            end=mid;
        }
        ans[0]=start;
        end=n-1;

        //second binary search for the end index.
        while(start<=end){
            int mid= start+(end-start)/2;

            if(nums[mid]<= target)
            start=mid+1;
            else
            end=mid-1;
        }
        ans[1]=end;

        return nums[ans[0]] == target ? ans : new int[]{-1, -1};
    }
}