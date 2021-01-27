#include<stdio.h>
#include<string.h>
#include<cs50.h>
#include<stdlib.h>

void add(int num);
int pop();
void display();
void menu();
int quit();
void isExistElement();
void action(int num);

const int QUEUE_SIZE = 50;
int queue[QUEUE_SIZE];
int choice;
int number;
int rare = 0;
int front = 0;

int main(void)
{
    while(true)
    {
            menu();
            printf("입력 : ");
            scanf("%d", &choice);
            action(choice);
    }
}

void menu()
{
    printf("1. 삽입 \n");
    printf("2. 삭제 \n");
    printf("3. 조회 \n");
    printf("4. 종료 \n");
}

void isExistElement()
{
    if(rare == 0){
        printf("큐에 데이터가 없습니다.");
    }else{
        printf("현재 큐 사이즈 : %d", rare);
    }
}

void add(int num)
{
    queue[rare] = num;
    rare++;
}

int quit()
{
    exit(0);
}

int pop()
{
    int data = queue[front];
    queue[front] = 0;
    front++;
    return data;
}

void display()
{
    for(int i = front; i < rare; i++){
        printf("%d ", queue[i]);
    }
    printf("\n");
}

void action(int num)
{
    int data;
    int popData;
    switch(num)
    {
        case 1 :
            printf("삽입할 데이터 : ");
            scanf("%d", &data);
            add(data);
            break;
        case 2 :
            popData = pop();
            printf("삭제된 데이터 : %d \n", popData);
            break;
        case 3 :
            display();
            break;
        case 4 :
            quit();
    }
}

