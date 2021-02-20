#include <iostream>
//code by Pyro! Thx
using namespace std;

void call_by_reference(int &a, int &b) {
    int temp = a;
    a = b;
    b = temp;
}

void call_by_address(int *a, int *b) {
    int temp = *a;
    *a = *b;
    *b = temp;
}

void call_by_value(int a, int b) {
    int temp = a;
    a = b;
    b = temp;
}

int main() {
    int a_1 = 3;
    int b_1 = 7;

    int a_2 = 3;
    int b_2 = 7;

    int a_3 = 3;
    int b_3 = 7;

    call_by_reference(a_1, b_1);
    call_by_address(&a_2, &b_2);
    call_by_value(a_3, b_3);

    printf("%d %d\n", a_1, b_1);
    printf("%d %d\n", a_2, b_2);
    printf("%d %d\n", a_3, b_3);
    return 0;
}

