#pragma once

#include <cstdlib>
#include <stdbool.h>
#include <stdlib.h>
#include <stdio.h>

#define DEFAULT_STACK_SIZE 100

template<typename T>
struct Stack {
    T data[DEFAULT_STACK_SIZE];
    int top;
};

template<typename T>
Stack<T> init_stack() {
    Stack<T> s;
    s.top = -1;
    return s;
}

template<typename T>
void stack_push(Stack<T>* s, const T& value) {
    if (s->top == DEFAULT_STACK_SIZE - 1) {
        fprintf(stderr, "ERROR: Size %d of Stack exceeded %p\n", DEFAULT_STACK_SIZE, value);
        return;
    }
    s->data[++s->top] = value;
}

template<typename T>
T stack_peek(Stack<T>* s) {
    if (s->top == -1) {
        runtimeError("Stack is empty");
        return T{};
    }
    return s->data[s->top];
}

template<typename T>
T stack_pop(Stack<T>* s) {
    if (s->top == -1) {
        runtimeError("Stack is empty");
        return T{};
    }
    return s->data[s->top--];
}

template<typename T>
bool stack_isFull(Stack<T>* s) {
    return s->top == DEFAULT_STACK_SIZE - 1;
}

template<typename T>
bool stack_isEmpty(Stack<T>* s) {
    return s->top == -1;
}

template<typename T>
int stack_size(Stack<T>* s) {
    return s->top + 1;
}