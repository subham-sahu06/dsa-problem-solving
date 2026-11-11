class Solution {
public:
    long long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long long options[3] = {0, min(need1, need2), max(need1, need2)};
        long long best = LLONG_MAX;
        for (long long k : options) {
            long long cost = k * costBoth + max(0LL, need1 - k) * cost1 + max(0LL, need2 - k) * cost2;
            best = min(best, cost);
        }
        return best;
    }
};
