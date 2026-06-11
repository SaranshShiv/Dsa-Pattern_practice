/*
Problem: Find K Pairs with Smallest Sums (LeetCode 373)
Link: https://leetcode.com/problems/find-k-pairs-with-smallest-sums/
Pattern: Heap

Approach:
Ek min heap lenge jo int[] store karega:

{sum, i, j}

Yahan:
- sum = nums1[i] + nums2[j]
- i = nums1 ka index
- j = nums2 ka index

Ek visited HashSet<Long> bhi lenge
jo already added pairs track karega.

Unique code:
i * m + j

Yeh har pair (i, j) ko uniquely represent karega.

Observation:
Agar koi pair (i, j) heap me smallest hai,
to next possible smallest pair
(i + 1, j) ya (i, j + 1) hi ho sakta hai.

Isliye hume sirf inhi neighbours ko explore karna hai.

Ek answer list bana lenge:

List<List<Integer>> ans

Sabse pehle:
(0, 0) pair heap me add kar denge
kyunki yeh hamesha smallest sum wala pair hoga.

Saath me usse visited me bhi mark kar denge.

Ab:

while(k-- > 0 && !heap.isEmpty())

- Heap ka smallest pair poll karenge.
- Usse i aur j extract karenge.

Current pair ko answer me add kar denge:

Arrays.asList(nums1[i], nums2[j])

Ab next possible pairs try karenge.

1. (i, j + 1)

- Agar j + 1 valid index hai
  aur visited me nahi hai,

  to heap me add kar denge
  aur visited me mark kar denge.

2. (i + 1, j)

- Agar i + 1 valid index hai
  aur visited me nahi hai,

  to heap me add kar denge
  aur visited me mark kar denge.

Is tarah heap hamesha next smallest possible pairs maintain karta rahega.

At last answer list return kar denge.

Time Complexity: O(k log k)

Space Complexity: O(k)
*/

class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        
        int n=nums1.length;
        int m=nums2.length;

        List<List<Integer>> ans= new ArrayList<>();
        int i=0;
        int j=0;

        PriorityQueue<int[]> minheap = new PriorityQueue<>((a,b) -> a[0]-b[0]);

        HashSet<Long> visited= new HashSet<>();

        minheap.offer(new int[]{nums1[i]+nums2[j],i,j});
        long key= i*m+j;
        visited.add(key);

        while(k-- >0){
            
            i=minheap.peek()[1];
            j=minheap.peek()[2];

            minheap.poll();
            ans.add(Arrays.asList(nums1[i],nums2[j]));

            if(j+1<m && !visited.contains((long)(i*m+j+1))){
                minheap.offer(new int[]{nums1[i]+nums2[j+1],i,j+1});
                visited.add((long)(i*m+j+1));
            }

            if(i+1<n  && !visited.contains((long)((i+1)*m+j))){
                minheap.offer(new int[]{nums1[i+1]+nums2[j],i+1,j});
                visited.add((long)((i+1)*m+j));
            }
        }
        return ans;
    }
}