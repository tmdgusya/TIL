#define _CRT_SECURE_NO_WARNINGS
#include <stdio.h>

// 주문시 재고를 감소시켜준다.
int order(int product, int count){
	product = product - count;
	return product;
}

// 판매량을 계산한다.
int getSalesRate(int price, int count){
	return price*count;	
}

// 부가가치세를 계산한다.
int getTax(int amount){
	return amount / 10;
}

// 오늘 하루 총 매출량에 대한 정보를 프린트해준다.
void printTodayCalculate(int orderCount, int originalCount, int afterOrderCount, int amount){
	printf("주문 건수 : %i\n", orderCount);
	printf("기존 재고량 : %i\n", originalCount);
	printf("남은 재고량 : %i\n", afterOrderCount);
	printf("매출액(부가세 포함): %i\n", amount);
}

// 남은 재고량과 주문량을 비교하여 주문 가능한지 확인한다
int validOrderCount(int remainStock, int orderCount){
	if(remainStock >= orderCount) return 0;
	else return 1;
}

int main(void){
	int originalStock = 5;
	int watermelonePrice = 10000;
	int orderCount;
	int amount;
	int tax;
	int remainStock = originalStock;
	printf("주문시킬 양을 입력해주세요 : ");
	scanf("%d", &orderCount);
	while(remainStock > 0){
		if(validOrderCount(remainStock, orderCount)){
			printf("주문량이 재고보다 많습니다 . 다시 주문해주세요 :  ");
			scanf("%d", &orderCount);
		}else{
			remainStock = order(originalStock, orderCount);
			amount = getSalesRate(watermelonePrice, orderCount);
			tax = getTax(amount);
		}
	}
	printTodayCalculate(orderCount, originalStock, remainStock, amount-tax);
	return 0;
}
