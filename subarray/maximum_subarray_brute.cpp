
#include <algorithm>
#include<bits/stdc++.h> 
#include <climits>
using namespace std;
typedef long long int lli;
#define MOD 1000000007

/* O(n^3) solution this can give TLE easily */
int maxSubarray(vector<int> nums){
    int n = nums.size();
    int sum = INT_MIN;
    for(int i =0;i<n;i++){
        for(int j=i;j<n;j++){
            int sum_now= 0;
            for(int k = i;k<=j;k++){
                sum_now += nums[k];
            }
            cout << sum_now << "\n";
            sum = max(sum, sum_now);
        }
    }

    return sum;
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
