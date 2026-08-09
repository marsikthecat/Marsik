#pragma once

#include <stdbool.h>
#include <string>

using namespace std;

bool str_stringEquals(string str1, string str2);

int str_hash(string str);

int str_stringLength(string str);

void str_setCharAt(string str, int pos, char c);

char str_getCharAt(string str, int pos);

int str_stringIndexOf(string str, char c);

int str_lastIndexOf(string str, char c);

bool str_stringContains(string str, char c);

int str_countOccurrence(string str, char c);

void str_reverseString(string str);

void str_append(string str, string other);

bool str_isPalindrome(string str);

int* str_alphabetIndexes(string str);

bool str_hasOnlyDigits(string str);

bool str_hasDigits(string str);

bool str_hasOnlyLetters(string str);

bool str_hasLetters(string str);

bool str_hasWhiteSpace(string str);

bool str_isAlphaNumeric(string str);

void str_capitalize(string str);

bool str_isLowercase(string str);

bool str_isUppercase(string str);

bool str_isWhiteSpace(string str);

int str_numberOfWhiteSpaces(string str);

int str_numberOfVowels(string str);

int str_numberOfConsonants(string str);