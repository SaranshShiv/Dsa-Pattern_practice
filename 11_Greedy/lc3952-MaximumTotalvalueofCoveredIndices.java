/*
Problem: Maximum Subarray Sum With One Bit Flip (LeetCode 3952)
Link: https://leetcode.com/problems/maximum-subarray-sum-with-one-bit-flip/
Pattern: Greedy + String Builder

Approach:
Ek StringBuilder lenge
taaki easily 0 aur 1 change/swap kar saken.

Ab string ko back se traverse karenge.

- Agar current character 0 hai,
  to continue kar denge.

- Warna:
  current index ko store kar lenge:
  index = i

  Ab ek x variable lenge
  aur while loop chalayenge:

  while(x > 0 && sb.charAt(x) == '1')

  Is loop me:
  - Agar nums[x] < nums[index] ho,
    to:
    index = x

  Aisa isliye:
  Kyunki hume maximum sum chahiye,
  to hum minimum value wale selected element ko replace karna prefer karenge.

  Har iteration me:
  x--

Loop tab stop hoga:
- ya to x == 0 ho jaye
- ya current character 0 mil jaye.

Ab check karenge:
- Agar nums[x] > nums[index] hai,
  to:
  - sb.charAt(x) ko 1 kar denge
  - sb.charAt(index) ko 0 kar denge

Isse larger value include ho jayegi
aur smaller value remove ho jayegi.

Fir:
i = x

taaki unnecessary previous positions dobara check na karni pade.

Traversal complete hone ke baad:
- StringBuilder traverse karenge.
- Jahan bhi character 1 hoga,
  us corresponding nums[i] ko answer me add kar denge.

At last final answer return kar denge.

Time Complexity: O(n²) worst case

Space Complexity: O(n)
*/

class Solution {
    public long maxTotal(int[] nums, String s) {
        
        long ans=0;
        StringBuilder sb = new StringBuilder(s);
        int n=nums.length;

        for(int i=n-1;i>=0;i--){

            if(s.charAt(i)=='0')continue;
            else {

                int x=i;
                while(x>0 && s.charAt(x)=='1'){

                    if(nums[i] >nums[x])i=x;
                    x--;
                }
                
                if(sb.charAt(x)=='0' && nums[x]>nums[i]){
                    sb.setCharAt(i,'0');
                    sb.setCharAt(x,'1');
                }
                i=x;
            }
        }
        for(int i=0;i<n;i++){
            if(sb.charAt(i)=='1')ans+=nums[i];
        }
        return ans;
    }
}