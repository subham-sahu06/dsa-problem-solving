#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int n;
        long long x;
        cin >> n >> x;
        vector<long long> h(n);
        for (auto &v : h) {
            long long a;
            cin >> a;
            v = (a + x - 1) / x;
        }
        sort(h.begin(), h.end());
        long long ans = 0;
        for (int i = 0; i < n - 1; i++) ans = max(ans, h[i] - (i + 1));
        cout << ans << '\n';
    }
}
