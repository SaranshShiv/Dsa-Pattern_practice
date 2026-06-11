/*
Problem: Total Cost to Hire K Workers (LeetCode 2462)
Link: https://leetcode.com/problems/total-cost-to-hire-k-workers/
Pattern: Two Min Heaps

Approach:
Do min heaps lenge:
- leftSide
- rightSide

Yeh dono candidate size ke according
left aur right windows maintain karenge.

Initialize:
- left = -1
- right = n

Yahan:
left + 1 next valid filling index represent karta hai
aur right - 1 right side ka next valid filling index.

Ab pehle dono heaps fill karenge.

Left window:
while(left + 1 < right && candidates > 0)

- costs[++left] ko left heap me add kar denge.

Right window:
while(right - 1 > left && candidates > 0)

- costs[--right] ko right heap me add kar denge.

Is process me ensure karte hain
ki same index dono heaps me na aa jaye.

Ab hiring process:

while(k-- > 0)

Case 1:
Agar left heap empty hai

- ans += rightHeap.poll()

Kyuki ab saare available elements
right heap me hi bache hain.

Case 2:
Agar right heap empty hai

- ans += leftHeap.poll()

Kyuki ab saare available elements
left heap me hi bache hain.

Case 3:
Dono heaps non-empty hain

- Heap tops compare karenge.

Agar:
rightHeap.peek() < leftHeap.peek()

To:
- ans += rightHeap.poll()

- Aur right heap me ek naya element add karenge
  if(right - 1 > left)

Case 4:
Otherwise

- ans += leftHeap.poll()

- Aur left heap me ek naya element add karenge
  if(left + 1 < right)

Important:
Har poll ke baad usi side ki window ko
ek element se replenish karne ki try karte hain,
jab tak koi valid index bacha ho.

Agar left aur right pointers almost mil chuke hain,
to iska matlab saare indices already kisi na kisi heap me
insert ho chuke hain,
isliye replenish nahi karenge.

At last total answer return kar denge.

Time Complexity: O((k + candidates) log candidates)

Space Complexity: O(candidates)
*/

class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        
        int n=costs.length;
        PriorityQueue<Integer> candidate1= new PriorityQueue<>();
        PriorityQueue<Integer> candidate2= new PriorityQueue<>();
        long ans=0;

        int left=-1;
        int right=n;
        int x=candidates;
      
        while(left+1<right && x>0){
            candidate1.offer(costs[++left]);
            x--;
        }
        x=candidates;

        while(right-1>left && x>0){
            candidate2.offer(costs[--right]);
            x--;
        }

        while(k>0){
            
            if(candidate1.isEmpty()){
                ans+=candidate2.poll();
            }
            else if(candidate2.isEmpty()){
                ans+=candidate1.poll();
            }
            else{
                if(candidate1.peek() >candidate2.peek()){
                    ans+=candidate2.poll();
                    
                    if(right-1>left){
                        candidate2.offer(costs[--right]);
                    }
                }
                else{
                    ans+=candidate1.poll();

                    if(left+1<right){
                        candidate1.offer(costs[++left]);
                    }
                }
            }
            k--;
        }
        return ans;
    }
}