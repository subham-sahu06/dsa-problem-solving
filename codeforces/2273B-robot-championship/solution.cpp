#include <bits/stdc++.h>
using namespace std;
int main() {
    int t;
    cin >> t;
    while (t--) {
        int n;
        cin >> n;
        vector<int> seq;
        int time = 0;
        for (int target = 0; target < 3; target++) {
            int v = 2 * n;
            while (((v - time) % 3 + 3) % 3 != target) v--;
            while (true) {
                seq.push_back(v);
                time++;
                if (v <= 4) break;
                v -= 2;
            }
        }
        cout << seq.size() << '\n';
        for (size_t i = 0; i < seq.size(); i++) {
            cout << seq[i] << (i + 1 < seq.size() ? ' ' : '\n');
        }
    }
    return 0;
}
