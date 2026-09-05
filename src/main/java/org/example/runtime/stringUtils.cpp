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

int string_hash(string str) {
    int s = 0x811C9DC5;
    for (size_t i = 0; i < str.length(); i++) {
      int c = (int)str[i];
      s ^= c;
      s *= 0x01000193;
      s = (s << 5) | (s >> 27);
    }
    return s;
}

bool string_equals(string str1, string str2) {
    return str1 == str2;
}

int string_length(string str) {
    return str.length();
}

void string_setCharAt(string str, int pos, char c) {
    str[pos] = c;
}

char string_getCharAt(string str, int pos) {
    return str[pos];
}

int string_indexOf(string str, char c) {
    for(int i = 0; i < str.length(); i++) {
        if (str[i] == c) {
            return i;
        }
    }
    return -1;
}

int string_lastIndexOf(string str, char c) {
    for(int i = str.length() - 1; i >= 0; i--) {
        if (str[i] == c) {
            return i;
        }
    }
    return -1;
}

bool string_contains(string str, char c) {
    for (int i = 0; i < str.length(); i++) {
        if (str[i] == c) {
            return true;
        }
    }
    return false;
}

int string_countOccurrence(string str, char c) {
    int occurrence = 0;
    for (int i = 0; i < str.length(); i++) {
        if(str[i] == c) {
            occurrence++;
        }
    }
    return occurrence;
}

void string_reverse(string str) {
    int length = str.length();
    for (int i = 0; i < length/2; i++) {
        char tmp = str[i];
        str[i] = str[length - 1 - i];
        str[length - 1 - i] = tmp;
    }
}

string string_substring(string str, int start, int end) {
    if (start < 0 || end > str.length() || start > end) {
        return "";
    }
    return str.substr(start, end - start);
}

void string_append(string str, string other) {
    str.append(other);
}

string string_toUpperCase(string str) {
    for(int i = 0; i < str.length(); i++) {
        char temp = str[i];
        str[i] = toupper(temp);
    }
    return str;
}

string string_toLowerCase(string str) {
    for(int i = 0; i < str.length(); i++) {
        char temp = str[i];
        str[i] = tolower(temp);
    }
    return str;
}

bool string_startsWith(string str, string prefix) {
    if (prefix.length() > str.length()) {
        return false;
    }
    for (int i = 0; i < prefix.length(); i++) {
        if (str[i] != prefix[i]) {
            return false;
        }
    }
    return true;
}

bool string_endsWith(string str, string suffix) {
    int suffixLength = suffix.length();
    int strLength = str.length();
    if (suffixLength > strLength) {
        return false;
    }
    for (int i = 0; i < suffixLength; i++) {
        if (str[strLength - suffixLength + i] != suffix[i]) {
            return false;
        }
    }
    return true;
}

bool string_isPalindrome(string str) {
    for(int i = 0; i < str.length() / 2; i++) {
        if (str[i] != str[str.length() - 1 - i]){
            return false;
        }
    }
    return true;
}

string string_alphabetIndexes(string str) {
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

bool string_hasOnlyDigits(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (!isdigit(str[i])) {
            return false;
        }
    }
    return true;
}

bool string_hasDigits(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (isdigit(str[i])) {
            return true;
        }
    }
    return false;
}

bool string_hasOnlyLetters(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (!isalpha(str[i])) {
            return false;
        }
    }
    return true;
}

bool string_hasLetters(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (isalpha(str[i])) {
            return true;
        }
    }
    return false;
}

bool string_hasWhiteSpace(string str) {
    for (int i = 0; i < str.length(); i++) {
      if (isblank(str[i])) {
        return true;
      }
    }
    return false;
}

bool string_isAlphaNumeric(string str) {
    for(int i = 0; i < str.length(); i++) {
        if (!isalnum(str[i])) {
            return false;
        }
    }
    return true;
}

void string_capitalize(string str) {
    for(int i = 0; i < str.length(); i++) {
        char temp = str[i];
        str[i] = toupper(temp);
    }
}


bool string_isLowercase(string str) {
    for (int i = 0; i < str.length(); i++) {
      if (isupper(str[i])) {
        return false;
      }
    }
    return true;
}

bool string_isUppercase(string str) {
    for (int i = 0; i < str.length(); i++) {
      if (islower(str[i])) {
        return false;
      }
    }
    return true;
}

bool string_isWhiteSpace(string str) {
    for (int i = 0; i < str.length(); i++) {
      if (!isblank(str[i])) {
        return false;
      }
    }
    return true;
}

int string_numberOfWhiteSpaces(string str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (isblank(str[i])) {
        count++;
      }
    }
    return count;
}

int string_numberOfVowels(string str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (isVowel(tolower(str[i]))) {
        count++;
      }
    }
    return count;
}

int string_numberOfConsonants(string str) {
    int count = 0;
    for (int i = 0; i < str.length(); i++) {
      if (!isVowel(tolower(str[i]))) {
        count++;
      }
    }
    return count;
}