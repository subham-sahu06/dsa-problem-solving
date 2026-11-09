# 1606. Find Servers That Handled Most Number of Requests

**Difficulty:** Hard

**Link:** https://leetcode.com/problems/find-servers-that-handled-most-number-of-requests/

## Problem
`k` servers handle requests one at a time. Request `i` arrives at `arrival[i]` and takes `load[i]`.
It goes to server `i % k` if free, otherwise to the next free server going around in a circle.
If every server is busy, the request is dropped. Return the servers that handled the most requests.

## Approach
- `busy`: a min-heap of `(finish time, server)`.
- `free`: the free servers in sorted order (TreeSet in Java, `set` in C++).

For each request `i`:
1. Pop every server from `busy` whose finish time is `<= arrival[i]` and add it to `free`.
2. If `free` is empty, drop the request.
3. Otherwise take the smallest free server `>= i % k`; if there is none, wrap around and take the
   smallest free server overall.
4. Count it and push it to `busy` with finish time `arrival[i] + load[i]`.

At the end, return every server whose count equals the maximum.

**Python note:** Python has no sorted set in the standard library, so `free` is a heap of numbers.
When a server is freed during request `i`, it is stored as `i + (server - i) % k`, so the smallest
number in the heap is always the next free server in circular order. The server id is `value % k`.

## Complexity
- Time: O(n log k)
- Space: O(k)

## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
