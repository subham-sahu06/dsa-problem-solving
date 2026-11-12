#include <bits/stdc++.h>
using namespace std;
int n;
vector<long long> h, a;
long long cost(long long d, long long limit) {
    a = h;
    for (int it = 0; it < 2 * n; it++) {
        int i = it % n;
        int p = i == 0 ? n - 1 : i - 1;
        if (a[p] - d > a[i]) a[i] = a[p] - d;
    }
    for (int it = 2 * n - 1; it >= 0; it--) {
        int i = it % n;
        int q = i == n - 1 ? 0 : i + 1;
        if (a[q] - d > a[i]) a[i] = a[q] - d;
    }
    long long total = 0;
    for (int i = 0; i < n; i++) {
        total += a[i] - h[i];
        if (total > limit) return total;
    }
    return total;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        long long k;
        cin >> n >> k;
        h.assign(n, 0);
        for (auto& x : h) cin >> x;
        long long lo = 0, hi = 0;
        for (int i = 0; i < n; i++) hi = max(hi, llabs(h[i] - h[(i + 1) % n]));
        while (lo < hi) {
            long long mid = (lo + hi) / 2;
            if (cost(mid, k) <= k) hi = mid;
            else lo = mid + 1;
        }
        cout << lo << '\n';
    }
    return 0;
}
