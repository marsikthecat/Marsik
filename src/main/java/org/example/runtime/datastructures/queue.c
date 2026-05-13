#include "queue.h"
#include <stdlib.h>
#include <stdio.h>

queue init_queue() {
    queue q;
    q.front = 0;
    q.rear = -1;
    q.size = 0;
    return q;
}

void queue_enqueue(queue* q, void* value) {
    if (q->size == DEFAULT_QUEUE_SIZE) {
        fprintf(stderr, "ERROR: Size %d of queue exceeded %p\n", DEFAULT_QUEUE_SIZE, value);
        return;
    }
    q->rear = (q->rear + 1) % DEFAULT_QUEUE_SIZE;
    q->data[q->rear] = value;
    q->size++;
}

void* queue_dequeue(queue* q) {
    if (q->size == 0) {
        fprintf(stderr, "ERROR: Queue is empty, NULL return instead\n");
        return NULL;
    }
    void* value = q->data[q->front];
    q->front = (q->front + 1) % DEFAULT_QUEUE_SIZE;
    q->size--;
    return value;
}

void* queue_peek(queue* q) {
    if (q->size == 0) {
        fprintf(stderr, "ERROR: Queue is empty, NULL return instead\n");
        return NULL;
    }
    return q->data[q->front];
}

bool queue_isFull(queue* q) {
    return q->size == DEFAULT_QUEUE_SIZE;
}

bool queue_isEmpty(queue* q) {
    return q->size == 0;
}

int queue_size(queue* q) {
    return q->size;
}