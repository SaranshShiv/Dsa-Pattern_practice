/*
Problem: Sqrt(x) (LeetCode 69)
Link: https://leetcode.com/problems/sqrtx/
Pattern: Binary Search on answers 
implemented as lower bound binary search

Approach:
Yeh lower bound wala case hai jahan hume exact sqrt nahi,
balki x se chhota ya equal integer return karna hota hai.

Start = 0 se lo aur End = x se lo.

Ab binary search chalayenge jab tak start <= end.

- mid nikaalo.
- Agar mid * mid > x hai,
  matlab mid bada ho gaya,
  to end = mid - 1 kar do.

- Warna (mid * mid <= x),
  matlab yeh possible answer ho sakta hai,
  to start = mid + 1 kar do taaki aur bada valid mil sake.

Loop khatam hone ke baad end par hi answer milega,
kyunki woh last valid value hoti hai jiska square x se chhota ya equal hai.

Time Complexity: O(log x)
Space Complexity: O(1)
*/

class Solution {
    public int mySqrt(int x) {
        int start=0;
        int end=x;

        while(start<=end){
            int mid=start +(end-start)/2;

            long sq = (long) mid * mid;

            if(sq==x)
            return mid;

            else if(sq>x)
            end=mid-1;

            else
            start=mid+1;
        }
        return end;
    }
}