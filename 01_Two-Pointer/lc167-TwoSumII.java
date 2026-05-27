/*
Problem: Two Sum II - Input Array Is Sorted (LeetCode 167)
Link: https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
Pattern: Two Pointers

Approach:
Do pointers le lo left aur right.

Left ko start (0th index) par rakhenge
aur right ko last index par.

Ab jab tak left < right:
- Dono ka sum nikaalenge.

- Agar sum target ke barabar ho jata hai
  to wahi indices return kar denge.

- Agar sum target se chhota hai
  to left++ kar denge taaki sum bada ho.

- Warna (sum target se bada hai)
  to right-- kar denge taaki sum chhota ho.

Kyuki array sorted hai, is approach se correct pair mil jata hai
without using extra space.

Time Complexity: O(n)
Space Complexity: O(1)
*/

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left=0;
        int right=numbers.length-1;

        while(left<right){
            int sum=numbers[left]+numbers[right];

            if(sum==target)
            return new int[]{left+1,right+1};

            else if(sum<target)
            left++;
            else
            right--;
        }
        return new int[]{-1,-1};
    }
}