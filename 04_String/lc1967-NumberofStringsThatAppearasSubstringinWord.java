/*
Problem: Number of Strings That Appear as Substrings in Word (LeetCode 1967)
Link: https://leetcode.com/problems/number-of-strings-that-appear-as-substrings-in-word/
Pattern: String

Approach:
Question me hume count karna hai
ki patterns array ki kitni strings
given word ke andar substring ke roop me present hain.

Iske liye
patterns array ko ek baar traverse karenge.

Har string s ke liye,

check karenge:

word.contains(s)

Agar true hai,

to matlab current pattern
word ke andar substring ke roop me present hai.

Isliye:

ans++

kar denge.

Traversal complete hone ke baad,

ans me total matching patterns ki count hogi.

At last:

return ans;

Time Complexity: O(n × m)
(n = number of patterns,
m = average contains() checking cost)

Space Complexity: O(1)
*/

class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int ans=0;
        
        for(String s:patterns){

            if(word.contains(s))ans++;
        }
        return ans;
    }
}