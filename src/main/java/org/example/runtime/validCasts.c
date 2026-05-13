#include "validCasts.h"
#include <stdio.h>

double intToDouble(int num) {
    return (double) num;
}

char intToChar(int num) {
    return (char) num;
}

string intToString(int num) {
    char buffer[32];
    snprintf(buffer, sizeof(buffer), "%d", num);
    return init(buffer);
}

string booleanToString(bool boolean) {
    return init(boolean ? "true" : "false");
}

int doubleToInt(double num) {
    return (int) num;
}

string doubleToString(double num) {
    char buffer[64];
    snprintf(buffer, sizeof(buffer), "%.6f", num);
    return init(buffer);
}

int stringToInt(string str) {
    return atoi(str.data);
}

bool stringToBoolean(string str) {
    return strcmp(str.data, "true") == 0 || strcmp(str.data, "1") == 0;
}

double stringToDouble(string str) {
    return atof(str.data);
}