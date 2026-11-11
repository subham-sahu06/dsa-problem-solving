class Solution {
    public long minimumCost(int cost1, int cost2, int costBoth, int need1, int need2) {
        long[] options = {0, Math.min(need1, need2), Math.max(need1, need2)};
        long best = Long.MAX_VALUE;
        for (long k : options) {
            long cost = k * costBoth + Math.max(0, need1 - k) * cost1 + Math.max(0, need2 - k) * cost2;
            best = Math.min(best, cost);
        }
        return best;
    }
}
