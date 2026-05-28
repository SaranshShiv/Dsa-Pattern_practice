/*
Problem: Combination Sum (LeetCode 39)
Link: https://leetcode.com/problems/combination-sum/
Pattern: Backtracking

Base Case:
- Agar target == 0 ho jaye,
  to current combination ko answer me add kar do aur return.
- Agar target < 0 ho jaye,
  to yeh invalid path hai, seedha return.

Approach:
Sabse pehle array ko sort kar denge.
Sorting isliye karte hain taaki unnecessary recursion (pruning) avoid ho sake.

Ek start index initialise karte hain.

Ab for loop chalayenge start se array ki length tak.
Start se isliye chala rahe hain taaki jo elements pehle use ho chuke hain
woh dobara previous position par na aaye aur duplicate sets na banen.

Loop ke andar:
- Agar candidates[i] > target ho jaye,
  to break kar denge (kyunki array sorted hai, aage ke sab bhi bade honge).
  Isse unnecessary calls bach jati hain.

- Current element ko list me add karenge.
- Recursive call karenge with same index i
  (i pass karte hain, i+1 nahi),
  kyunki ek element ko multiple times use karna allowed hai.

Backtrack:
- Jab recursion se wapas aayenge,
  to last element remove kar denge taaki next choice try kar saken.

Important Logic:
Start isliye use karte hain:
- Taaki ek element ko baar-baar use kar saken.
- Aur jab start aage badh jaye to purane elements dobara na aayein,
  warna duplicate combinations ban jayenge.

Time Complexity : O(N^(T/M))   → Exponential
Space Complexity: O(T/M)       → Recursion depth
*/

class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        sum(new ArrayList<>() , candidates,0,target); 
        return ans;
    }
    void sum(List<Integer> current, int[] candidates,int start, int target){
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(target<0) return;

        for(int i=start;i<candidates.length;i++){
            if(candidates[i] >target)break;

            current.add(candidates[i]);
            sum(current,candidates,i,target-candidates[i]);
            current.remove(current.size()-1);
        }
        return;
    }
}