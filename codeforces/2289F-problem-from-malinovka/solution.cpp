#include <bits/stdc++.h>
using namespace std;
int main(){
    const int M=1000000;
    vector<char> sq(M+1,1);
    for(long long i=2;i*i<=M;i++)for(long long j=i*i;j<=M;j+=i*i)sq[j]=0;
    vector<vector<int>> R(1001);
    for(int p=2;p<=1000;p++)for(int r=1;r<p;r++)if(sq[r*p])R[p].push_back(r);
    int t;scanf("%d",&t);
    vector<int> f(M+1);
    while(t--){
        int n;scanf("%d",&n);
        for(int m=1;m<=n;m++){long long k=(long long)sqrtl((long double)n/m);while((k+1)*(k+1)*m<=n)k++;while(k*k*m>n)k--;f[m]=k;}
        long long a=(long long)f[1]*f[1]*f[1];
        for(int q=2;q<=n;q++)if(sq[q])a+=3LL*f[q]*f[q]*f[1];
        long long s=0;
        for(int p=2;(long long)p*(p+1)<=n;p++){
            if(!sq[p])continue;
            const vector<int>&rp=R[p];
            for(int q=p+1;(long long)p*q<=n;q++){
                if(!sq[p*q])continue;
                long long fq=f[p*q],in=0;
                for(int r:rp)if(sq[r*q])in+=(long long)f[r*p]*f[r*q];
                s+=in*fq;
            }
        }
        printf("%lld\n",a+6*s);
    }
}
