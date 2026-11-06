#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> countServers(int n, vector<vector<int>>& logs, int x, vector<int>& queries) {
        sort(logs.begin(), logs.end(), [](const vector<int>& a, const vector<int>& b) {
            return a[1] < b[1];
        });

        int q = queries.size();
        vector<int> order(q);
        iota(order.begin(), order.end(), 0);
        sort(order.begin(), order.end(), [&](int a, int b) { return queries[a] < queries[b]; });

        vector<int> count(n + 1, 0);
        int active = 0;
        int left = 0, right = 0;
        int total = logs.size();
        vector<int> answer(q);

        for (int idx : order) {
            int end = queries[idx];
            int start = end - x;

            // Add every log with time <= end.
            while (right < total && logs[right][1] <= end) {
                if (count[logs[right][0]]++ == 0) active++;
                right++;
            }
            // Drop every log with time < start.
            while (left < right && logs[left][1] < start) {
                if (--count[logs[left][0]] == 0) active--;
                left++;
            }
            answer[idx] = n - active;
        }
        return answer;
    }
};
