#include <stdio.h>
#define SENTINEL -1

int main()
{
	int M, N, i, count = 0, steps, arr[5010] = { 0 };
	scanf("%d %d", &N, &M);
	for (i = 0; i < N; i++) { arr[i] = i + 1;}
	printf("<");
	arr[i] = SENTINEL;
	i--;
	while (count < N) {
		for (steps = 0; steps < M; steps++) {
			i++;
			if (arr[i] == SENTINEL) {
				i = 0;
			}
			while (arr[i] == 0) {
				i++;
				if (arr[i] == SENTINEL) i = 0;
			}
		}
		while (arr[i] == 0) {
			i++;
			if (arr[i] == SENTINEL) i = 0;
		}
		if (count == N - 1)
			printf("%d", arr[i]);
		else
			printf("%d, ", arr[i]);
		arr[i] = 0;
		count++;
	}
	printf(">");
	return 0;
}