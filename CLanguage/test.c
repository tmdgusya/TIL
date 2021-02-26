#include <stdio.h>

int main(void){
	int x = 10;
	int y = 29;
	char *answer = "what's your name ?\n";
	printf("hello, %s\n", answer);
	if(x < y){
		printf("x is less than y\n");
	}
	return 0;
}
