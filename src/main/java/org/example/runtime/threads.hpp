#pragma once

#include "string.hpp"
#include <stdbool.h>
#include <pthread.h>

typedef void* (*thread_func)(void*);

typedef struct {
    pthread_t handle;
    bool running;
    void* result;
} Thread;

Thread* thread_create(thread_func func, void* arg);
void thread_start(Thread* thread);
bool thread_is_running(Thread* thread);
void thread_end(Thread* thread);
void thread_free(Thread* thread);

typedef struct {
    pthread_mutex_t mutex;
} Mutex;

Mutex* mutex_create(void);
void mutex_lock(Mutex* mutex);
void mutex_unlock(Mutex* mutex);
void mutex_free(Mutex* mutex);

void thread_sleep_ms(int milliseconds);