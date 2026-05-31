/*
Problem: Destroying Asteroids (LeetCode 2126)
Link: https://leetcode.com/problems/destroying-asteroids/
Pattern: Sorting + Greedy

Approach:
Observation:
Agar koi asteroid current mass se destroy ho sakta hai,
to usse chhote saare asteroids bhi destroy ho jayenge.

Isliye array ko sort kar denge
taaki greedily smallest se largest tak process kar saken.

Ek currSum variable lenge
jo current planet mass store karega.
Isse long type rakhenge
taaki integer overflow avoid ho sake.

Ab sorted array par iterate karenge:

- Agar currSum < asteroids[i] ho,
  matlab current asteroid destroy nahi ho sakta,
  to directly false return kar denge.

- Warna asteroid destroy ho jayega,
  aur uska mass current mass me add kar denge:
  currSum += asteroids[i]

Agar poora array successfully traverse ho jaye,
to true return kar denge.

Time Complexity: O(n log n)
(sorting)

Space Complexity: O(1)
(or O(log n) depending on sorting implementation)
*/

class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long currSum=mass;

        for(int i=0;i<asteroids.length;i++){
            if(currSum<asteroids[i])return false;
            currSum+=asteroids[i];
        }

        return true;
    }
}