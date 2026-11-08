from typing import List


class Solution:
    def countServers(self, grid: List[List[int]]) -> int:
        rows = [sum(row) for row in grid]
        cols = [sum(col) for col in zip(*grid)]
        count = 0
        for i, row in enumerate(grid):
            for j, cell in enumerate(row):
                if cell == 1 and (rows[i] > 1 or cols[j] > 1):
                    count += 1
        return count
