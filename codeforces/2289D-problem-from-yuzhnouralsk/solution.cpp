#include <bits/stdc++.h>
using namespace std;
long long cnt(vector<long long>& a, vector<long long>& tmp, int lo, int hi) {
    if (hi - lo < 2) return 0;
    int mid = (lo + hi) / 2;
    long long inv = cnt(a, tmp, lo, mid) + cnt(a, tmp, mid, hi);
    int i = lo, j = mid, k = lo;
    while (i < mid && j < hi) {
        if (a[i] <= a[j]) tmp[k++] = a[i++];
        else {
            inv += mid - i;
            tmp[k++] = a[j++];
        }
    }
    while (i < mid) tmp[k++] = a[i++];
    while (j < hi) tmp[k++] = a[j++];
    for (int x = lo; x < hi; x++) a[x] = tmp[x];
    return inv;
}
int main() {
    int t;
    scanf("%d", &t);
    while (t--) {
        int n;
        scanf("%d", &n);
        vector<long long> p(n), tmp(n);
        long long s = 0;
        bool bad = false;
        for (int i = 0; i < n; i++) {
            long long x;
            scanf("%lld", &x);
            s += x;
            p[i] = s;
            if (s < 0) bad = true;
        }
        printf("%lld\n", bad ? -1LL : cnt(p, tmp, 0, n));
    }
}
