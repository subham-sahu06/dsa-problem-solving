# 2290B - Stubborn Pen

https://codeforces.com/problemset/problem/2290/B

## Idea

The pen color before each letter is fully decided: it starts red, and after writing a letter it is always the opposite of that letter's color. So before letter i the pen is red if i is 0, otherwise it is the opposite of s[i-1].

A manual switch is needed exactly when this color is different from s[i]. Count those positions while walking the string once.

## Complexity

O(n) per test case, O(1) extra memory.
