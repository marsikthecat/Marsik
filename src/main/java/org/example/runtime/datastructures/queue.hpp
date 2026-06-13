#pragma once

#include <stdbool.h>
#include "../error/error.hpp"

#define DEFAULT_QUEUE_SIZE 100

template<typename T>
struct Queue {
    T data[DEFAULT_QUEUE_SIZE];
    int front;
    int rear;
    int size;
};

template<typename T>
Queue<T> init_queue() {
    Queue<T> q;
    q.front = 0;
    q.rear = -1;
    q.size = 0;
    return q;
}

template<typename T>
void queue_enqueue(Queue<T>* q, const T& value) {
    if (q->size == DEFAULT_QUEUE_SIZE) {
        fprintf(stderr, "ERROR: Size %d of queue exceeded %p\n", DEFAULT_QUEUE_SIZE, value);
        return;
    }
    q->rear = (q->rear + 1) % DEFAULT_QUEUE_SIZE;
    q->data[q->rear] = value;
    q->size++;
}

template<typename T>
T queue_dequeue(Queue<T>* q) {
    if (q->size == 0) {
        runtimeError("Queue is empty");
        return T{};
    }
    T value = q->data[q->front];
    q->front = (q->front + 1) % DEFAULT_QUEUE_SIZE;
    q->size--;
    return value;
}

template<typename T>
T queue_peek(Queue<T>* q) {
    if (q->size == 0) {
        runtimeError("Queue is empty");
        return T{};
    }
    return q->data[q->front];
}

template<typename T>
bool queue_isFull(Queue<T>* q) {
    return q->size == DEFAULT_QUEUE_SIZE;
}

template<typename T>
bool queue_isEmpty(Queue<T>* q) {
    return q->size == 0;
}

template<typename T>
int queue_size(Queue<T>* q) {
    return q->size;
}