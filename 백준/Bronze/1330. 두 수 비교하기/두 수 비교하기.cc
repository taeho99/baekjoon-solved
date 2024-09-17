#include <iostream>

int main(void)
{
	using namespace std;

	int a, b;
	cin >> a >> b;
	if (a > b)
		cout << ">";
	else if (a < b)
		cout << "<";
	else
		cout << "==";
	return 0;
}