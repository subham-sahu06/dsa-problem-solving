#include <bits/stdc++.h>
using namespace std;
const long long MOD = 1000000007LL;
long long power(long long b, long long e) {
    b %= MOD;
    long long r = 1;
    while (e > 0) {
        if (e & 1) r = r * b % MOD;
        b = b * b % MOD;
        e >>= 1;
    }
    return r;
}
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int t;
    cin >> t;
    long long inv2 = (MOD + 1) / 2;
    while (t--) {
        int n;
        string s;
        cin >> n >> s;
        int freeCnt = 0;
        vector<long long> q(2 * n + 2);
        int head = n, tail = n;
        for (int i = 0; i < n; i++) {
            if (s[i] == '1') {
                q[tail++] = 0;
            } else {
                q[tail++] = inv2;
                freeCnt++;
            }
        }
        long long v = 0, prod = 1;
        for (int i = tail - 1; i >= head; i--) {
            long long r = (1 - q[i] + MOD) % MOD;
            v = r * (1 + v) % MOD;
            prod = prod * r % MOD;
        }
        long long total = 0;
        for (int m = n; m >= 2; m--) {
            if (m == 2) {
                long long merged = q[head] * q[tail - 1] % MOD;
                head = tail - 1;
                q[head] = merged;
                v = (1 - merged + MOD) % MOD;
                prod = v;
            } else {
                long long z = q[--tail];
                v = (v - prod + MOD) % MOD;
                prod = prod * power(1 - z + MOD, MOD - 2) % MOD;
                long long y = q[--tail];
                v = (v - prod + MOD) % MOD;
                prod = prod * power(1 - y + MOD, MOD - 2) % MOD;
                long long a = q[head++];
                long long ia = power(1 - a + MOD, MOD - 2);
                v = (v * ia % MOD - 1 + MOD) % MOD;
                prod = prod * ia % MOD;
                long long merged = z * a % MOD;
                long long r = (1 - merged + MOD) % MOD;
                v = r * (1 + v) % MOD;
                prod = prod * r % MOD;
                q[--head] = merged;
                long long ry = (1 - y + MOD) % MOD;
                v = ry * (1 + v) % MOD;
                prod = prod * ry % MOD;
                q[--head] = y;
            }
            total = (total + v) % MOD;
        }
        cout << total * power(2, freeCnt) % MOD << '\n';
    }
    return 0;
}
