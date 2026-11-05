# 1385. Find the Distance Value Between Two Arrays

**Difficulty:** Easy

**Link:** https://leetcode.com/problems/find-the-distance-value-between-two-arrays/

## Problem
Count the elements `arr1[i]` for which no element `arr2[j]` satisfies `|arr1[i] - arr2[j]| <= d`.

## Approach
`arr1[i]` is bad only if some `arr2[j]` lies in the range `[arr1[i] - d, arr1[i] + d]`.
1. Sort `arr2`.
2. For each `a` in `arr1`, binary search the first value `>= a - d`.
3. If there is no such value, or it is `> a + d`, then nothing is close to `a`, so count it.

## Complexity
- Time: O((n + m) log m)
- Space: O(1) extra (sorting in place)
