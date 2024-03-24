# Problems
- [Maximum subarray](https://leetcode.com/problems/maximum-subarray/) 
- Maximum Product Subarray
- Subarray sum Equals K
- Subarray sums divisible by K
- Largest subarray with zero sum


## Kadane Algorithm
```
int kadane(vector<int> v){
    int msum = INT_MIN;
    int sum = 0;
    for(int i:v){
        sum+= i;
        msum = max(msum,sum);
        sum = max(sum,0);  
    }
    return msum;
}
```


