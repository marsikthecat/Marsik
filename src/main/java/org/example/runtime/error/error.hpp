#pragma once

#define RESET   "\033[0m"
#define YELLOW  "\033[33m"
#define RED     "\033[31m"
#define DARKRED  "\033[91m"

void runtimeWarning(char* message);

void runtimeError(char* message);

void runtimeFatalError(char* message, bool isAllocError);