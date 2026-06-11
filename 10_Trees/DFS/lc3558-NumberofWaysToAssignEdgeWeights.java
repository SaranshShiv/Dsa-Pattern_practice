/*
Problem: Count the Number of Good Nodes (LeetCode 3558)
Link: https://leetcode.com/problems/count-the-number-of-good-nodes/
Pattern: Adjacency List + DFS + Exponentiation

Approach:
Kyunki yeh ek undirected tree hai,
to sabse pehle adjacency list banayenge.

Ek List<List<Integer>> lenge
aur 0 se edges.length tak har node ke liye
ek empty neighbours list create kar denge.

Ab edges traverse karenge:

list.get(u).add(v)
list.get(v).add(u)

Dono taraf add karenge
kyunki tree undirected hai.

Ab hume tree ki maximum depth calculate karni hai,
kyunki answer depth par depend karta hai.

DFS for Depth Calculation:
Ek function banayenge jisme:
(node, parent, adj)

- depth = 0

- Current node ke saare neighbours par iterate karenge.

- Parent ko skip karenge
  taaki wapas upar na chale jayein.

- Har valid neighbour ke liye:

  depth = Math.max(depth,
                   dfs(neighbour, node, adj) + 1)

  Yahan +1 current edge ko count karne ke liye hai.

- At last maximum depth return kar denge.

Ab main function me:

answer = power(2, depth - 1)

Reason:
Odd aur even count wale arrangements equal hote hain.

Total possible ways:
2^depth

To odd count ways:
2^depth / 2
= 2^(depth - 1)

Exponentiation Function:
power(base, exponent)

- Agar exponent == 0 ho,
  to 1 return kar do.

- Warna:

  long half = power(base, exponent / 2)

  long result = (half * half) % mod

  Kyunki:

  2^8 = 2^4 * 2^4

  Isliye recursively half answer nikaal kar
  usse square kar dete hain.

- Agar exponent odd hai:

  result = (result * base) % mod

  Example:

  2^9 = (2^4 * 2^4) * 2

  Yahan extra 2 multiply karna padta hai.

At last result return kar denge.

Time Complexity: O(n)

Space Complexity: O(n)
(adjacency list + recursion stack)
*/

class Solution {
    int mod=1000000007;

    public int assignEdgeWeights(int[][] edges) {
        int n=edges.length;
        
        List<List<Integer>> adj = new ArrayList<>();

        for(int i=0;i<=n+1;i++){
            adj.add(new ArrayList<>());
        }

        //createing adjacency list;
        for(int i=0;i<n;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }

        int depth= dep(1,-1,adj);
        
        return (int)power(2,depth-1);
    }

    int dep(int node,int parent,List<List<Integer>> adj){
        int depth=0;

        for(int x:adj.get(node)){
            if(x==parent)continue;

            depth=Math.max(depth,dep(x,node,adj)+1);
        }

        return depth;
    }

    long power(int base,int exponent){
        if(exponent==0)return 1;

        long half= power(base,exponent/2);

        long result= (half*half)%mod;

        if(exponent%2==1){ //odd
            result=(result*base)%mod;
        }
        return result;
    }
}