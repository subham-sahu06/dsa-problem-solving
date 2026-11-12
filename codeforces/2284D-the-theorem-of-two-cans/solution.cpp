#include <bits/stdc++.h>
using namespace std;
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    string mode;
    int t;
    cin >> mode >> t;
    while (t--) {
        if (mode == "first") {
            int n;
            string s;
            cin >> n >> s;
            vector<pair<int, int>> edges;
            int w = -1;
            for (int v = 2; v <= n; v++) {
                if (s[v - 2] == '1') {
                    w = v;
                    break;
                }
            }
            if (w == -1) {
                edges.push_back({1, 2});
                edges.push_back({2, 3});
                edges.push_back({1, 3});
                for (int v = 4; v <= n; v++) edges.push_back({v - 1, v});
            } else {
                for (int v = 2; v <= n; v++) {
                    if (s[v - 2] == '1') edges.push_back({1, v});
                    else edges.push_back({w, v});
                }
            }
            cout << edges.size() << '\n';
            for (auto& e : edges) cout << e.first << ' ' << e.second << '\n';
        } else {
            int n, m;
            cin >> n >> m;
            vector<vector<int>> adj(n + 1);
            for (int i = 0; i < m; i++) {
                int u, v;
                cin >> u >> v;
                adj[u].push_back(v);
                adj[v].push_back(u);
            }
            vector<int> color(n + 1, -1);
            color[1] = 0;
            queue<int> q;
            q.push(1);
            bool ok = true;
            while (!q.empty()) {
                int u = q.front();
                q.pop();
                for (int x : adj[u]) {
                    if (color[x] == -1) {
                        color[x] = color[u] ^ 1;
                        q.push(x);
                    } else if (color[x] == color[u]) {
                        ok = false;
                    }
                }
            }
            string res;
            for (int v = 2; v <= n; v++) res += ok ? char('0' + color[v]) : '0';
            cout << res << '\n';
        }
    }
    return 0;
}
