from typing import List


class Solution:
    def countServers(self, n: int, logs: List[List[int]], x: int, queries: List[int]) -> List[int]:
        logs.sort(key=lambda log: log[1])
        order = sorted(range(len(queries)), key=lambda i: queries[i])

        count = [0] * (n + 1)
        active = 0
        left = right = 0
        answer = [0] * len(queries)

        for idx in order:
            end = queries[idx]
            start = end - x

            # Add every log with time <= end.
            while right < len(logs) and logs[right][1] <= end:
                server = logs[right][0]
                if count[server] == 0:
                    active += 1
                count[server] += 1
                right += 1

            # Drop every log with time < start.
            while left < right and logs[left][1] < start:
                server = logs[left][0]
                count[server] -= 1
                if count[server] == 0:
                    active -= 1
                left += 1

            answer[idx] = n - active
        return answer
