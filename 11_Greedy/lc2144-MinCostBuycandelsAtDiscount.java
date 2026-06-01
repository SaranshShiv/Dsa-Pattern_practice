/*
Problem: Minimum Cost of Buying Candies With Discount (LeetCode 2144)
Link: https://leetcode.com/problems/minimum-cost-of-buying-candies-with-a-discount/
Pattern: Sorting + Greedy

Approach:
Observation:
Ek candy tabhi free mil sakti hai
jab uski cost baaki 2 candies ki minimum cost se chhoti ya equal ho.

Aur hume total cost minimum karni hai,
to obvious hai ki hume possible maximum costly candy ko free lena chahiye.

Isliye array ko sort kar denge.

Ab sorted array me:
- Last se traverse karenge
  kyunki end par sabse costly candies hongi.

Har baar:
- 3 candies ka group lenge.
- Unme se 2 costly candies ka cost answer me add karenge.
- 3rd candy free maan lenge.

Isliye loop me i ko 3 se decrease karte rahenge.

- Jab tak i > 0 hai,
  matlab atleast 2 candies available hain,
  to 2 candies ka cost add karenge.

- Agar last me sirf 1 candy bachi,
  to uska bhi cost answer me add kar denge.

Traversal complete hone ke baad
final answer return kar denge.

Time Complexity: O(n log n)
(sorting)

Space Complexity: O(1)
*/

class Solution {
    public int minimumCost(int[] cost) {
        Arrays.sort(cost);
        
        int last=cost.length-1;
        int ans=0;

        while(last>=0){
            if(last>0){
                ans+=cost[last--] +cost[last--];
                last--;
            }
            else ans+= cost[last--];
        }
        return ans;
    }
}