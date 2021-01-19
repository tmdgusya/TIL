#include <stdio.h>

double getSavingsMaturityMoney(int year, double interestRate, int money){
	return interestRate*year*money;
}


int main(void)
{
	int money;
	const double interestRate = 1.2;
	const int year = 1;

	printf("넣으실 금액을 입력해주세요 : ");
	scanf("%d", &money);
	
	printf("%.2f", getSavingsMaturityMoney(money, interestRate, year));
	return 0;
}

