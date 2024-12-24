#include<stdio.h>

int main(void)
{
	int row, score;
	char str[81];
	scanf("%d", &row);
	for (int i = 0; i < row; i++)
	{
		score = 0;
		int cnt = 1;
		scanf("%s", str);
		for (int j = 0; str[j] != '\0'; j++)
		{
			if (str[j] == 'O')
			{
				score += cnt;
				cnt++;
			}
			else
				cnt = 1;
		}
		printf("%d\n", score);
	}
}