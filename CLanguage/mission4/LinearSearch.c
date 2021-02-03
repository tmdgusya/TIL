#include <stdio.h>

int main(void){
	int numbers[6] = {4, 8, 15, 16, 23, 42};

	for(int i = 0; i < 6; i++){
		if(numbers[i] == 50){
			printf("Found\n");
			return 0;
		}
	}
	printf("Not Found");
	return 0;
}

