#pragma once

#include <stdbool.h>
#include <string>

using namespace std;

bool createFile(string filepath);

bool writeContentToFile(string filepath, string content);

bool appendContentToFile(string filepath, string content);

bool clearFile(string filepath);

bool doesFileExist(string filepath);

bool deleteFile(string filepath);

string readFile(string filepath);