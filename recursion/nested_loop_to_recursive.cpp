
#include<bits/stdc++.h> 
using namespace std;
typedef long long int lli;
#define MOD 1000000007

		// int g = 0;
  // 		int i = 1;
  // 		while(i<n){
  // 			int j = i+1;
  // 			while(j<=n){
  // 				g+=__gcd(i,j);
  // 				j++;
  // 			}
  // 			i++;
  // 		}
  // 		cout << g<< "\n";

// long long int g = 0;

int fun2(int g,int i,int j, int n){
	if(!(j<=n)) return g;
	g+= __gcd(i,j);
	return fun2(g,i,j+1,n);
}

int fun1(int g , int i,int n ){
	if(!(i<n)) return g;
	g=fun2(g,i,i+1,n);
	return fun1(g,i+1,n);
}


int main(){
	ios_base::sync_with_stdio(0);
  	cin.tie(0);
  	

  	int n;
  	while(cin >> n && n!=0){
  		cout << fun1(0,1,n)<<"\n";

  	}
}