#include <bits/stdc++.h>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int t;
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k;
        vector<int> cnt(n + 1, 0);
        for (int i = 0; i < n; i++) {
            int a;
            cin >> a;
            cnt[a]++;
        }

        int mex = 0, prefix = 0;
        for (int v = 0; v <= n; v++) {
            prefix += cnt[v];
            if (cnt[v] == 0 || prefix < (v + 1) * k) break;
            mex = v + 1;
        }
        cout << mex << '\n';
    }
    return 0;
}
