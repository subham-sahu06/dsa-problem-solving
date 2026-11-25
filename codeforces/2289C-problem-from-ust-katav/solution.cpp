#include <bits/stdc++.h>
using namespace std;
int main() {
    int t;
    if (scanf("%d", &t) != 1) return 0;
    while (t--) {
        int n;
        if (scanf("%d", &n) != 1) return 0;
        vector<int> p(n + 2), lf(n + 2), rt(n + 2), st;
        for (int i = 1; i <= n; i++) if (scanf("%d", &p[i]) != 1) return 0;
        for (int i = 1; i <= n; i++) {
            while (!st.empty() && p[st.back()] > p[i]) st.pop_back();
            lf[i] = st.empty() ? 0 : st.back();
            st.push_back(i);
        }
        st.clear();
        for (int i = n; i >= 1; i--) {
            while (!st.empty() && p[st.back()] > p[i]) st.pop_back();
            rt[i] = st.empty() ? n + 1 : st.back();
            st.push_back(i);
        }
        long long ans = 0;
        for (int i = 1; i <= n; i++) {
            int a = i - lf[i], b = rt[i] - i;
            ans += min(a, b) == 1 ? rt[i] - lf[i] - 1 : 2;
        }
        printf("%lld\n", ans);
    }
}
