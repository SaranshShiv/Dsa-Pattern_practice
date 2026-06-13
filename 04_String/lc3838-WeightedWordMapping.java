/*
Problem: LeetCode 3838
Link: https://leetcode.com/problems/maximum-number-of-words-you-can-type-or-the-actual-link-of-3838
Pattern: String

appraoch- take a string builder to store the answer

then loop through all words one by one

for every word maintain a count variable

inside that loop through all characters of current word

simply keep adding the weight of each character

count += weights[s.charAt(i)-'a']

isse current word ka total weight mil jayega

after processing whole word do

count %= 26

as we only need values in range 0-25

now convert this value into the required character

append

(char)('z' - count)

z use kar rahe hai because mapping is reversed in the question

z -> 0
y -> 1
x -> 2
...
a -> 25

so larger count automatically gives smaller character

har word ke liye same process repeat karo

at last return sb.toString()

Time Complexity: O(total characters in all words)

Space Complexity: O(number of words)
*/

class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        
        StringBuilder sb= new StringBuilder();

        for(String s:words){
            int count=0;

            for(int i=0;i<s.length();i++){
                count+=weights[s.charAt(i)-'a'];
            }

            count%=26;
            sb.append((char)('z'-count));
        }
        return sb.toString();
    }
}