#include<bits/stdc++.h> 
using namespace std;
typedef long long int lli;
#define MOD 1000000007

/* solution of O(n^2) this also gives TLE in Leetcode */
int maxSubarray(vector<int> v){
    int n = v.size();
    int max_sum = INT_MIN;
    for(int i =0;i<n;i++){
        vector<int> pref_sum;
        int sum_now = 0;
        for(int j = i;j<n;j++){
            sum_now+= v[j];
            pref_sum.push_back(sum_now);
        }
        int m = pref_sum.size();

        /* for(int x: pref_sum) cout << x << " "; */
        cout << "\n";
        for(int k = 0;k<m;k++){
            max_sum = max(max_sum, pref_sum[k]);
        }
    }

    return max_sum;
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
