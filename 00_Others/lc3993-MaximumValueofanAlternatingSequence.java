/*
Problem: Maximum Value of an Alternating Sequence (LeetCode 3993)
Link: https://leetcode.com/problems/maximum-value-of-an-alternating-sequence/
Pattern: Math + Greedy Observation

Approach:
Question ko solve karne ke liye
poori array construct karne ki zarurat nahi hai.

Observation:

Starting value:

s

fix hai.

Baaki elements ko aise choose karna hai
ki final value maximum ho.

Ek aur important observation:

Har alternate position par
value 1 se decrease hoti hai,

aur baaki positions par
value m se increase hoti hai.

Isliye hume bas yeh count karna hai
ki kitni baar:

-1

add hoga,

aur kitni baar:

+m

add hoga.

Sabse pehle:

Agar:

n == 1

ho,

to sirf ek hi element hoga.

Isliye answer directly:

s

return kar denge.

Ab count karenge
kitni negative operations hongi.

Formula:

negative = (n - 1) / 2

Aisa isliye
kyunki alternate positions par hi
1 decrease hota hai.

Baaki saari operations
+m wali hongi.

Unki count hogi:

(n - 1 - negative)

Ab final answer directly
formula se calculate kar sakte hain.

Starting value:

s

me se
negative operations subtract karenge.

Aur:

+m

wali operations add kar denge.

Matlab:

answer =
s
- negative
+ (long)m * (n - 1 - negative)

Ab ek final observation:

Agar:

n

odd hai,

to ek extra position
positive side me contribute karti hai.

Isliye:

answer + 1

karna padega.

Aur agar:

n

even hai,

to calculated answer hi final answer hoga.

At last:

return final answer.

Time Complexity: O(1)

Space Complexity: O(1)
*/

class Solution {
    public long maximumValue(int n, int s, int m) {
        if(n==1)return s;
        int negative= (n-1)/2;
        long ans = (long)s - negative + (long)m * (n - 1 - negative);
        return n%2==0?ans:ans+1;
    }
}