/*
Problem: Sort Characters By Frequency (LeetCode 451)
Link: https://leetcode.com/problems/sort-characters-by-frequency/
Pattern: Max Heap + HashMap

Approach:
Sabse pehle hashmap me characters ki frequency store kar lenge
using getOrDefault.

String traverse karke:
- Har character ki frequency map me update kar denge.

Ab ek max heap create karenge
jo frequencies ke according compare karega:

(a, b) -> map.get(b) - map.get(a)

Isse heap ka top hamesha highest frequency wala character hoga.

Ab hashmap traverse karenge:
for(char key : map.keySet())

- Har character ko heap me add kar denge.

Ab jab tak heap empty nahi ho jata:
- Character ko poll karenge:
  char c = heap.poll()

- Uski frequency map se nikaalenge:
  int freq = map.get(c)

- Ab jab tak freq > 0:
  character ko StringBuilder me append karte rahenge.

At last:
ans.toString() return kar denge.

Time Complexity: O(n log k)
(k = unique characters)

Space Complexity: O(n)
*/

class Solution {
    public String frequencySort(String s) {
        
        HashMap<Character,Integer> map =  new HashMap<>();
        PriorityQueue<Character> pq= new PriorityQueue<>((a,b)-> map.get(b)-map.get(a));

        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }

        for(char key:map.keySet()){
            pq.offer(key);
        }

        StringBuilder ans= new StringBuilder();

        while(!pq.isEmpty()){
            char c=pq.poll();
            int freq= map.get(c);

            while(freq>0){
                ans.append(c);
                freq--;
            }
        }
        return ans.toString();
    }
}