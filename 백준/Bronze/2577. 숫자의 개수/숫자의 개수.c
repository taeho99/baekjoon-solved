#include<stdio.h>

int main(void)
{
	int num[3];
	int result=1;
	int freq[10] = {0};
	int i;
	for (i=0; i<3; i++)
	{
		scanf("%d", &num[i]);
		result *= num[i];
	}

	while(1) {
		if(result == 0)
			break;
		freq[result%10]++;
		result /= 10;
	}
	for (i=0; i<10; i++)
		printf("%d\n", freq[i]);
	return 0;
}