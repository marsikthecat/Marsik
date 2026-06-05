#include "string.hpp"
#include <stdbool.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdio.h>
#include <cstring>

bool isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

string str_init(const char chars[]) {
    string s;
    strncpy(s.data, chars, DEFAULT_STRING_SIZE - 1);
    s.data[DEFAULT_STRING_SIZE - 1] = '\0';
    s.length = strlen(s.data);
    return s;
}

bool str_stringEquals(string* str1, string* str2) {
    if (str1->length != str2->length) {
        return false;
    }
    return strcmp(str1->data, str2->data) == 0;
}

int str_stringLength(string* str) {
    return str->length;
}

void str_setCharAt(string* str, int pos, char c) {
    if (pos < str->length && pos >= 0) {
        str->data[pos] = c;
    }
}

char str_getCharAt(string* str, int pos) {
    if (pos < str->length && pos >= 0 ) {
        return str->data[pos];
    }
    return '.';
}

int str_stringIndexOf(string* str, char c) {
    for(int i = 0; i < str->length; i++) {
        if (str->data[i] == c) {
            return i;
        }
    }
    return -1;
}

int str_lastIndexOf(string* str, char c) {
    for(int i = str->length - 1; i >= 0; i--) {
        if (str->data[i] == c) {
            return i;
        }
    }
    return -1;
}

bool str_stringContains(string* str, char c) {
    for (int i = 0; i < str->length; i++) {
        if (str->data[i] == c) {
            return true;
        }
    }
    return false;
}

int str_countOccurrence(string* str, char c) {
    int occurrence = 0;
    for (int i = 0; i < str->length; i++) {
        if(str->data[i] == c) {
            occurrence++;
        }
    }
    return occurrence;
}

void str_reverseString(string* str) {
    char* content = str->data;
    int length = str->length;
    for (int i = 0; i < length/2; i++) {
        char tmp = content[i];
        content[i] = content[length - 1 - i];
        content[length - 1 - i] = tmp;
    }
}

void str_append(string* str, string* other) {
    if (str->length + other->length >= DEFAULT_STRING_SIZE - 1) {
        str->mallocData = (char*)malloc((str->length + other->length + 1) * sizeof(char));
        if (str->mallocData == NULL) {
            fprintf(stderr, "FATAL ERROR: Out of memory\n");
            exit(1);
        }
        strcpy(str->mallocData, str->data);
        strcat(str->mallocData, other->data);
        str->length += other->length;
        str->data[0] = '\0';
    } else {
        strcat(str->data, other->data);
        str->length += other->length;
    }
}

void str_appendChar(string* str, char c) {
    if (str->length < DEFAULT_STRING_SIZE - 1) {
        str->data[str->length] = c;
        str->length++;
        str->data[str->length] = '\0';
    } else {
        str->mallocData = (char*)malloc((str->length + 2) * sizeof(char));
        if (str->mallocData == NULL) {
            fprintf(stderr, "FATAL ERROR: Out of memory\n");
            exit(1);
        }
        strcpy(str->mallocData, str->data);
        str->mallocData[str->length] = c;
        str->mallocData[str->length + 1] = '\0';
        str->length++;
        str->data[0] = '\0';
    }
}

void str_replacePart(string* str, int start, int finish, string* replacement) {
    if (start < 0 || finish > str->length || start >= finish) {
        return;
    }
    int replaceLen = finish - start;
    int newLen = str->length - replaceLen + replacement->length;

    if (newLen >= DEFAULT_STRING_SIZE) {
        return;
    }
    // Shift remaining characters
    memmove(str->data + start + replacement->length,
            str->data + finish,
            str->length - finish + 1);
    // Copy replacement
    memcpy(str->data + start, replacement->data, replacement->length);
    str->length = newLen;
}

bool str_isPalindrome(string* str) {
    for(int i = 0; i < str->length / 2; i++) {
        if (str->data[i] != str->data[str->length - 1 - i]){
            return false;
        }
    }
    return true;
}

int* str_alphabetIndexes(string* str) {
    int* indexes = (int*)malloc(26 * sizeof(int));
    if (indexes == NULL) {
        fprintf(stderr, "FATAL ERROR: Out of memory\n");
        exit(1);
    }
    for (int i = 0; i < 26; i++) {
        indexes[i] = -1;
    }
    for (int i = 0; i < str->length; i++) {
        char c = tolower(str->data[i]);
        if (c >= 'a' && c <= 'z') {
            int index = c - 'a';
            if (indexes[index] == -1) {
                indexes[index] = i;
            }
        }
    }
    return indexes;
}

bool str_hasOnlyDigits(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (!isdigit(str->data[i])) {
            return false;
        }
    }
    return true;
}

bool str_hasDigits(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (isdigit(str->data[i])) {
            return true;
        }
    }
    return false;
}

bool str_hasOnlyLetters(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (!isalpha(str->data[i])) {
            return false;
        }
    }
    return true;
}

bool str_hasLetters(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (isalpha(str->data[i])) {
            return true;
        }
    }
    return false;
}

bool str_hasWhiteSpace(string* str) {
    int count = 0;
    for (int i = 0; i < str->length; i++) {
      if (isblank(str->data[i])) {
        return true;
      }
    }
    return false;
}

bool str_isAlphaNumeric(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (!isalnum(str->data[i])) {
            return false;
        }
    }
    return true;
}

void str_capitalize(string* str) {
    for(int i = 0; i < str->length; i++) {
        char temp = str->data[i];
        str->data[i] = toupper(temp);
    }
}


bool str_isLowercase(string* str) {
    for (int i = 0; i < str->length; i++) {
      if (isupper(str->data[i])) {
        return false;
      }
    }
    return true;
}

bool str_isUppercase(string* str) {
    for (int i = 0; i < str->length; i++) {
      if (islower(str->data[i])) {
        return false;
      }
    }
    return true;
}

bool str_isWhiteSpace(string* str) {
    for (int i = 0; i < str->length; i++) {
      if (!isblank(str->data[i])) {
        return false;
      }
    }
    return true;
}

int str_numberOfWhiteSpaces(string* str) {
    int count = 0;
    for (int i = 0; i < str->length; i++) {
      if (isblank(str->data[i])) {
        count++;
      }
    }
    return count;
}

int str_numberOfVowels(string* str) {
    int count = 0;
    for (int i = 0; i < str->length; i++) {
      if (isVowel(tolower(str->data[i]))) {
        count++;
      }
    }
    return count;
}

int str_numberOfConsonants(string* str) {
    int count = 0;
    for (int i = 0; i < str->length; i++) {
      if (!isVowel(tolower(str->data[i]))) {
        count++;
      }
    }
    return count;
}