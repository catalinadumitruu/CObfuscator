#include <stdio.h>

int main()
{
    char name[20];
    printf("Your name: ");
    scanf("%s", name);
    printf("Hello, %s!", name);
    getchar();
    return 0;
}