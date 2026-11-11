#include <bits/stdc++.h>
using namespace std;
bool ask(const vector<int>& a, int la, const vector<int>& b, int lb) {
    string s = "? 1 " + to_string(la + lb);
    for (int i = 0; i < la; i++) s += ' ' + to_string(a[i]);
    for (int i = 0; i < lb; i++) s += ' ' + to_string(b[i]);
    cout << s << endl;
    int r;
    cin >> r;
    if (r == -1) exit(0);
    return r == 0;
}
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n, m;
        cin >> n >> m;
        vector<vector<int>> adj(n + 1);
        for (int i = 0; i < m; i++) {
            int u, v;
            cin >> u >> v;
            adj[u].push_back(v);
            adj[v].push_back(u);
        }
        vector<int> order;
        vector<bool> seen(n + 1, false);
        for (int s = 1; s <= n; s++) {
            if (seen[s]) continue;
            seen[s] = true;
            size_t head = order.size();
            order.push_back(s);
            while (head < order.size()) {
                int u = order[head++];
                for (int w : adj[u]) {
                    if (!seen[w]) {
                        seen[w] = true;
                        order.push_back(w);
                    }
                }
            }
        }
        int lo = 1, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (ask(order, mid, order, 0)) hi = mid;
            else lo = mid + 1;
        }
        int x = order[lo - 1];
        vector<int> bord;
        vector<bool> inB(n + 1, false);
        inB[x] = true;
        bord.push_back(x);
        for (size_t head = 0; head < bord.size(); head++) {
            int u = bord[head];
            for (int w : adj[u]) {
                if (!inB[w]) {
                    inB[w] = true;
                    bord.push_back(w);
                }
            }
        }
        vector<int> rest;
        int start = n;
        for (int i = 0; i < n; i++) {
            if (!inB[order[i]]) rest.push_back(order[i]);
            else start = min(start, i);
        }
        lo = 1;
        hi = bord.size();
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (ask(rest, rest.size(), bord, mid)) hi = mid;
            else lo = mid + 1;
        }
        int x2 = bord[lo - 1];
        int bpart = lo;
        lo = 1;
        hi = start;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (ask(order, mid, bord, bpart)) hi = mid;
            else lo = mid + 1;
        }
        int y = order[lo - 1];
        if (x == x2) {
            cout << "! " << x << " " << y << endl;
            continue;
        }
        cout << "? 2 " << x << " " << y << endl;
        int r;
        cin >> r;
        if (r == -1) exit(0);
        if (r == 1) cout << "! " << x << " " << y << endl;
        else cout << "! " << x2 << " " << y << endl;
    }
    return 0;
}
