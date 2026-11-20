#include <bits/stdc++.h>
using namespace std;
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        string s;
        cin >> n >> s;
        char cur = 'R';
        int ans = 0;
        for (char c : s) {
            if (cur != c) ans++;
            cur = c == 'R' ? 'B' : 'R';
        }
        cout << ans << '\n';
    }
}
