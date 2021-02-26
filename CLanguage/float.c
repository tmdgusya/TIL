#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int main(void)
{
	float price;
	printf("What's the price\n");
	scanf("%f", &price);
	printf("Your total is %.2f.\n", price * 1.0625);

	return 0;
}
