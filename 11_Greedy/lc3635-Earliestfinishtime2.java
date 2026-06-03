/*
Problem: Earliest Finish Time for Land and Water Rides II (LeetCode 3635)
Link: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-ii/
Pattern: Greedy

Approach:
Observation:
Agar hume kisi side se minimum possible finish time chahiye,
to hume bas doosri type ki ride ka minimum ending time hi chahiye.

Isliye:
- Ek loop se minimum water ride end time calculate kar lenge.
- Ek loop se minimum land ride end time calculate kar lenge.

Water minimum end time:
waterMin = min(waterStart[i] + waterDuration[i])

Land minimum end time:
landMin = min(landStart[i] + landDuration[i])

Ab:
- Har land slide ke liye check karenge
  ki waterMin ke saath total earliest finish time kya ban raha hai.

- Similarly:
  Har water slide ke liye check karenge
  ki landMin ke saath minimum possible finish time kya ban raha hai.

Har baar minimum answer update karte rahenge.

At last final minimum answer return kar denge.

Time Complexity: O(n + m)

Space Complexity: O(1)
*/

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        
        int n= landDuration.length;
        int m= waterDuration.length;
        int landmin=Integer.MAX_VALUE;
        int watermin= Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            landmin=Math.min(landmin,landStartTime[i] +landDuration[i]);
        }

        for(int i=0;i<m;i++){
            watermin=Math.min(watermin,waterStartTime[i] +waterDuration[i]);
        }
        int ans=Integer.MAX_VALUE;

        for(int i=0;i<m;i++){
            int waterans=landmin;
            waterans= Math.max(waterans,waterStartTime[i]);
            waterans+=waterDuration[i];

            ans=Math.min(ans,waterans);
        }

        for(int i=0;i<n;i++){
            int landans=watermin;
            landans=Math.max(landans,landStartTime[i]);
            landans+= landDuration[i];

            ans= Math.min(ans,landans);
        }

        return ans;
    }
}
