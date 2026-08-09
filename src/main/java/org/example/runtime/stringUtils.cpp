#include <stdbool.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdio.h>
#include <string>
#include "allocator/allocator.hpp"

using namespace std;

bool isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

int str_hash(string str) {
    int s = 0x811C9DC5;
    for (size_t i = 0; i < str.length(); i++) {
      int c = (int)str[i];
      s ^= c;
      s *= 0x01000193;
      s = (s << 5) | (s >> 27);
    }
    return s;
}

bool str_stringEquals(string str1, string str2) {
    return str1 == str2;
}

int str_stringLength(string str) {
    return str.length();
}

void str_setCharAt(string str, int pos, char c) {
    str[pos] = c;
}

char str_getCharAt(string str, int pos) {
    return str[pos];
}

int str_stringIndexOf(string str, char c) {
    for(int i = 0; i < str.length(); i++) {
        if (str[i] == c) {
            return i;
        }
    }
    return -1;
}

int str_lastIndexOf(string str, char c) {
    for(int i = str.length() - 1; i >= 0; i--) {
        if (str[i] == c) {
            return i;
        }
    }
    return -1;
}

bool str_stringContains(string str, char c) {
    for (int i = 0; i < str.length(); i++) {
        if (str[i] == c) {
            return true;
        }
    }
    return false;
}

int str_countOccurrence(string str, char c) {
    int occurrence = 0;
    for (int i = 0; i < str.length(); i++) {
        if(str[i] == c) {
            occurrence++;
        }
    }
    return occurrence;
}

void str_reverseString(string str) {
    int length = str.length();
    for (int i = 0; i < length/2; i++) {
        char tmp = str[i];
        str[i] = str[length - 1 - i];
        str[length - 1 - i] = tmp;
    }
}

void str_append(string str, string other) {
    str.append(other);
}


bool str_isPalindrome(string str) {
    for(int i = 0; i < str.length() / 2; i++) {
        if (str[i] != str[str.length() - 1 - i]){
            return false;
        }
    }
    return true;
}

string str_alphabetIndexes(string str) {
    string indexes = "";
    for (int i = 0; i < str.length(); i++) {
        indexes[i] = -1;
    }
    for (int i = 0; i < str.length(); i++) {
        char c = tolower(str[i]);
        if (c >= 'a' && c <= 'z') {
            int index = c - 'a';
            if (indexes[index] == -1) {
                indexes[index] = i;
            }
        }
    }
    return indexes;
}

bool str_hasOnlyDigits(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (!isdigit(str[i])) {
            return false;
        }
    }
    return true;
}

bool str_hasDigits(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (isdigit(str[i])) {
            return true;
        }
    }
    return false;
}

bool str_hasOnlyLetters(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (!isalpha(str[i])) {
            return false;
        }
    }
    return true;
}

bool str_hasLetters(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (isalpha(str[i])) {
            return true;
        }
    }
    return false;
}

bool str_hasWhiteSpace(string str) {
    for (int i = 0; i < str.length(); i++) {
      if (isblank(str[i])) {
        return true;
      }
    }
    return false;
}

bool str_isAlphaNumeric(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (!isalnum(str[i])) {
            return false;
        }
    }
    return true;
}

void str_capitalize(string str) {
    for(int i = 0; i < str.length(); i++) {
        char temp = str[i];
        str[i] = toupper(temp);
    }
}


bool str_isLowercase(string str) {
    for (int i = 0; i < str.length(); i++) {
      if (isupper(str[i])) {
        return false;
      }
    }
    return true;
}

bool str_isUppercase(string str) {
    for (int i = 0; i < str.length(); i++) {
      if (islower(str[i])) {
        return false;
      }
    }
    return true;
}

bool str_isWhiteSpace(string str) {
    for (int i = 0; i < str.length(); i++) {
      if (!isblank(str[i])) {
        return false;
      }
    }
    return true;
}

int str_numberOfWhiteSpaces(string str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (isblank(str[i])) {
        count++;
      }
    }
    return count;
}

int str_numberOfVowels(string str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (isVowel(tolower(str[i]))) {
        count++;
      }
    }
    return count;
}

int str_numberOfConsonants(string str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (!isVowel(tolower(str[i]))) {
        count++;
      }
    }
    return count;
}