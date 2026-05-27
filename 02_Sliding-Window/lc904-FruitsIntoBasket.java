/*
Problem: Fruit Into Baskets (LeetCode 904)
Link: https://leetcode.com/problems/fruit-into-baskets/
Pattern: Sliding Window

Approach:
Do variable le lo jisme 0th aur 1st index ke fruit store kar lenge
(yeh basically hamare 2 allowed fruit types honge).

Ab right pointer se loop chalayenge jab tak right < n.

- Agar nums[right] ki value un dono fruits (a aur b) ke barabar hai
  to window valid hai, simply aage badhte rahenge.

- Agar nums[right] na a ke barabar hai na b ke,
  matlab teesra fruit aa gaya.
  Ab window ko adjust karna padega.

  Is case me left ko right se ek step pehle wale index par le aao
  aur us position wale fruit ko naya 'a' bana do
  (kyunki ab hume sirf 2 type ke fruits rakhne hain).

  Ab jab tak left-1 valid index hai aur nums[left-1] == a,
  tab tak left ko peeche lete jao.
  Isse window me sirf last continuous same fruit ka block reh jata hai.

- Ab doosra fruit automatically nums[right] ho jayega,
  aur window fir se valid ho jayegi.

Har step par maxLen ko (right - left + 1) se compare karke update karte rahenge.
Phir right++ kar denge.

Time Complexity: O(n)
Space Complexity: O(1)
*/


class Solution {
    public int totalFruit(int[] fruits) {
        int n=fruits.length;
        if(n<=2)
        return n;

        int left=0;
        int right=0;
        int a=fruits[0];
        int b=fruits[1];
        int maxlen=0;

        while(right<n){
            
            //agr right a ya b ke barabar nhi hai to .
            if(fruits[right] !=a && fruits[right] !=b){
                left=right-1;
                a=fruits[right-1];
                while((left-1)>=0 &&  fruits[left-1]==a ) left--;
                b=fruits[right];
            }
            //to find the maximum length.
            maxlen=Math.max(maxlen,right-left+1);

            right++;
        }
        return maxlen;
    }
}