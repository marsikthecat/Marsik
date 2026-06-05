#include "validCasts.hpp"
#include "string.hpp"
#include <cstring>
#include <cstdio>
#include <cstdlib>

double intToDouble(int num) {
    return (double) num;
}

char intToChar(int num) {
    return (char) num;
}

string intToString(int num) {
    char buffer[32];
    std::snprintf(buffer, sizeof(buffer), "%d", num);
    return str_init(buffer);
}

string booleanToString(bool boolean) {
    return str_init(boolean ? "true" : "false");
}

int doubleToInt(double num) {
    return (int) num;
}

string doubleToString(double num) {
    char buffer[64];
    std::snprintf(buffer, sizeof(buffer), "%.6f", num);
    return str_init(buffer);
}

int stringToInt(string str) {
    return std::atoi(str.data);
}

bool stringToBoolean(string str) {
    return std::strcmp(str.data, "true") == 0 || std::strcmp(str.data, "1") == 0;
}

double stringToDouble(string str) {
    return std::atof(str.data);
}

int booleanToInt(bool boolean) {
    return boolean ? 1 : 0;
}

bool intToBoolean(int num) {
    return num != 0;
}