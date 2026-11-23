#include <bits/stdc++.h>
using namespace std;
int main(){
    int t;
    if(scanf("%d",&t)!=1)return 0;
    while(t--){
        int n,d;
        scanf("%d %d",&n,&d);
        int m=2*n-1;
        vector<int> a(m+1),b(m+1),dep(m+1,0),id(m+1),ans(n+1);
        for(int k=n+1;k<=m;k++)scanf("%d %d",&a[k],&b[k]);
        for(int k=m;k>n;k--){dep[a[k]]=dep[k]+1;dep[b[k]]=dep[k]+1;}
        vector<priority_queue<int>> pq(n+1);
        for(int i=1;i<=n;i++){pq[i].push(i);id[i]=i;}
        for(int k=n+1;k<=m;k++){
            int x=id[a[k]],y=id[b[k]];
            int mx=pq[x].top(),my=pq[y].top();
            while(!pq[x].empty()&&pq[x].top()>=my+d){ans[pq[x].top()]=dep[pq[x].top()]-dep[k];pq[x].pop();}
            while(!pq[y].empty()&&pq[y].top()>=mx+d){ans[pq[y].top()]=dep[pq[y].top()]-dep[k];pq[y].pop();}
            if(pq[x].size()<pq[y].size())swap(x,y);
            while(!pq[y].empty()){pq[x].push(pq[y].top());pq[y].pop();}
            id[k]=x;
        }
        auto &r=pq[id[m]];
        while(!r.empty()){ans[r.top()]=dep[r.top()];r.pop();}
        string out;
        for(int i=1;i<=n;i++){out+=to_string(ans[i]);out+=(i==n?'\n':' ');}
        fputs(out.c_str(),stdout);
    }
}
