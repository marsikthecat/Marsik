#ifndef STRING_H
#define STRING_H
#include <stdbool.h>

#define DEFAULT_STRING_SIZE 16

typedef struct {
    char data[DEFAULT_STRING_SIZE];
    int length;
} string;

string init(const char str[]);

bool isEqual(string* str1, string* str2);

int stringLength(string* str);

void setCharAt(string* str, int pos, char c);

char getCharAt(string* str, int pos);

int stringIndexOf(string* str, char c);

int lastIndexOf(string* str, char c);

bool stringContains(string* str, char c);

int countOccurrence(string* str, char c);

void reverseString(string* str);

void append(string* str, string* other);

void replacePart(string* str, int start, int finish, string* replacement);

bool isPalindrome(string* str);

int* alphabetIndexes(string* str);

bool hasOnlyDigits(string* str);

bool hasDigits(string* str);

bool hasOnlyLetters(string* str);

bool hasLetters(string* str);

bool hasWhiteSpace(string* str);

bool isAlphaNumeric(string* str);

void capitalize(string* str);

bool isLowercase(string* str);

bool isUppercase(string* str);

bool isWhiteSpace(string* str);

int numberOfWhiteSpaces(string* str);

int numberOfVowels(string* str);

int numberOfConsonants(string* str);

#endif