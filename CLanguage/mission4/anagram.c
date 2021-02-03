#include <stdio.h>

int main(void)
{
	const int arraySize = 5;
	int array1[arraySize] = {1,1,1,3,2};
	int array2[arraySize] = {2,1,1,3,1};
	int temp;
	for(int i = 0; i < arraySize; i++)
	{
		for(int j = 0; j < arraySize; j++)
		{	if(j+1 < arraySize){
			if(array1[j] > array1[j+1])
			{
				temp = array1[j];
				array1[j] = array1[j+1];
				array1[j+1] = temp;
			}
			}
		}

	} 
        for(int i = 0; i < arraySize; i++)
        {
                 for(int j = 0; j < arraySize; j++)
                  {	
			  if(j+1 < arraySize){

                          if(array2[j] > array2[j+1])
                          {
                                  temp = array2[j];
                                  array2[j] = array2[j+1];
                                  array2[j+1] = temp;
                          }
			  }
                  }
 
        }
	for(int i = 0; i < arraySize; i++)
	{
		printf("%d\n", array2[i]);
	}
	for(int i = 0; i < arraySize; i++){
		if(!(array1[i] == array2[i])){
			printf("False\n");
			return 0;
		}
	}
	printf("True\n");
	return 0;
}
