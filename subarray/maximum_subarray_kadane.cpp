#include<bits/stdc++.h> 
using namespace std;
typedef long long int lli;
#define MOD 1000000007


/* TC of this solution is )(n) -> optimal one */
/* kadane algorithm */
int maxSubarray(vector<int> v){
    int msum = INT_MIN;
    int sum = 0;
    for(int i:v){
        sum+= i;
        msum = max(msum,sum);
        sum = max(sum,0);  
    }
    return msum;
}

int main(){
  	ios_base::sync_with_stdio(0);
    cin.tie(0);
    int n;
    cin >> n;
    vector<int> v(n);

    for(int i =0;i<n;i++){
        cin >> v[i];
    }

    cout << maxSubarray(v)<<"\n";
}
