class Solution:
    def minimumCost(self, cost1: int, cost2: int, costBoth: int, need1: int, need2: int) -> int:
        best = None
        for k in (0, min(need1, need2), max(need1, need2)):
            cost = k * costBoth + max(0, need1 - k) * cost1 + max(0, need2 - k) * cost2
            if best is None or cost < best:
                best = cost
        return best
