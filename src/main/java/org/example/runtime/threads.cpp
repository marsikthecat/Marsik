#include "threads.hpp"
#include <cstdio>
#include <cstdlib>
#include <unistd.h>

Thread* thread_create(thread_func func, void* arg) {
    Thread* thread = (Thread*)std::malloc(sizeof(Thread));
    if (thread == NULL) {
        return NULL;
    }
    thread->running = true;
    thread->result = NULL;
    int result = pthread_create(&thread->handle, NULL, func, arg);
    if (result != 0) {
        std::free(thread);
        return NULL;
    }
    return thread;
}

bool thread_is_running(Thread* thread) {
    if (thread == NULL) return false;
    return thread->running;
}

void thread_end(Thread* thread) {
    if (thread == NULL) return;
    void* result;
    pthread_join(thread->handle, &result);
    thread->result = result;
    thread->running = false;
}

void thread_free(Thread* thread) {
    if (thread == NULL) return;
    std::free(thread);
}

Mutex* mutex_create(void) {
    Mutex* mutex = (Mutex*)std::malloc(sizeof(Mutex));
    if (mutex == NULL) {
        return NULL;
    }

    if (pthread_mutex_init(&mutex->mutex, NULL) != 0) {
        std::free(mutex);
        return NULL;
    }

    return mutex;
}

void mutex_lock(Mutex* mutex) {
    if (mutex == NULL) return;
    pthread_mutex_lock(&mutex->mutex);
}

void mutex_unlock(Mutex* mutex) {
    if (mutex == NULL) return;
    pthread_mutex_unlock(&mutex->mutex);
}

void mutex_free(Mutex* mutex) {
    if (mutex == NULL) return;
    pthread_mutex_destroy(&mutex->mutex);
    std::free(mutex);
}

void thread_sleep_ms(int milliseconds) {
    usleep(milliseconds * 1000);
}