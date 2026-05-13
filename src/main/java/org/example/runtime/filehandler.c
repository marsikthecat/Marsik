#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "string.h"

bool createFile(string* filepath) {
    FILE* file = fopen(filepath->data, "r");
    if (file != NULL) {
        fclose(file);
        return false;
    }
    file = fopen(filepath->data, "w");
    if (file == NULL) {
        return false;
    }
    fclose(file);
    return true;
}

bool writeContentToFile(string* filepath, string* content) {
    FILE* file = fopen(filepath->data, "w");
    if (file == NULL) {
        return false;
    }
    fprintf(file, content->data);
    fclose(file);
}

bool appendContentToFile(string* filepath, string* content) {
    FILE* file = fopen(filepath->data, "a");
    if (file == NULL) {
        return false;
    }
    fprintf(file, content->data);
    fclose(file);
    return true;
}

bool clearFile(string* filepath) {
    FILE* file = fopen(filepath->data, "w");
    if (file == NULL) {
        return false;
    }
    fprintf(file, "");
    fclose(file);
    return true;
}

bool doesFileExist(string* filepath) {
    FILE* file = fopen(filepath->data, "r");
    if (file) {
        fclose(file);
        return true;
    }
    return false;
}

string readFile(string* filepath) {
    FILE* file = fopen(filepath->data, "r");
    if (file == NULL) {
        return init("");
    }

    char buffer[1024];
    size_t totalRead = 0;
    size_t bufferSize = sizeof(buffer);
    char* content = (char*)malloc(bufferSize);

    if (content == NULL) {
        fclose(file);
        return init("");
    }

    content[0] = '\0';

    while (fgets(buffer, sizeof(buffer), file) != NULL) {
        size_t len = strlen(buffer);
        if (totalRead + len >= bufferSize) {
            bufferSize *= 2;
            char* newContent = (char*)realloc(content, bufferSize);
            if (newContent == NULL) {
                free(content);
                fclose(file);
                return init("");
            }
            content = newContent;
        }
        strcat(content, buffer);
        totalRead += len;
    }

    fclose(file);
    string result = init(content);
    free(content);
    return result;
}

bool deleteFile(string* filepath) {
    return remove(filepath->data) == 0;
}