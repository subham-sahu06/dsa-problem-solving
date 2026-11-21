class Solution {
public:
    vector<int> findSubtreeSizes(vector<int>& parent, string s) {
        int n = parent.size();
        vector<vector<int>> ch(n);
        for (int i = 1; i < n; i++) ch[parent[i]].push_back(i);
        vector<int> last(26, -1), prv(n), np(n, -1), order, st = {0};
        order.reserve(n);
        while (!st.empty()) {
            int v = st.back();
            st.pop_back();
            if (v < 0) {
                int u = ~v;
                last[s[u] - 'a'] = prv[u];
                continue;
            }
            int c = s[v] - 'a';
            order.push_back(v);
            if (v) np[v] = last[c] != -1 ? last[c] : parent[v];
            prv[v] = last[c];
            last[c] = v;
            st.push_back(~v);
            for (int x : ch[v]) st.push_back(x);
        }
        vector<int> ans(n, 1);
        for (int i = n - 1; i >= 1; i--) ans[np[order[i]]] += ans[order[i]];
        return ans;
    }
};
