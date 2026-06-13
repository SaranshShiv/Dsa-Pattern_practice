/*
Problem: Reorganize String (LeetCode 767)
Link: https://leetcode.com/problems/reorganize-string/
Pattern: MaxHeap + Freq Array

appraoch- first count the freq of each character using a freq array

while counting check if freq of any character becomes greater than (n+1)/2 then return ""

because if a character occurs more than half of the string length then it can never be arranged such that no two adjacent characters are same

now take a maxheap of int[] and a StringBuilder ans

itterate over the freq array

whosever freq is not 0 add it in maxheap as

maxheap.offer(new int[]{freq[i],i})

here i is storing the numeric value of the character

now while size of maxheap is greater than or equal to 2

poll out 2 elements and store them in 2 different arrays

append both characters in order to the string builder

sb.append((char)(a[1]+'a'))
sb.append((char)(b[1]+'a'))

this converts the numeric value back to the corresponding character

now decrease the freq of both characters

if a[0]-1 > 0 add it back to the heap

if b[0]-1 > 0 add it back to the heap

because those characters are still left to be appended

after the whole while loop there might still be one element left in the heap

so if heap is not empty

poll it and append its character to the answer

at last return sb.toString()

Time Complexity: O(n log 26)

Space Complexity: O(26)
*/

class Solution {
    public String reorganizeString(String s) {
        
        int[] freq = new int[26];
        int n=s.length();

        for(char c:s.toCharArray()){
            freq[c-'a']++;

            if(freq[c-'a'] > (n+1)/2)return "";
        }

        PriorityQueue<int[]> maxheap=  new PriorityQueue<>((a,b)-> b[0]==a[0]?(b[1]-'a') -(a[1] -'a'):b[0]-a[0]);
        StringBuilder sb= new StringBuilder();

        for(int i=0;i<26;i++){
            if(freq[i]>0){
                maxheap.offer(new int[]{freq[i],i});
            }
        }

        while(maxheap.size() >=2){
            int[] a= maxheap.poll();
            int[] b= maxheap.poll();

            sb.append((char)(a[1]+'a'));
            sb.append((char)(b[1]+'a'));

            if(--a[0]>0)maxheap.offer(a);
            if(--b[0]>0)maxheap.offer(b);
        }

        if(!maxheap.isEmpty()){
            sb.append((char)(maxheap.poll()[1]+'a'));
        }

        return sb.toString();
    }
}