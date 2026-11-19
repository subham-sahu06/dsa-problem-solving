#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> h(n);
        for (auto &x : h) cin >> x;
        sort(h.begin(), h.end());
        vector<int> left, mid, right;
        for (int i = 0; i < n;) {
            int j = i;
            while (j < n && h[j] == h[i]) j++;
            left.push_back(h[i]);
            if (j - i >= 2) right.push_back(h[i]);
            for (int k = i + 2; k < j; k++) mid.push_back(h[i]);
            i = j;
        }
        reverse(right.begin(), right.end());
        cout << left.size() + right.size() << '\n';
        vector<int> ans = left;
        ans.insert(ans.end(), mid.begin(), mid.end());
        ans.insert(ans.end(), right.begin(), right.end());
        for (int k = 0; k < n; k++) cout << ans[k] << " \n"[k == n - 1];
    }
}
