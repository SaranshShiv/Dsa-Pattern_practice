/*
Problem: Left and Right Sum Differences (LeetCode 2574)
Link: https://leetcode.com/problems/left-and-right-sum-differences/
Pattern: Prefix and Suffix Sum

Approach:
leftSum aur rightSum variables lenge
aur ek answer array create kar lenge.

Sabse pehle backward traversal karenge
aur answer array ko temporarily rightSum array ki tarah use karenge.

Matlab:
ans[i] = rightSum
rightSum += nums[i]

rightSum ko answer insert karne ke baad increase karte hain
kyunki:
rightSum me sirf right side ke elements ka sum chahiye,
current element include nahi hona chahiye.

(Alternative:
Hum totalSum bhi calculate kar sakte the,
aur:
rightSum = totalSum - leftSum - nums[i]
nikal sakte the.)

Ab final traversal me:
- leftSum on the go calculate karenge.

Current index ka answer hoga:
abs(ans[i] - leftSum)

Kyuki:
- ans[i] currently rightSum store kar raha hai.
- leftSum left side ka sum hai.

To:
ans[i] = Math.abs(ans[i] - leftSum)

Ab:
leftSum += nums[i]

leftSum ko bhi baad me increase karte hain
same reason ke liye:
current element left side me include nahi hona chahiye.

Traversal complete hone ke baad
final answer array return kar denge.

Time Complexity: O(n)

Space Complexity: O(1)
(answer array excluded)
*/

class Solution {
    public int[] leftRightDifference(int[] nums) {
        
        int n=nums.length;
        int leftsum=0;
        int rightsum=0;
        int[] ans=new int[n];
          
        for(int i=n-1;i>=0;i--){
            ans[i]=rightsum;
            rightsum+=nums[i];
        }

        for(int i=0;i<n;i++){
            int value= Math.abs(ans[i]-leftsum);
            ans[i]=value;
            leftsum+=nums[i];
        }

        return ans;
    }
}