/*
Problem: Valid Palindrome (LeetCode 125)
Link: https://leetcode.com/problems/valid-palindrome/
Pattern: Two Pointers + String Preprocessing

Approach:
1. Convert the string to lowercase.
2. Remove all non-alphanumeric characters using:
   s.toLowerCase().replaceAll("[^a-z0-9]", "")
3. Use two pointers:
   - left starts from beginning
   - right starts from end
4. Compare characters while left < right:
   - If mismatch → return false
   - Else move inward (left++, right--)
5. If loop finishes, string is a palindrome.

Time Complexity: O(n)
Space Complexity: O(n) (due to cleaned string)
*/

class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase().replaceAll("[^a-z0-9]","");

        int left=0;
        int right=s.length()-1;

        while(left<right){
            if(s.charAt(left)!=s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}