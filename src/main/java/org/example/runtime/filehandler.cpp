#include <stdbool.h>
#include <stdio.h>
#include <stdlib.h>
#include <string>
#include <string.h>
#include "allocator/allocator.hpp"
#include "error/error.hpp"

using namespace std;

bool createFile(string filepath) {
    FILE* file = fopen(filepath.c_str(), "r");
    if (file != NULL) {
        fclose(file);
        runtimeError("Unable to create new file");
        return false;
    }
    file = fopen(filepath.c_str(), "w");
    if (file == NULL) {
        return false;
    }
    fclose(file);
    return true;
}

bool writeContentToFile(string filepath, string content) {
    FILE* file = fopen(filepath.c_str(), "w");
    if (file == NULL) {
        runtimeError("Unable to write to file");
        return false;
    }
    fprintf(file, content.c_str());
    fclose(file);
}

bool appendContentToFile(string filepath, string content) {
    FILE* file = fopen(filepath.c_str(), "a");
    if (file == NULL) {
        runtimeError("Unable to append content to file");
        return false;
    }
    fprintf(file, content.c_str());
    fclose(file);
    return true;
}

bool clearFile(string filepath) {
    FILE* file = fopen(filepath.c_str(), "w");
    if (file == NULL) {
        runtimeError("Unable to clear file");
        return false;
    }
    fprintf(file, "");
    fclose(file);
    return true;
}

bool doesFileExist(string filepath) {
    FILE* file = fopen(filepath.c_str(), "r");
    if (file) {
        fclose(file);
        return true;
    }
    return false;
}

string readFile(string filepath) {
    FILE* file = fopen(filepath.c_str(), "r");
    if (file == NULL) {
        runtimeError("Unable to read file");
        return "";
    }
    char buffer[1024];
    size_t totalRead = 0;
    size_t bufferSize = sizeof(buffer);
    char* content = (char*)allocateFromMarsik(bufferSize);
    content[0] = '\0';

    while (fgets(buffer, sizeof(buffer), file) != NULL) {
        size_t len = strlen(buffer);
        if (totalRead + len >= bufferSize) {
            bufferSize *= 2;
            char* newContent = (char*)allocateFromMarsik(bufferSize);
            content = newContent;
        }
        strcat(content, buffer);
        totalRead += len;
    }
    fclose(file);
    return " " + string(content);
}

bool deleteFile(string filepath) {
    return remove(filepath.c_str()) == 0;
}