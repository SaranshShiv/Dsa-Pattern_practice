/*
Problem: Maximum Subsequence Score (LeetCode 2542)
Link: https://leetcode.com/problems/maximum-subsequence-score/
Pattern: Min Heap + Greedy

Approach:
Hume maximum possible score chahiye:

score = (sum of selected nums1) * (minimum selected nums2)

Observation:
Hum kisi selected set ka minimum nums2 choose karte hain,
to baaki selected elements ka nums2 usse bada ya equal hona chahiye.

Isliye:
nums2 ke possible minimum values ko try karna useful hai.

Lekin sorting se indexing lose ho jayegi.

To ek 2D array bana lenge:

arr[i][0] = nums1[i]
arr[i][1] = nums2[i]

Ab array ko descending order me sort karenge
on the basis of nums2.

Isse:
Har index i par,
arr[i][1] current minimum nums2 consider ki ja sakti hai,
kyunki uske baad ke saare nums2 usse chhote ya equal honge.

Ab:
- sum variable lenge
- ans variable lenge
- Ek min heap lenge jo selected nums1 values maintain karega.

For loop chalayenge:

- sum += arr[i][0]
- arr[i][0] ko min heap me add kar denge.

Agar heap ka size k se bada ho jaye:
- Heap ka minimum element remove kar denge.
- Aur us value ko sum se bhi subtract kar denge.

Yahan minimum element hi remove karte hain
kyunki hume k elements ke liye nums1 ka maximum possible sum maintain karna hai.

Ab:
Agar heap ka size == k hai,

To current score hoga:

sum * arr[i][1]

Yahan:
arr[i][1] current minimum nums2 hai
aur sum selected k nums1 values ka sum hai.

Har step par:

ans = Math.max(ans, sum * arr[i][1])

update karte rahenge.

Important:
Agar current index ka nums1 remove bhi ho jaye,
to bhi koi problem nahi hai,
kyunki hum har iteration me current nums2 ko minimum maan kar
best possible k elements ka sum maintain kar rahe hain.

At last ans return kar denge.

Time Complexity: O(n log k)

Space Complexity: O(k)
*/

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        
        int n=nums1.length;
        //done to preserve order of nums1 and nums2
        int[][] combine= new int[n][2];

        //nums1 at 0th index and nums2 at 1st index
        for(int i=0;i<nums1.length;i++){
            combine[i][0]=nums1[i];
            combine[i][1]=nums2[i];
        }

        //sort the array on the basis of nums2;
        Arrays.sort(combine,(a,b)-> b[1]-a[1]);

        long sum=0;
        long ans=0;

        PriorityQueue<Integer> minheap= new PriorityQueue<>();

        for(int i=0;i<n;i++){

            sum+=combine[i][0];
            minheap.offer(combine[i][0]);

            if(minheap.size()>k){
                sum-=minheap.poll();
            }

            if(minheap.size()==k){
                ans=Math.max(ans,sum*combine[i][1]);
            }
        }
        return ans;
    }
}