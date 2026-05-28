/*
Problem: Permutations (LeetCode 46)
Link: https://leetcode.com/problems/permutations/
Pattern: Backtracking

Approach:
Ek boolean array use karenge yeh check karne ke liye ki kaunsa element
already current list me use ho chuka hai.
Agar element pehle se used hai to usse skip kar denge.

Har recursive call par loop 0th index se start karenge.
- Agar element list me nahi hai (visited false hai),
  to usse list me add karenge aur visited true mark kar denge.
- Phir next recursion call karenge.

Base Case:
Agar current list ki length nums ki length ke barabar ho jaye,
to us list ko answer me add kar denge.

Backtracking Step:
Jab recursive call return hogi,
to list se last element remove kar denge
aur us element ka visited wapas false kar denge
taaki woh dusre permutation me reuse ho sake.

Time Complexity: O(n!)
Space Complexity: O(n) (recursion stack + visited array)
*/

class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] used = new boolean[nums.length];
        permutation(nums,new ArrayList<>(), used);
        return ans;
    }

    void permutation(int[] nums, List<Integer> temp, boolean[] used){
        //basecase
        if(temp.size()== nums.length){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(used[i])continue;

            used[i]=true;
            temp.add(nums[i]);
            permutation(nums,temp,used);
            temp.remove(temp.size()-1);
            used[i]=false;
        }
    }
}