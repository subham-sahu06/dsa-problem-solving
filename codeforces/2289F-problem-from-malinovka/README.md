# 2289F - Problem from Malinovka

https://codeforces.com/problemset/problem/2289/F

## Idea

Write every number as s * k^2 where s is squarefree. The number of x <= n with squarefree part s is f(s) = floor(sqrt(n / s)).

x * y * z is a perfect square exactly when every prime appears in an even number of the squarefree parts. So the three squarefree parts can be written as r * p, r * q and p * q, where p, q and r are squarefree and pairwise coprime. This is the same as saying that r * p, r * q and p * q are all squarefree. The answer is the sum of f(r * p) * f(r * q) * f(p * q) over all such (p, q, r) with all three products <= n.

The term is symmetric in p, q and r, so count r < p < q once and multiply by 6. Values can only repeat when they are 1, which gives (1, 1, 1) once and (1, 1, q) three times.

For r < p < q we need p * q <= n, so p < sqrt(n). For each squarefree p the list of r < p with r * p squarefree is precomputed.

Checked against a brute force over all triples for n = 1..70 and against the sample.

## Complexity

About n * sqrt(n) / 3 checks in the worst case, but only squarefree products are visited. n = 10^6 runs in about 0.3 s in C++.
