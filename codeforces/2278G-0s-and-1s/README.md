# Codeforces Round 1131 (Div. 3) - G. 0s and 1s

**Tags:** trees, dfs, bitmasks, number theory

## Problem
A tree is rooted at node 1. Every node has a bit `x_i` and a target bit `y_i`.
A pulse injected at the root does this at each node: if the node is 0 it becomes 1 and the pulse
stops; if it is 1 it becomes 0 and a pulse is sent to every child.
Find the minimum number of pulses so every node reaches its target (mod 998244353), or -1.

## Key idea
This is a **binary counter**. Read the bits on any root-to-node path as a binary number with the
root as the lowest bit. One pulse adds exactly 1 to that number (0 -> 1 stops, 1 -> 0 carries).
So `P` pulses turn path value `X` into `X + P`, and we need `X + P = Y` on every path
(mod 2^length), which means `P = Y - X` on every path.

## Approach
1. BFS level by level from the root and compute `Y - X` bit by bit with a borrow, like normal
   binary subtraction. Each node passes its borrow down to its children.
2. Bit number `d` of `P` comes from depth `d`, so **all nodes on the same depth must give the same
   bit**. If two nodes on one depth disagree, the answer is -1.
3. Otherwise `P` = the bits of each depth read as a binary number. Add `2^depth` for every depth
   whose bit is 1, mod 998244353. This is the smallest valid `P`.

## Complexity
- Time: O(n) per test
- Space: O(n)
