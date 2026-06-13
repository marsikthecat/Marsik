#include <stdio.h>
#include <time.h>
#include "string.hpp"
#include "datetime.hpp"
#include "error/error.hpp"

string now() {
    time_t currentTime;
    time(&currentTime);
    return str_init(ctime(&currentTime));
}

string currentDateISO() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    char buffer[100];
    strftime(buffer, sizeof(buffer), "%d-%m-%Y %H:%M:%S", t);
    return str_init(buffer);
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

datetime currentDateTime() {
    time_t now = time(NULL);
    struct tm *t = localtime(&now);
    datetime dt;
    dt.year = t->tm_year + 1900;
    dt.month = t->tm_mon + 1;
    dt.day = t->tm_mday;
    dt.hour = t->tm_hour;
    dt.minute = t->tm_min;
    dt.second = t->tm_sec;
    return dt;
}

int getSeconds(datetime* dt) {
    return dt->second;
}

int getMinutes(datetime* dt) {
    return dt->minute;
}

int getHours(datetime* dt) {
    return dt->hour;
}

int getDay(datetime* dt) {
    return dt->day;
}

int getMonth(datetime* dt) {
    return dt->month;
}

int getYear(datetime* dt) {
    return dt->year;
}

void setSeconds(datetime *dt, int seconds) {
    if (seconds < 0 || seconds > 59) {
        runtimeError("Invalid number of seconds");
        return;
    }
    dt->second = seconds;
}

void setMinutes(datetime *dt, int minutes) {
    if (minutes < 0 || minutes > 59) {
        runtimeError("Invalid number of minutes");
        return;
    }
    dt->minute = minutes;
}

void setHours(datetime *dt, int hours) {
    if (hours < 0 || hours > 23) {
        runtimeError("Invalid number of hours");
        return;
    }
    dt->hour = hours;
}

void setDay(datetime *dt, int day) {
    if (day < 1 || day > 31) {
        runtimeError("Invalid number of days");
        return;
    }
    dt->day = day;
}

void setMonth(datetime *dt, int month) {
    if (month < 1 || month > 12) {
        runtimeError("Invalid number of months");
        return;
    }
    dt->month = month;
}

void setYear(datetime *dt, int year) {
    if (year < 1900 || year > 2100) {
        runtimeError("Years out of range for Marsik the year-cat");
        return;
    }
    dt->year = year;
}

bool isBefore(datetime* dt1, datetime* dt2) {
    if (dt1->year < dt2->year) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month < dt2->month) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month == dt2->month && dt1->day < dt2->day) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month == dt2->month
         && dt1->day == dt2->day && dt1->hour < dt2->hour) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month == dt2->month
         && dt1->day == dt2->day && dt1->hour == dt2->hour && dt1->minute < dt2->minute) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month == dt2->month
         && dt1->day == dt2->day && dt1->hour == dt2->hour && dt1->minute == dt2->minute
         &&	dt1->second < dt2->second) {
        return true;
    }
    return false;
}

bool isAfter(datetime* dt1, datetime* dt2) {
    if (dt1->year > dt2->year) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month > dt2->month) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month == dt2->month && dt1->day > dt2->day) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month == dt2->month
        && dt1->day == dt2->day && dt1->hour > dt2->hour) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month == dt2->month
        && dt1->day == dt2->day && dt1->hour == dt2->hour && dt1->minute > dt2->minute) {
        return true;
    }
    if (dt1->year == dt2->year && dt1->month == dt2->month
         && dt1->day == dt2->day && dt1->hour == dt2->hour && dt1->minute == dt2->minute
         &&	dt1->second > dt2->second) {
        return true;
    }
    return false;
}

bool isLeapYear(int year) {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
}

string toIsoFormat(datetime* dt) {
    char buffer[100];
    snprintf(buffer, sizeof(buffer), "%04d-%02d-%02dT%02d:%02d:%02d",
             dt->year, dt->month, dt->day, dt->hour, dt->minute, dt->second);
    return str_init(buffer);
}

string monthName(int month) {
    const char *months[] = {"January", "February", "March", "April", "May", "June",
                            "July", "August", "September", "October", "November", "December"};
    if (month < 1 || month > 12) {
        runtimeError("Invalid month");
        return str_init("");
    }
    return str_init(months[month - 1]);
}

string dayName(int day) {
    const char *days[] = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    if (day < 1 || day > 7) {
        runtimeError("Invalid day");
        return str_init("");
    }
    return str_init(days[day - 1]);
}