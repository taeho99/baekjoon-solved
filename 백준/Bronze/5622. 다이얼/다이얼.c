#include<stdio.h>
#include<string.h>

int main(void)
{
	char word[16];
	int i, result = 0;
	scanf("%s", word);

	for(i = 0; i < strlen(word); i++)
	{
		if(word[i] == 'A' || word[i] == 'B' || word[i] == 'C')
			result += 3;
		else if(word[i] == 'D' || word[i] == 'E' || word[i] == 'F')
			result += 4;
		else if(word[i] == 'G' || word[i] == 'H' || word[i] == 'I')
			result += 5;
		else if(word[i] == 'J' || word[i] == 'K' || word[i] == 'L')
			result += 6;
		else if(word[i] == 'M' || word[i] == 'N' || word[i] == 'O')
			result += 7;
		else if(word[i] == 'P' || word[i] == 'Q' || word[i] == 'R' || word[i] == 'S')
			result += 8;
		else if(word[i] == 'T' || word[i] == 'U' || word[i] == 'V')
			result += 9;
		else if(word[i] == 'W' || word[i] == 'X' || word[i] == 'Y' || word[i] == 'Z')
			result += 10;
	}
	printf("%d", result);

	return 0;
}