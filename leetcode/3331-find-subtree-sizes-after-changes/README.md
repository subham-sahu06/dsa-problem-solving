# 3331. Find Subtree Sizes After Changes

https://leetcode.com/problems/find-subtree-sizes-after-changes/

## Idea

Walk the original tree with DFS and keep last[c], the deepest node on the current root path whose letter is c.

When we enter node x, last[s[x]] is exactly the closest ancestor y with the same letter. So the new parent of x is last[s[x]] if it exists, otherwise its old parent. Then set last[s[x]] = x for the children, and restore the old value when we leave x.

The new parent is always an ancestor of x in the original tree, so the DFS preorder still puts every node after its new parent. Going through the preorder backwards and adding each subtree size into its new parent gives all the answers.

The DFS is iterative so deep trees (n up to 10^5) do not overflow the stack.

## Complexity

O(n) time and O(n) extra memory.
