#ifndef DATETIME_H
#define DATETIME_H
#include <stdio.h>
#include <time.h>
#include "string.h"

struct datetime
{
    int year;
    int month;
    int day;
    int hour;
    int minute;
    int second;
} typedef datetime;

string now();

string currentDateISO();

long currentMillis();

int currentYear();

int currentMonth();

int currentDay();

int currentHour();

int currentMinute();

int currentSeconds();

datetime currentDateTime();

int getSeconds(datetime* dt);

int getMinutes(datetime* dt);

int getHours(datetime* dt);

int getDay(datetime* dt);

int getMonth(datetime* dt);

int getYear(datetime* dt);

int setSeconds(datetime *dt, int seconds);

int setMinutes(datetime *dt, int minutes);

int setHours(datetime *dt, int hours);

int setDay(datetime *dt, int day);

int setMonth(datetime *dt, int month);

int setYear(datetime *dt, int year);

int isLeapYear(int year);

bool isBefore(datetime* dt1, datetime* dt2);

bool isAfter(datetime* dt1, datetime* dt2);

string toIsoFormat(datetime* dt);

string monthName(int month);

string dayName(int day);

#endif