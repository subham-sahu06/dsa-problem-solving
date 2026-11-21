# 2290A - Three Piles

https://codeforces.com/problemset/problem/2290/A

## Idea

One move keeps the total the same and changes two piles by exactly 1: one pile loses a stone, another gains one. After the move all piles must equal s = (a + b + c) / 3.

So the pile that loses must have s + 1, the pile that gains must have s - 1, and the untouched pile must already have s. Since a <= b <= c, this means a = s - 1, b = s, c = s + 1, which is the same as b - a = 1 and c - b = 1.

If all piles are already equal the answer is NO, because the move is mandatory.

## Complexity

O(1) per test case.
