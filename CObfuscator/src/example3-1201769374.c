
#include <stdio.h>
#define _goto int
#define r return
#define _____ char
#define ___goto void
#define _999 0;}
#define _888_ 1,
#define _777 2,
#define _99_ 3
#define _0_0 4
#define _555 5,
#define __9 100,
#define _090__ 10,
#define ____9_1 20,
#define n9__9 2000
#define ___ main(){
#define _ sum
#define __________ getch();
#define __________________ max
#define if_then name);
#define __ i
#define exit_ largest
#define goup return
#define ____________________________ cost
#define a for
#define COINS 9
#define MAX 20
_goto coins[COINS] = { _888_ _777 _555 _090__ 20,50, __9 200, n9__9 };void findMin(int cost){ _goto coinList[MAX] = { 0 }; _goto i, k = 0; a (i = COINS - 1; __ >= 0; i--) {  while (cost >= coins[i]) {cost -= coins[i];coinList[k++] = coins[i];  } } a (i = 0; __ < k; i++) {  printf("%d ", coinList[i]); } return;}int main(void){ _goto n = 93; printf("Following is minimal number"  "of change a %d: ",  n); findMin(n); r _999