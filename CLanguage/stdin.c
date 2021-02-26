#define _CRT_SECURE_NO_WARNINGS 
#include <stdio.h>

int main(void){
	
	int age;

	printf("what's your age?\n");
	scanf("%d", &age);
	int days = age * 365;
	printf("You are a least %i days old.\n", days);

	return 0;

}
