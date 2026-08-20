#include <stdio.h>
#include <time.h>
#include <string>
#include "datetime.hpp"
#include "error/error.hpp"

using namespace std;

string now() {
    time_t currentTime;
    time(&currentTime);
    return string(ctime(&currentTime));
}

string currentDateTime() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    char buffer[20];
    strftime(buffer, sizeof(buffer), "%d-%m-%Y %H:%M:%S", t);
    return string(buffer);
}

long currentMillis() {
    return (long)(time(NULL) * 1000);
}

int currentYear() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    return t->tm_year + 1900;
}

int currentMonth() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    return t->tm_mon + 1;
}

int currentDay() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    return t->tm_mday;
}

int currentDayOfWeek() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    return t->tm_wday + 1;
}

int currentHour() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    return t->tm_hour;
}

int currentMinute() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    return t->tm_min;
}

int currentSeconds() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    return t->tm_sec;
}

int getSeconds(string dt) {
    return stoi(dt.substr(17, 2));
}

int getMinutes(string dt) {
    return stoi(dt.substr(14, 2));
}

int getHours(string dt) {
    return stoi(dt.substr(11, 2));
}

int getDay(string dt) {
    return stoi(dt.substr(8, 2));
}

int getMonth(string dt) {
    return stoi(dt.substr(5, 2));
}

int getYear(string dt) {
    return stoi(dt.substr(0, 4));
}

void setSeconds(string dt, int seconds) {
    if (seconds < 0 || seconds > 59) {
        runtimeError("Invalid number of seconds");
        return;
    }
    dt[17] = '0' + seconds / 10;
    dt[18] = '0' + seconds % 10;
}

void setMinutes(string dt, int minutes) {
    if (minutes < 0 || minutes > 59) {
        runtimeError("Invalid number of minutes");
        return;
    }
    dt[14] = '0' + minutes / 10;
    dt[15] = '0' + minutes % 10;
}

void setHours(string dt, int hours) {
    if (hours < 0 || hours > 23) {
        runtimeError("Invalid number of hours");
        return;
    }
    dt[11] = '0' + hours / 10;
    dt[12] = '0' + hours % 10;
}

void setDay(string dt, int day) {
    if (day < 1 || day > 31) {
        runtimeError("Invalid number of days");
        return;
    }
    dt[8] = '0' + day / 10;
    dt[9] = '0' + day % 10;
}

void setMonth(string dt, int month) {
    if (month < 1 || month > 12) {
        runtimeError("Invalid number of months");
        return;
    }
    dt[5] = '0' + month / 10;
    dt[6] = '0' + month % 10;
}

void setYear(string dt, int year) {
    if (year < 1900 || year > 2100) {
        runtimeError("Years out of range for Marsik the year-cat");
        return;
    }
    dt[0] = '0' + year / 1000;
    dt[1] = '0' + (year / 100) % 10;
    dt[2] = '0' + (year / 10) % 10;
    dt[3] = '0' + year % 10;
}

bool isBefore(string dt1, string dt2) {
    return dt1 < dt2;
}

bool isAfter(string dt1, string dt2) {
    return dt1 > dt2;
}

bool isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}

string toGermanFormat(string isoDateTime) {
    char buffer[20];
    snprintf(buffer, sizeof(buffer), "%02d.%02d.%04d %02d:%02d:%02d",
            getDay(isoDateTime), getMonth(isoDateTime), getYear(isoDateTime),
            getHours(isoDateTime), getMinutes(isoDateTime), getSeconds(isoDateTime));
    return string(buffer);
}

string toIsoUtcFormat(string isoDateTime) {
    char buffer[20];
    snprintf(buffer, sizeof(buffer), "%04d-%02d-%02dT%02d:%02d:%02dZ",
            getYear(isoDateTime), getMonth(isoDateTime), getDay(isoDateTime),
            getHours(isoDateTime), getMinutes(isoDateTime), getSeconds(isoDateTime));
    return string(buffer);
}

string monthName(int month) {
    const string months[] = {"January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"};
    if (month < 1 || month > 12) {
        runtimeError("Invalid month");
        return string("");
    }
    return months[month - 1];
}

string getCurrentMonthName() {
    int month = currentMonth();
    return monthName(month);
}

string dayName(int dayOfWeek) {
    const string days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    if (dayOfWeek < 1 || dayOfWeek > 7) {
        runtimeError("Invalid day");
        return string("");
    }
    return days[dayOfWeek - 1];
}

string getCurrentDayName() {
    int day = currentDayOfWeek();
    return dayName(day);
}