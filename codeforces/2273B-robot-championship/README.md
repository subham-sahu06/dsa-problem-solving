# Codeforces Round 1127 (Div. 1) - B. Robot Championship

**Link:** https://codeforces.com/contest/2273/problem/B

**Tags:** constructive algorithms, math (*1900)

## Problem
A hidden robot moves on an `n x n` board every second: up `(+1, 0)`, right `(0, +1)` or
down-left `(-1, -1)`. Before each move we shoot a laser on the diagonal `r + c = v`.
Print at most `3n` diagonals that hit the robot for sure, wherever it starts and however it moves.

## Key idea
Look only at the diagonal number `s = r + c` of the robot:
- up or right: `s` grows by 1
- down-left: `s` drops by 2

Now shoot a laser that **drops by 2 every second** (`v, v - 2, v - 4, ...`). Compare the robot with it:
- robot goes up/right: the gap `s - v` grows by 3
- robot goes down-left: the gap `s - v` stays the same

So the gap `s - v` changes only by multiples of 3, and a robot that starts **below** the laser
(`s <= v`) with `s - v` divisible by 3 can only stay where it is relative to the laser or move
towards it. It cannot escape downwards either, because `s >= 2`. When the laser has gone down to
`v <= 4`, any such robot would need `s <= 1`, which is impossible, so it must already have been hit.

## Approach
Run three such sweeps, one after another. Each starts near the top (`2n`, `2n - 1` or `2n - 2`),
so every robot is below it, and each sweep covers a different value of `s mod 3`
(the robot's `s mod 3` goes up by exactly 1 every second, since both +1 and -2 are 1 mod 3).
A sweep goes down by 2 until it reaches a value `<= 4`, so it is at most about `n` shots long,
and the total fits in `3n`.

Checked against a full simulation of every possible robot position for `n = 2..100`.

## Complexity
- Time: O(n) per test
- Space: O(n)

## Solutions
- [Java](Main.java)
- [C++](solution.cpp)
- [Python](solution.py)
