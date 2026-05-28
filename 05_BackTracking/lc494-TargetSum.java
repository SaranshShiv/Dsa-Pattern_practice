/*
Problem: Target Sum (LeetCode 494)
Link: https://leetcode.com/problems/target-sum/
Pattern: Backtracking

Approach:
Base Case:
- Agar index nums.length ke barabar ho jaye,
  to check karo kya current sum target ke equal hai.
- Agar equal hai to ans++ kar do.
- Fir return kar do.

Har index par hamare paas 2 choices hoti hain:

1. Current element ko positive lena
   -> recursive call karo with:
      sum + nums[index]

2. Current element ko negative lena
   -> recursive call karo with:
      sum - nums[index]

Dono recursive calls me index + 1 pass karenge
taaki next element process ho sake.

Is tarah har element ke liye + aur - dono possibilities try ho jati hain
aur jitne valid ways target banate hain unka count mil jata hai.

Time Complexity: O(2^n)
Space Complexity: O(n)
(recursion stack)
*/

class Solution {
    int ans=0;
    public int findTargetSumWays(int[] nums, int target) {
        backtrack(nums,target,0,0);
        return ans;
    }

    void backtrack(int[] nums,int target,int sum,int index){
        if(index==nums.length){
            if(target==sum)ans++;
            return;
        }

        backtrack(nums,target,sum+nums[index],index+1);
        backtrack(nums,target,sum-nums[index],index+1);
    }
}