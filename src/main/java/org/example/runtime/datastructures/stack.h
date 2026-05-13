#ifndef STACK_H
#define STACK_H
#include <stdbool.h>

#define DEFAULT_STACK_SIZE 100

typedef struct Stack {
    void* data[DEFAULT_STACK_SIZE];
    int top;
} Stack;

Stack init_stack();

void stack_push(Stack* s, void* value);

void* stack_peek(Stack* s);

void* stack_pop(Stack* s);

bool stack_isFull(Stack* s);

bool stack_isEmpty(Stack* s);

int stack_size(Stack* s);

#endif