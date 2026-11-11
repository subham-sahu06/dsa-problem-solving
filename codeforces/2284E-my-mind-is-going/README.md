# Codeforces Round 1132 (Div. 2) - E. My Mind Is Going
**Link:** https://codeforces.com/contest/2284/problem/E
**Tags:** binary search, dfs and similar, graphs, interactive
## Problem
A bipartite graph `G` is given. Two hidden edges `e1`, `e2` are such that adding either one keeps the
graph bipartite, but adding both does not. With at most `33` queries, find one of the hidden edges.
- `? 1 k v1 ... vk`: is the subgraph of `G' = G + e1 + e2` induced by these vertices bipartite?
- `? 2 u v`: is `(u, v)` an edge of `G'`?
## Key idea
If `e1` were inside a component of `G`, adding it would change nothing, so `e2` alone would already
break the graph. So both hidden edges go between the **same two components** `A` and `B`, with
opposite parity: `e1 = (a1, b1)`, `e2 = (a2, b2)`, and the only odd cycles use both of them.
So an induced subgraph is **not** bipartite exactly when it has all four endpoints and the paths
`a1 ~ a2` inside `A` and `b1 ~ b2` inside `B`. If the chosen part of every component is connected,
the paths are always there, so the query only checks "are all four endpoints inside?".
A BFS order of a component has this property: every prefix of it is connected.
## Approach
Put all components one after another, each in BFS order. Let `A` be the earlier of the two.
1. Binary search the shortest **prefix of this order** that is not bipartite. It ends at the later
   of `b1`, `b2`. Call it `x`.
2. Run a new BFS of `B` **starting from `x`**. Keep all other vertices and binary search the shortest
   prefix of this BFS. It ends at the other `b` endpoint, `x2` (if `b1 = b2`, then `x2 = x`).
3. Keep that connected part of `B` (from `x` to `x2`) and binary search the prefix of the vertices
   before `B` in the order. It ends at one `a` endpoint, `y`.
4. `y` is joined to `x` or to `x2`. One `? 2 x y` query tells which (no query needed if `x = x2`).
## Query count
`ceil(log2 n) + ceil(log2 |B|) + ceil(log2 (n - |B|)) + 1`, and a check of every `n <= 2000`
shows this is never more than `33`.
Tested with a local interactor on 150 random graphs (up to `n = 2000`), the largest number of queries used was 33.
## Complexity
- Time: O(n + m) for the BFS, plus O(n) for printing each of the 33 queries
- Space: O(n + m)
## Solutions
- [Java](Main.java)
- [C++](solution.cpp)
- [Python](solution.py)
