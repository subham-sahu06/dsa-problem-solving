# 1882. Process Tasks Using Servers

**Difficulty:** Medium

**Link:** https://leetcode.com/problems/process-tasks-using-servers/

## Problem
`servers[i]` is the weight of server `i` and `tasks[j]` is the time task `j` needs.
Task `j` arrives at second `j`. A waiting task goes to the free server with the smallest weight
(ties: smallest index). If no server is free, wait until one becomes free.
Return which server handles each task.

## Approach (two min-heaps)
- `free` heap: `(weight, index)` of servers that are free right now.
- `busy` heap: `(free_time, weight, index)` of servers that are working.

For each task `j`:
1. Current time is `max(time, j)`.
2. If no server is free, jump the time forward to the earliest `free_time` in `busy`.
3. Move every server with `free_time <= time` from `busy` back to `free`.
4. Pop the best server from `free`, give it task `j`, and push it to `busy` with
   `free_time = time + tasks[j]`.

Tasks are handled in arrival order, so this matches the queue in the problem.
Use 64-bit time, because the finish time can grow past the int range.

## Complexity
- Time: O((n + m) log n)
- Space: O(n)

## Solutions
- [Java](Solution.java)
- [C++](solution.cpp)
- [Python](solution.py)
