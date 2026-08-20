#pragma once

#include <stdio.h>
#include <time.h>
#include <string>

using namespace std;

string now();

long currentMillis();

int currentYear();

int currentMonth();

int currentDay();

int currentDayOfWeek();

int currentHour();

int currentMinute();

int currentSeconds();

string currentDateTime();

int getSeconds(string dt);

int getMinutes(string dt);

int getHours(string dt);

int getDay(string dt);

int getMonth(string dt);

int getYear(string dt);

void setSeconds(string dt, int seconds);

void setMinutes(string dt, int minutes);

void setHours(string dt, int hours);

void setDay(string dt, int day);

void setMonth(string dt, int month);

void setYear(string dt, int year);

bool isLeapYear(int year);

bool isBefore(string dt1, string dt2);

bool isAfter(string dt1, string dt2);

string monthName(int month);

string getCurrentMonthName();

string dayName(int day);

string getCurrentDayName();