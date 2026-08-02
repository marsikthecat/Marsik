#include "string.hpp"
#include <stdbool.h>
#include <ctype.h>
#include <stdlib.h>
#include <stdio.h>
#include <cstring>
#include "allocator/allocator.hpp"

bool isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
}

string str_init(const char chars[]) {
    string s;
    int initLength = strlen(chars);
    if (initLength <= DEFAULT_STRING_SIZE) {
      strncpy(s.data, chars, DEFAULT_STRING_SIZE - 1);
      s.data[DEFAULT_STRING_SIZE - 1] = '\0';
      s.mallocData = NULL;
    } else {
      s.mallocData = (char*)allocateFromMarsik(initLength);
      strncpy(s.mallocData, chars, initLength - 1);
      s.mallocData[initLength - 1] = '\0';
      s.data[0] = '\0';
    }
    s.length = initLength;
    return s;
}

int str_hash(string* str) {
    char* content = str->data[0] == '\0' ? str->mallocData : str->data;
    int s = 0x811C9DC5;
    for (int i = 0; i < str->length; i++) {
      int c = (int)content[i];
      s ^= c;
      s *= 0x01000193;
      s = (s << 5) | (s >> 27);
    }
    return s;
}

void str_printString(string* str) {
    if (str->data[0] == '\0') {
        printf("%s\n", str->mallocData);
    } else {
        printf("%s\n", str->data);
    }
}

bool str_stringEquals(string* str1, string str2) {
    if (str1->length != str2.length) {
        return false;
    }
    return strcmp(str1->data, str2.data) == 0;
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

void str_append(string* str, string other) {
    char* otherData = other.mallocData == NULL ? other.data : other.mallocData;
    if (str->mallocData == NULL) {
        if (str->length + other.length < str->capacity - 1) {
            strcat(str->data, otherData);
            str->length += other.length;
            return;
        } else {
            size_t newCapacity = (str->length + other.length + 1) * 2;
            str->mallocData = (char*)allocateFromMarsik(newCapacity);
            strcpy(str->mallocData, str->data);
            strcat(str->mallocData, otherData);
            str->capacity = newCapacity;
            str->length += other.length;
            str->data[0] = '\0';
        }
    } else {
        if (str->length + other.length < str->capacity - 1) {
            strcat(str->mallocData, otherData);
            str->length += other.length;
            str->mallocData[str->length] = '\0';
            return;
        } else {
            size_t newCapacity = (str->length + other.length + 1) * 2;
            char* temp = str->mallocData;
            str->mallocData = (char*)allocateFromMarsik(newCapacity);
            strcpy(str->mallocData, temp);
            strcat(str->mallocData, otherData);
            str->capacity = newCapacity;
            str->length += other.length;
            str->mallocData[str->length] = '\0';
        }
    }
}

void str_appendChar(string* str, char c) {
    if (str->mallocData == NULL) {
        if (str->length < str->capacity - 1) {
            str->data[str->length++] = c;
            str->data[str->length] = '\0';
            return;
        } else {
            size_t newCapacity = str->length * 2;
            str->mallocData = (char*)allocateFromMarsik(newCapacity);
            str->capacity = newCapacity;
            strcpy(str->mallocData, str->data);
            str->mallocData[str->length++] = c;
            str->mallocData[str->length] = '\0';
            str->data[0] = '\0';
        }
    } else {
        if (str->length < str->capacity - 1) {
            str->mallocData[str->length++] = c;
            str->mallocData[str->length] = '\0';
            return;
        } else {
            size_t newCapacity = str->length * 2;
            char* temp = str->mallocData;
            str->mallocData = (char*)allocateFromMarsik(newCapacity);
            str->capacity = newCapacity;
            strcpy(str->mallocData, temp);
            str->mallocData[str->length++] = c;
            str->mallocData[str->length] = '\0';
        }
    }
}

void str_replacePart(string* str, int start, int finish, string replacement) {
    if (start < 0 || finish > str->length || start >= finish) {
        return;
    }
    int replaceLen = finish - start;
    int newLen = str->length - replaceLen + replacement.length;

    if (newLen >= DEFAULT_STRING_SIZE) {
        return;
    }
    memmove(str->data + start + replacement.length,
            str->data + finish,
            str->length - finish + 1);
    memcpy(str->data + start, replacement.data, replacement.length);
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
    int* indexes = (int*)allocateFromMarsik(26 * sizeof(int));
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