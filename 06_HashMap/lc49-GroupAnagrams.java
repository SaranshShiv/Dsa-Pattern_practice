/*
Problem: Group Anagrams (LeetCode 49)
Link: https://leetcode.com/problems/group-anagrams/
Pattern: HashMap

Approach:
Ek frequency array le lenge (size 26),
jisme har string ke characters ka count store karenge.

Har string ke liye:
- Uska freq array fill karenge by counting characters.
- Ab is freq array ko StringBuilder me convert kar denge
  (append karke ek unique string bana lenge).
  Yeh string us word ka sorted/normalized form act karegi.

Ab check karenge ki yeh key (sorted version) hashmap me pehle se hai ya nahi.
- Agar nahi hai to map me new entry bana denge:
  <String, new ArrayList<>()>

Phir current original (unsorted) string ko us key wali list me add kar denge
taaki grouping ho sake.

Is process se jo bhi strings same frequency pattern ki hongi,
woh automatically ek hi group me aa jayengi.

Last me:
Ek nayi ArrayList bana kar hashmap ki sari values usme add kar denge
aur wahi return kar denge as final grouped answer.

Time Complexity: O(n * k)
(n = number of strings, k = length of each string)

Space Complexity: O(n * k)
(HashMap + storing grouped strings)
*/

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map= new HashMap<>();

        for(int i=0;i<strs.length;i++){

            //for each letter of alphabet
            int[] freq= new int[26];

            String s= strs[i];

            for(int j=0;j<s.length();j++){
                int index= s.charAt(j) -'a';
                freq[index]++;
            }

            StringBuilder key = new StringBuilder();

            for(int f:freq){
                key.append(f).append('#');
            }
            map.putIfAbsent(key.toString(), new ArrayList<>());
            map.get(key.toString()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}