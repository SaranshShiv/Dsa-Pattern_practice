/*
Problem: Remove Covered Intervals (LeetCode 1288)
Link: https://leetcode.com/problems/remove-covered-intervals/
Pattern: Sorting + Traversal

Approach:
Hume un intervals ki count return karni hai
jo kisi doosre interval ke andar completely covered nahi hain.

Observation:

Ek interval covered hoga
agar woh kisi doosre interval ke andar completely aa jaye.

Example:

[1, 4]

[2, 3]

Yahan:

[2, 3]

poori tarah

[1, 4]

ke andar hai,

isliye yeh covered interval hai.

Problem yeh hai
ki ho sakta hai
koi interval apne just previous interval se cover na ho,
lekin kisi aur pehle wale interval se cover ho jaye.

Isliye pehle intervals ko sort karenge.

Sorting:

- Pehle starting point ke basis par increasing order me.
- Agar starting point same ho,

to ending point ke basis par decreasing order me.

Aisa isliye karte hain
taaki bade interval pehle aayein.

Example:

[1, 6]
[1, 4]

Agar bada interval pehle hoga,
to chhota interval easily covered detect ho jayega.

Ab:

ans = 1

lenge,

kyunki sorted array ka pehla interval
kabhi previous interval se covered nahi ho sakta.

Saath hi:

big = intervals[0][1]

lenge.

Yeh ab tak dekha gaya
maximum ending point represent karega.

Ab array ko

index 1

se traverse karenge.

Har interval ke liye check karenge:

Agar:

big >= intervals[i][1]

to current interval
poori tarah kisi previous interval ke andar hai.

Isliye yeh covered hai.

Continue kar denge.

Otherwise:

Current interval covered nahi hai.

Isliye:

ans++

kar denge.

Aur:

big = intervals[i][1]

update kar denge.

Traversal complete hone ke baad,

ans me
saare uncovered intervals ki count hogi.

At last:

return ans;

Time Complexity: O(n log n)

Space Complexity: O(1)
(excluding sorting space)
*/

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]==b[0]? b[1]-a[1]:a[0]-b[0]);
        int n=intervals.length;

        int big=intervals[0][1];
        int ans=1;
        
        for(int i=1;i<n;i++){

            if(big>=intervals[i][1])continue;
            else{
                big=intervals[i][1];
                ans++;
            }
        }
        return ans;
    }
}