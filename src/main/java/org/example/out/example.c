#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "string.h"
#include "../runtime/filehandler.h"
#include "../runtime/math.h"
#include "math.h"
#include "../runtime/datetime.h"
#include "../runtime/datastructures/array.h"
#include "../runtime/datastructures/list.h"
#include "stdint.h"


int main() {
  int a = 5;
uint8_t m = 254;
double power = pow(a,a);
const double pi = 3.141529;
string b = init("aa");
bool c = false;
double d = 5.67;
int age;
printf("Your age:");
scanf("%d", &age);
string t = now();
struct Array intArr = {(int[]){4,3,6,5,6}, sizeof(int), 5, INT};
struct Array arr = {(char[]){'a','b'}, sizeof(char), 2, CHAR};
array_set(&arr, 1, 'c');
char e = array_get(&arr, 0);
bool bb = array_contains(&arr, 'c');
struct List list1 = init_list(4, 3, 5, 4, 6, 4, 3, 5, 4, 6, 6);
list_add(&list1, 2);
list_removeDuplicateOf(&list1, 6);
string fileContent = readFile(&b);
if (e > gcd(5, 12)) {
e++;
}
 else {
e--;
}
for (int x = 0;
x < 5; x++) {
printf("%d", x);
}
int i = 0;
while (i < 5) {
if (isEven(i)) {
printf("%d", i + " is even");
}
i++;
}
string secret = init("banana");
appendChar(&secret, 'a');
string today = now();
if (isLeapYear(&today)) {
printf("this year is a leap year");
}
int zz;
zz = 3333;
zz = 32;

  return 0;
}
