#include "caster.hpp"
#include <string>
#include <cstring>
#include <cstdio>
#include <cstdlib>

using namespace std;

double intToDouble(const int& num) {
    return (double) num;
}

char intToChar(const int& num) {
    return (char) num;
}

string intToString(const int& num) {
    char buffer[32];
    snprintf(buffer, sizeof(buffer), "%d", num);
    return string(buffer);
}

string booleanToString(const bool& boolean) {
    return boolean ? "true" : "false";
}

int doubleToInt(const double& num) {
    return (int) num;
}

string doubleToString(const double& num) {
    char buffer[64];
    snprintf(buffer, sizeof(buffer), "%.6f", num);
    return string(buffer);
}

int stringToInt(string str) {
    return atoi(str.c_str());
}

bool stringToBoolean(string str) {
    return str == "true" || str == "1";
}

double stringToDouble(string str) {
    return atof(str.c_str());
}

int booleanToInt(const bool& boolean) {
    return boolean ? 1 : 0;
}

bool intToBoolean(const int& num) {
    return num != 0;
}