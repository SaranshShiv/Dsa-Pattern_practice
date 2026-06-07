/*
Problem: Median of Two Sorted Arrays (LeetCode 4)
Link: https://leetcode.com/problems/median-of-two-sorted-arrays/
Pattern: Binary Search

Approach:
Hum hamesha choti array par binary search lagayenge.

Isliye:
agar n1 > n2 ho,
to function ko swap karke call kar denge
taaki nums1 choti array ho.

Function me:
- n1 aur n2 length nikaal lenge.
- start = 0
- end = n1

Yahan:
start aur end partition ki possible positions show karte hain.

Total elements:
total = n1 + n2

Ab:
left = (n1 + n2 + 1) / 2

Yeh batata hai ki final partition ke left side
total kitne elements hone chahiye.

Ab binary search chalayenge:

while(start <= end)

mid1:
- nums1 ki partition position
- aur yeh bhi batata hai ki nums1 ke kitne elements
  left partition me jayenge.

mid1 = start + (end - start) / 2

Ab:
mid2 = left - mid1

Kyuki:
total left elements me se
mid1 already nums1 se le chuke hain,
baaki nums2 se aayenge.

Ab partition values nikaalenge:

x1:
- nums1 ke left partition ka last element

x1 = nums1[mid1 - 1]

Agar mid1 == 0 ho,
to:
x1 = Integer.MIN_VALUE

Same way:
x2 = nums2[mid2 - 1]
ya MIN_VALUE if mid2 == 0

Ab right partition ke first elements:

y1 = nums1[mid1]

Agar mid1 == n1 ho,
to:
y1 = Integer.MAX_VALUE

Same way:
y2 = nums2[mid2]
ya MAX_VALUE if mid2 == n2

Ab check karenge:

if(x1 <= y2 && x2 <= y1)

Kyuki:
- x1 to obviously y1 se chhota hoga
  (same sorted array)
- but hume yeh bhi ensure karna hai ki
  cross arrays bhi sorted partition maintain karein.

Agar yeh condition true hai,
matlab correct partition mil gaya.

Ab:
- Agar total odd hai:
  median = max(x1, x2)

- Warna:
  median =
  (max(x1, x2) + min(y1, y2)) / 2.0

Else if:
x1 > y2

Matlab:
nums1 ka left side ka element
nums2 ke right side ke element se bada hai.

To:
nums1 se kam elements lene padenge.

Isliye:
end = mid1 - 1

Else:
matlab:
x2 > y1

To:
nums1 me aur elements chahiye left partition me.

Isliye:
start = mid1 + 1

Is process ke baad function correct median return kar dega.

Main function me bas answer return kar denge.

Time Complexity: O(log(min(n1, n2)))

Space Complexity: O(1)
*/

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int n1=nums1.length;
        int n2=nums2.length;
        Double ans;

        if(n1<n2){
            ans= solve(nums1,nums2);
        }
        else{
            ans= solve(nums2,nums1);
        }
        return ans;
    }

    Double solve(int[] arr1,int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;

        int start=0;
        int end=n1;

        int Total=n1+n2;
        int left=(n1+n2+1)/2;

        while(start<=end){
            int mid1=start+(end-start)/2;
            int mid2=left-mid1;

            //left half
            int x1=mid1==0?Integer.MIN_VALUE:arr1[mid1-1];
            int x2=mid2==0?Integer.MIN_VALUE:arr2[mid2-1];

            //right half
            int y1=mid1==n1?Integer.MAX_VALUE:arr1[mid1];
            int y2=mid2==n2?Integer.MAX_VALUE:arr2[mid2];

            if(x1<=y2 && x2<=y1){

                if(Total%2!=0){
                    return (double)(Math.max(x1,x2));
                }
                else{
                    int value= Math.max(x1,x2) +Math.min(y1,y2);
                    return value/2.0;
                }
            }
            else if(x1>y2){
                end=mid1-1;
            }
            else{
                start=mid1+1;
            }
        }
        return 0.0;
    }
}