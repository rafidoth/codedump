
#include<bits/stdc++.h> 
using namespace std;

bool pallindrome(char *str , int s, int e){
	if(s>=e) return true;
	if(str[s]==str[e]){
		return pallindrome(str, s+1, e-1);
	}
	return false;
}


int main(){
	char str[100];
	scanf("%s",str);
	int len = strlen(str);
	printf("%d\n", pallindrome(str,0,len-1));
}