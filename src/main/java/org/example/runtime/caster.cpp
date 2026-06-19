#include "caster.hpp"
#include "string.hpp"
#include <cstring>
#include <cstdio>
#include <cstdlib>

double intToDouble(const int& num) {
    return (double) num;
}

char intToChar(const int& num) {
    return (char) num;
}

string intToString(const int& num) {
    char buffer[32];
    snprintf(buffer, sizeof(buffer), "%d", num);
    return str_init(buffer);
}

string booleanToString(const bool& boolean) {
    return str_init(boolean ? "true" : "false");
}

int doubleToInt(const double& num) {
    return (int) num;
}

string doubleToString(const double& num) {
    char buffer[64];
    snprintf(buffer, sizeof(buffer), "%.6f", num);
    return str_init(buffer);
}

int stringToInt(string* str) {
    return atoi(str->data);
}

bool stringToBoolean(string* str) {
    return strcmp(str->data, "true") == 0 || strcmp(str->data, "1") == 0;
}

double stringToDouble(string* str) {
    return atof(str->data);
}

int booleanToInt(const bool& boolean) {
    return boolean ? 1 : 0;
}

bool intToBoolean(const int& num) {
    return num != 0;
}