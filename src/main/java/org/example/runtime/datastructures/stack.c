#include "stack.h"
#include <stdlib.h>
#include <stdio.h>

Stack init_stack() {
    Stack s;
    s.top = -1;
    return s;
}

void stack_push(Stack* s, void* value) {
    if (s->top == DEFAULT_STACK_SIZE - 1) {
        fprintf(stderr, "ERROR: Size %d of stack exceeded %p\n", DEFAULT_STACK_SIZE, value);
        return;
    }
    s->data[++s->top] = value;
}

void* stack_pop(Stack* s) {
    if (s->top == -1) {
        fprintf(stderr, "ERROR: Stack is empty, NULL return instead\n");
        return NULL;
    }
    return s->data[s->top--];
}

void* stack_peek(Stack* s) {
    if (s->top == -1) {
        fprintf(stderr, "ERROR: Stack is empty, NULL return instead\n");
        return NULL;
    }
    return s->data[s->top];
}

bool stack_isFull(Stack* s) {
    return s->top == DEFAULT_STACK_SIZE - 1;
}

bool stack_isEmpty(Stack* s) {
    return s->top == -1;
}

int stack_size(stack* s) {
    return s->top + 1;
}