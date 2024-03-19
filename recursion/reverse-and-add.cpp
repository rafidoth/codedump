
#include<bits/stdc++.h> 
using namespace std;
typedef long long int lli;
#define MOD 1000000007


long long int reverse(long long int n, int rev){
	if(n==0){
		return rev;
	}
	rev = rev*10 + n%10;
	return reverse(n/10, rev);
}

bool pallindrome(string str, int s, int e){
	if(s>=e){
		return true;
	}
	if(str[s]== str[e]){
		return pallindrome(str,s+1,e-1);
	}else{
		return false;
	}
}

void solve(long long int n, int count){
	n+= reverse(n,0);
	string str = to_string(n);
	count++;
	if(pallindrome(str,0,str.size()-1)){
		cout<< count << " "<< n;
		return;
	}else{
		return solve(n,count);
	}
}

int main(){
	ios_base::sync_with_stdio(0);
  	cin.tie(0);
  	int t;
  	cin >> t;
  	while(t--){
	  	int n ;
	  	cin >> n;
		solve(n,0);
		cout<<"\n";
	}
}