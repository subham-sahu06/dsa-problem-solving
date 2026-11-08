#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    while (t--) {
        long long a, b;
        cin >> a >> b;
        if (a == b) {
            cout << 0 << '\n';
            continue;
        }
        if (gcd(a, b) == 1) {
            cout << 1 << '\n' << b - a << '\n';
            continue;
        }
        long long mid = -1;
        for (long long c = a + 1; c < b; c++) {
            if (gcd(c, a) == 1 && gcd(c, b) == 1) {
                mid = c;
                break;
            }
        }
        if (mid != -1) {
            cout << 2 << '\n' << mid - a << ' ' << b - mid << '\n';
            continue;
        }
        int len = b - a;
        vector<int> dist(len + 1, -1), par(len + 1, 0);
        dist[0] = 0;
        queue<int> q;
        q.push(0);
        while (!q.empty()) {
            int u = q.front();
            q.pop();
            for (int v = u + 1; v <= len; v++) {
                if (dist[v] == -1 && gcd(a + u, a + v) == 1) {
                    dist[v] = dist[u] + 1;
                    par[v] = u;
                    q.push(v);
                }
            }
        }
        int k = dist[len];
        vector<long long> steps;
        for (int cur = len; cur != 0; cur = par[cur]) {
            steps.push_back(cur - par[cur]);
        }
        reverse(steps.begin(), steps.end());
        cout << k << '\n';
        for (int i = 0; i < k; i++) {
            cout << steps[i] << (i + 1 < k ? ' ' : '\n');
        }
    }
    return 0;
}
