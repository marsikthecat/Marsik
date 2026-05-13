#include <string.h>
#include "string.h"
#include <stdbool.h>
#include <ctype.h>
#include <stdlib.h>

bool isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

string init(const char chars[]) {
    string s;
    strncpy(s.data, chars, DEFAULT_STRING_SIZE - 1);
    s.data[DEFAULT_STRING_SIZE - 1] = '\0';
    s.length = strlen(s.data);
    return s;
}

bool stringEquals(string* str1, string* str2) {
    if (str1->length != str2->length) {
        return false;
    }
    return strcmp(str1->data, str2->data) == 0;
}

int stringLength(string* str) {
    return str->length;
}

void setCharAt(string* str, int pos, char c) {
    if (pos < str->length && pos >= 0) {
        str->data[pos] = c;
    }
}

char getCharAt(string* str, int pos) {
    if (pos < str->length && pos >= 0 ) {
        return str->data[pos];
    }
    return '.';
}

int stringIndexOf(string* str, char c) {
    for(int i = 0; i < str->length; i++) {
        if (str->data[i] == c) {
            return i;
        }
    }
    return -1;
}

int lastIndexOf(string* str, char c) {
    for(int i = str->length - 1; i >= 0; i--) {
        if (str->data[i] == c) {
            return i;
        }
    }
    return -1;
}

bool stringContains(string* str, char c) {
    for (int i = 0; i < str->length; i++) {
        if (str->data[i] == c) {
            return true;
        }
    }
    return false;
}

int countOccurrence(string* str, char c) {
    int occurrence = 0;
    for(int i = 0; i < str->length; i++) {
        if(str->data[i] == c) {
            occurrence++;
        }
    }
    return occurrence;
}

void reverseString(string* str) {
    char* content = str->data;
    int length = str->length;
    for(int i = 0; i < length/2; i++) {
        char tmp = content[i];
        content[i] = content[length - 1 - i];
        content[length - 1 - i] = tmp;
    }
}

void append(string* str, string* other) {
    if (str->length + other->length >= DEFAULT_STRING_SIZE - 1) {
        // Truncate if too long
        int copyLen = DEFAULT_STRING_SIZE - 1 - str->length;
        if (copyLen > 0) {
            strncat(str->data, other->data, copyLen);
            str->length += copyLen;
        }
    } else {
        strcat(str->data, other->data);
        str->length += other->length;
    }
}

void replacePart(string* str, int start, int finish, string* replacement) {
    if (start < 0 || finish > str->length || start >= finish) {
        return;
    }

    int replaceLen = finish - start;
    int newLen = str->length - replaceLen + replacement->length;

    if (newLen >= DEFAULT_STRING_SIZE) {
        return; // Too long
    }

    // Shift remaining characters
    memmove(str->data + start + replacement->length,
            str->data + finish,
            str->length - finish + 1); // +1 for null terminator

    // Copy replacement
    memcpy(str->data + start, replacement->data, replacement->length);
    str->length = newLen;
}

bool isPalindrome(string* str) {
    for(int i = 0; i < str->length / 2; i++) {
        if (str->data[i] != str->data[str->length - 1 - i]){
            return false;
        }
    }
    return true;
}

int* alphabetIndexes(string* str) {
    int* indexes = (int*)malloc(26 * sizeof(int));
    if (indexes == NULL) {
        return NULL;
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

bool hasOnlyDigits(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (!isdigit(str->data[i])) {
            return false;
        }
    }
    return true;
}

bool hasDigits(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (isdigit(str->data[i])) {
            return true;
        }
    }
    return false;
}

bool hasOnlyLetters(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (!isalpha(str->data[i])) {
            return false;
        }
    }
    return true;
}

bool hasLetters(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (isalpha(str->data[i])) {
            return true;
        }
    }
    return false;
}

bool hasWhiteSpace(string* str) {
    int count = 0;
    for (int i = 0; i < str->length; i++) {
      if (isblank(str->data[i])) {
        return true;
      }
    }
    return false;
}

bool isAlphaNumeric(string* str) {
    for(int i = 0; i < str->length; i++) {
        if (!isalnum(str->data[i])) {
            return false;
        }
    }
    return true;
}

void capitalize(string* str) {
    for(int i = 0; i < str->length; i++) {
        char temp = str->data[i];
        str->data[i] = toupper(temp);
    }
}


bool isLowercase(string* str) {
    for (int i = 0; i < str->length; i++) {
      if (isupper(str->data[i])) {
        return false;
      }
    }
    return true;
}

bool isUppercase(string* str) {
    for (int i = 0; i < str->length; i++) {
      if (islower(str->data[i])) {
        return false;
      }
    }
    return true;
}

bool isWhiteSpace(string* str) {
    for (int i = 0; i < str->length; i++) {
      if (!isblank(str->data[i])) {
        return false;
      }
    }
    return true;
}

int numberOfWhiteSpaces(string* str) {
    int count = 0;
    for (int i = 0; i < str->length; i++) {
      if (isblank(str->data[i])) {
        count++;
      }
    }
    return count;
}

int numberOfVowels(string* str) {
    int count = 0;
    for (int i = 0; i < str->length; i++) {
      if (isVowel(tolower(str->data[i]))) {
        count++;
      }
    }
    return count;
}

int numberOfConsonants(string* str) {
    int count = 0;
    for (int i = 0; i < str->length; i++) {
      if (!isVowel(tolower(str->data[i]))) {
        count++;
      }
    }
    return count;
}