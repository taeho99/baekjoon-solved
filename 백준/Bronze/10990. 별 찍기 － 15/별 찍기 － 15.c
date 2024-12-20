#include<stdio.h>

int main(void)
{
	int num;
	int i, j;
	int min, max;
	scanf("%d", &num);
	min=num;
	max=num;

	for(i=1; i<=num; i++)
	{
		for(j=1; j<num+i; j++)
		{
			if(j==min || j==max)
				printf("*");
			else
				printf(" ");
		}
		min--;
		max++;
		printf("\n");
	}

	return 0;
}