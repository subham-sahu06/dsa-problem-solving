# 2124. Check if All A's Appears Before All B's

https://leetcode.com/problems/check-if-all-as-appears-before-all-bs/

## Idea

Every 'a' comes before every 'b' exactly when the string never has a 'b' followed directly by an 'a'. If some 'b' is before some 'a', then somewhere between them a "b" is immediately followed by an "a", so checking for the substring "ba" is enough.

## Complexity

O(n) time and O(1) extra memory.
