#include<stdio.h>

int main(void)
{
	int a, b, c;
	int temp;
	scanf("%d %d %d", &a, &b, &c);
	
	if (a == b && a == c)
		printf("%d", 10000 + a * 1000);
	else if (a == b)
		printf("%d", 1000 + a * 100);
	else if (a == c)
		printf("%d", 1000 + a * 100);
	else if (b == c)
		printf("%d", 1000 + b * 100);
	else {
		if (a < b) {
			temp = a;
			a = b;
			b = temp;
		}
		if (a < c) {
			temp = a;
			a = c;
			c = temp;
		}
		printf("%d", a * 100);
	}
}