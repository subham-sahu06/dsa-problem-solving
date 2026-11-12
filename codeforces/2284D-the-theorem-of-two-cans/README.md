# Codeforces Round 1132 (Div. 2) - D. The Theorem of Two Cans
**Link:** https://codeforces.com/contest/2284/problem/D
**Tags:** communication, constructive algorithms, dfs and similar, graphs, interactive, math, trees
## Problem
Run-twice problem. In the first run, turn a binary string `s` of length `n - 1` into a connected graph
on `n` vertices. Then the judge may many times pick a simple path `v1, ..., v2k` (an even number of
vertices), remove one edge of the path and add the edge `(v1, v2k)`. It also shuffles the edges.
In the second run, get the changed graph back and print the original `s`.
## Key idea
Find something that the operation can never change. The path `v1 ... v2k` has an odd number of edges,
so the new edge `(v1, v2k)` closes an **even** cycle, and one edge of that cycle is removed.
- **If the graph is bipartite**, `v1` and `v2k` have different colours (an odd path always switches
  colour), so the new edge fits the same colouring. Removing an edge cannot break it. So the
  **2-colouring stays the same**.
- **If the graph is not bipartite**, the removed edge can always be replaced by the rest of the even
  cycle, which has odd length, so an odd cycle always stays. So it **stays non-bipartite**.
Fixing vertex 1 to colour 0, a colouring with both colours used gives `2^(n-1) - 1` different
strings, and "not bipartite" is one more case. That is exactly `2^(n-1)` cases, one for each `s`.
## Approach
**First run:** give vertex 1 colour 0 and vertex `i + 1` colour `s[i]`.
- If `s` has a `1`: let `w` be the first vertex with colour 1. Join vertex 1 to every colour-1 vertex
  and `w` to every other colour-0 vertex. This is a tree with that 2-colouring.
- If `s` is all zeros: print a triangle `1-2-3` plus the path `3-4-...-n`, which is not bipartite.
**Second run:** BFS from vertex 1 and 2-colour the graph. If an edge joins two vertices of the same
colour, print all zeros. Otherwise print the colours of vertices `2 .. n`.
Tested with a local judge that applies up to 40 random operations and shuffles the edges and the test
order: all strings for `n <= 7` and 300 random tests up to `n = 60` came back correctly.
## Complexity
- Time: O(n + m) per test
- Space: O(n + m)
## Solutions
- [Java](Main.java)
- [C++](solution.cpp)
- [Python](solution.py)
