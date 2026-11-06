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
        vector<int> a(n);
        for (int& v : a) cin >> v;

        // The kept numbers must all be multiples of the smallest kept number d,
        // so for every d count how many elements it divides.
        vector<int> distinct = a;
        sort(distinct.begin(), distinct.end());
        distinct.erase(unique(distinct.begin(), distinct.end()), distinct.end());

        int best = 0;
        for (int d : distinct) {
            int keep = 0;
            for (int v : a) {
                if (v % d == 0) keep++;
            }
            best = max(best, keep);
        }
        cout << n - best << '\n';
    }
    return 0;
}
