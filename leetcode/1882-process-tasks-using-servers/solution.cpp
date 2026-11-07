#include <bits/stdc++.h>
using namespace std;

class Solution {
public:
    vector<int> assignTasks(vector<int>& servers, vector<int>& tasks) {
        priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> freeServers;
        priority_queue<tuple<long long, int, int>, vector<tuple<long long, int, int>>, greater<>> busy;

        for (int i = 0; i < (int)servers.size(); i++) {
            freeServers.push({servers[i], i});
        }

        int m = tasks.size();
        vector<int> ans(m);
        long long time = 0;

        for (int j = 0; j < m; j++) {
            time = max(time, (long long)j);
            if (freeServers.empty()) {
                time = max(time, get<0>(busy.top()));
            }
            while (!busy.empty() && get<0>(busy.top()) <= time) {
                auto [freeAt, weight, idx] = busy.top();
                busy.pop();
                freeServers.push({weight, idx});
            }
            auto [weight, idx] = freeServers.top();
            freeServers.pop();
            ans[j] = idx;
            busy.push({time + tasks[j], weight, idx});
        }
        return ans;
    }
};
