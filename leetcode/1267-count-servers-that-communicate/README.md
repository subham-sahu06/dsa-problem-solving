# 1267. Count Servers that Communicate

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/count-servers-that-communicate/

## Problem
`grid[i][j] = 1` means there is a server in that cell. Two servers communicate if they are in the
same row or the same column. Count the servers that can communicate with at least one other server.

## Approach
1. Count the servers in every row (`rows[i]`) and every column (`cols[j]`).
2. A server at `(i, j)` communicates with someone if its row or its column has more than one server:
   `rows[i] > 1 or cols[j] > 1`.
3. Count all servers that pass this check.

## Complexity
- Time: O(m * n)
- Space: O(m + n)

## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
