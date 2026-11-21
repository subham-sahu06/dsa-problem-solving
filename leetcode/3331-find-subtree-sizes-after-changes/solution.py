class Solution:
    def findSubtreeSizes(self, parent: List[int], s: str) -> List[int]:
        n = len(parent)
        ch = [[] for _ in range(n)]
        for i in range(1, n):
            ch[parent[i]].append(i)
        last = {}
        prv = [None] * n
        np = [-1] * n
        order = []
        st = [0]
        while st:
            v = st.pop()
            if v < 0:
                u = ~v
                if prv[u] is None:
                    last.pop(s[u], None)
                else:
                    last[s[u]] = prv[u]
                continue
            order.append(v)
            if v:
                np[v] = last.get(s[v], parent[v])
            prv[v] = last.get(s[v])
            last[s[v]] = v
            st.append(~v)
            st.extend(ch[v])
        ans = [1] * n
        for u in reversed(order[1:]):
            ans[np[u]] += ans[u]
        return ans
