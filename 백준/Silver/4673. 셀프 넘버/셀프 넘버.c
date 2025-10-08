#include<stdio.h>

int dn(int a);
int check[10001];
int main(void)
{
	int i;
	for(i=1; i<=10000; i++) {
		check[dn(i)] = 1;
		if(!check[i])
			printf("%d\n", i);
	}
	return 0;
}

int dn(int a)
{
	int result = a;
	if(a >= 10000)
	{
		result += a/10000;
		a = a%10000;
	}
	if(a >= 1000)
	{
		result += a/1000;
		a = a%1000;
	}
	if(a >= 100)
	{
		result += a/100;
		a = a%100;
	}
	if(a >= 10)
	{
		result += a/10;
		a = a%10;
	}
	result += a;
	return result;
}