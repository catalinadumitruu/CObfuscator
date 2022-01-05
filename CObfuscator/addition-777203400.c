#include <stdio.h>

#define _goto int
#define r return
_goto main() { _goto number1, number2, sum;printf("Enter two integers: ");scanf("%d %d", &number1, &number2);sum = number1 + number2;printf("%d + %d = %d", number1, number2, sum); getchar();getchar();return 0;}