#ifndef QUEUE_H
#define QUEUE_H
#include <stdbool.h>

#define DEFAULT_QUEUE_SIZE 100

typedef struct Queue
{
    void* data[DEFAULT_QUEUE_SIZE];
    int front;
    int rear;
    int size;
} Queue;

Queue init_queue();

void queue_enqueue(Queue* q, void* value);

void* queue_dequeue(Queue* q);

void* queue_peek(Queue* q);

bool queue_isFull(Queue* q);

bool queue_isEmpty(Queue* q);

int queue_size(Queue* q);

#endif