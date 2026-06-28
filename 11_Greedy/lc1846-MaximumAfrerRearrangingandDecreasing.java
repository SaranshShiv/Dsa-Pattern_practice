/*
Problem: Maximum Element After Decreasing and Rearranging (LeetCode 1846)
Link: https://leetcode.com/problems/maximum-element-after-decreasing-and-rearranging/
Pattern: Greedy + Sorting

Approach:
Hume array ka maximum possible element maximize karna hai.

Question ki conditions hain:

- Pehla element hamesha 1 hona chahiye.
- Adjacent elements ka difference at most 1 hona chahiye.

Observation:

Agar array ko sort kar dein,

to chhoti values pehle aur badi values baad me aa jayengi.

Isse greedily har position par
maximum possible value assign kar sakte hain.

Sabse pehle array ko sort karenge.

Ab:

0th index ko directly:

arr[0] = 1

kar denge.

Aisa isliye
kyunki first element ko 1 banana compulsory hai.

Ab baaki poori array traverse karenge.

Har index i ke liye,

current value do cheezon se zyada nahi ho sakti:

- Original value arr[i]
- Previous value + 1

Agar previous value se zyada increase kar diya,
to adjacent difference 1 se bada ho jayega.

Isliye current value hogi:

arr[i] = Math.min(arr[i], arr[i - 1] + 1)

Is tarah har position par
maximum valid value assign hoti rahegi.

Traversal complete hone ke baad,

last index par
maximum possible element hoga.

At last:

return arr[n - 1];

Time Complexity: O(n log n)

Space Complexity: O(1)
*/

class Solution {
    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        
        Arrays.sort(arr);
        int n=arr.length;
        int max=0;
        arr[0]=1;

        for(int i=1;i<n;i++){
            arr[i]= Math.min(arr[i],arr[i-1]+1);
        }

        return arr[n-1];
    }
}