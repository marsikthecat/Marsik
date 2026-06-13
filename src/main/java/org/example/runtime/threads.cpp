#include "threads.hpp"
#include <cstdio>
#include <cstdlib>
#include <unistd.h>
#include "allocator/allocator.hpp"
#include "error/error.hpp"

Thread* thread_create(thread_func func, void* arg) {
    Thread* thread = (Thread*)allocateFromMarsik(sizeof(Thread));
    thread->running = true;
    thread->result = NULL;
    int result = pthread_create(&thread->handle, NULL, func, arg);
    if (result != 0) {
        runtimeError("Failed to start Thread");
        return NULL;
    }
    return thread;
}

bool thread_is_running(Thread* thread) {
    return thread->running;
}

void thread_end(Thread* thread) {
    void* result;
    pthread_join(thread->handle, &result);
    thread->result = result;
    thread->running = false;
}

Mutex* mutex_create(void) {
    Mutex* mutex = (Mutex*)allocateFromMarsik(sizeof(Mutex));
    if (pthread_mutex_init(&mutex->mutex, NULL) != 0) {
        runtimeError("Failed to create Mutex");
        return NULL;
    }
    return mutex;
}

void mutex_lock(Mutex* mutex) {
    pthread_mutex_lock(&mutex->mutex);
}

void mutex_unlock(Mutex* mutex) {
    pthread_mutex_unlock(&mutex->mutex);
}

void thread_sleep_ms(int milliseconds) {
    usleep(milliseconds * 1000);
}