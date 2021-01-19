#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

int order(int product, int count){
	product = product - count;
	return product;
}

int getSalesRate(int price, int count){
	return price*count;	
}

int getTax(int amount){
	return amount / 10;
}

void printTodayCalculate(int orderCount, int originalCount, int afterOrderCount, int amount){
	printf("주문 건수 : %i\n", orderCount);
	printf("기존 재고량 : %i\n", originalCount);
	printf("남은 재고량 : %i\n", afterOrderCount);
	printf("매출액(부가세 포함): %i\n", amount);
}

int main(void){
	int watermelon = 5;
	int watermelonePrice = 10000;
	int orderCount = 3;
	int amount;
	int tax;

	int afterOrderCount = order(watermelon, orderCount);
	amount = getSalesRate(watermelonePrice, orderCount);
	tax = getTax(amount);

	printTodayCalculate(orderCount, watermelon, afterOrderCount, amount-tax);

	return 0;
}
