# 2747. Count Zero Request Servers

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/count-zero-request-servers/

## Problem
There are `n` servers and `logs[i] = [server_id, time]` means that server got a request at `time`.
For every query `q`, count the servers that got **no** request in the time range `[q - x, q]`.

## Approach (offline sliding window)
1. Sort `logs` by time and process the queries in increasing order (remember their original index).
2. Keep a window of logs with time inside `[q - x, q]` using two pointers:
   - move `right` forward to add logs with `time <= q`,
   - move `left` forward to drop logs with `time < q - x`.
3. `count[server]` = how many requests that server has inside the window, and `active` = how many
   servers have `count > 0`. Update `active` whenever a count goes from 0 to 1 or from 1 to 0.
4. The answer for the query is `n - active`.

Both pointers only move forward, so each log is added once and removed once.

## Complexity
- Time: O(L log L + Q log Q) for sorting, then O(L + Q)
- Space: O(n + Q)

## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
