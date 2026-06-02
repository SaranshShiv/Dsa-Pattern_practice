/*
Problem: Earliest Finish Time for Land and Water Rides I (LeetCode 3633)
Link: https://leetcode.com/problems/earliest-finish-time-for-land-and-water-rides-i/
Pattern: Greedy + Brute Force

Approach:
Hume ek land ride aur ek water ride leni hai,
aur dono possible orders check karne padenge.

1. Land -> Water
2. Water -> Land

Land -> Water:
- Har land ride ke liye finish time calculate karenge.
- Ab har water ride try karenge.
- Water ride ka start time hoga:
  max(landFinishTime, waterStartTime)

- Is path ka final finish time nikaalenge
  aur minimum answer maintain karenge.

Water -> Land:
- Har water ride ke liye finish time calculate karenge.
- Ab har land ride try karenge.
- Land ride ka start time hoga:
  max(waterFinishTime, landStartTime)

- Is path ka final finish time nikaalenge
  aur minimum answer maintain karenge.

Basically:
Har land ride ke saath har water ride check karenge,
aur har water ride ke saath har land ride bhi check karenge.

At last dono orders me se minimum finish time return kar denge.

Time Complexity: O(n * m)
(n = land rides, m = water rides)

Space Complexity: O(1)
*/

class Solution {
    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min=Integer.MAX_VALUE;
        
        for(int i=0;i<landDuration.length;i++){
            int duration=landStartTime[i]+landDuration[i];

            for(int j=0;j<waterDuration.length;j++){
                int ans=duration;

                if(ans<waterStartTime[j])ans+= waterStartTime[j]-ans;
                ans+=waterDuration[j];

                min=Math.min(min,ans);
            }
        }

        for(int i=0;i<waterDuration.length;i++){
            int duration=waterStartTime[i]+waterDuration[i];

            for(int j=0;j<landDuration.length;j++){
                int ans=duration;

                if(ans<landStartTime[j])ans+= landStartTime[j]-ans;
                ans+=landDuration[j];

                min=Math.min(min,ans);
            }
        }

        return min;
    }
}