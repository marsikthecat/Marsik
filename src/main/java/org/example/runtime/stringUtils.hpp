#pragma once

#include <stdbool.h>
#include <string>

using namespace std;

bool string_equals(string str1, string str2);

int string_hash(string str);

int string_length(string str);

void string_setCharAt(string str, int pos, char c);

char string_getCharAt(string str, int pos);

int string_indexOf(string str, char c);

int string_lastIndexOf(string str, char c);

bool string_contains(string str, char c);

int string_countOccurrence(string str, char c);

void string_reverse(string str);

string string_substring(string str, int start, int end);

void string_append(string str, string other);

string string_toUpperCase(string str);

string string_toLowerCase(string str);

bool string_startsWith(string str, string prefix);

bool string_endsWith(string str, string suffix);

bool string_isPalindrome(string str);

string string_alphabetIndexes(string str);

bool string_hasOnlyDigits(string str);

bool string_hasDigits(string str);

bool string_hasOnlyLetters(string str);

bool string_hasLetters(string str);

bool string_hasWhiteSpace(string str);

bool string_isAlphaNumeric(string str);

void string_capitalize(string str);

bool string_isLowercase(string str);

bool string_isUppercase(string str);

bool string_isWhiteSpace(string str);

int string_numberOfWhiteSpaces(string str);

int string_numberOfVowels(string str);

int string_numberOfConsonants(string str);