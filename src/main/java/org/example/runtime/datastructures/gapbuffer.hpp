#pragma once

#include <stdio.h>
#include <stdbool.h>
#include <string>
#include "../error/error.hpp"

#define DEFAULT_GAP_BUFFER_CAPACITY 100

using namespace std;

struct GapBuffer {
    char data[DEFAULT_GAP_BUFFER_CAPACITY];
    int gapSize;
    int gapLeft;
    int gapRight;
    int size;
};

GapBuffer init_gapbuffer() {
    GapBuffer buffer;
    buffer.gapSize = DEFAULT_GAP_BUFFER_CAPACITY;
    buffer.gapLeft = 0;
    buffer.gapRight = DEFAULT_GAP_BUFFER_CAPACITY - 1;
    buffer.size = 0;
    return buffer;
}

void gapbuffer_moveGapLeft(GapBuffer buffer, int pos) {
    while (buffer.gapLeft > pos) {
        buffer.data[buffer.gapRight] = buffer.data[buffer.gapLeft - 1];
        buffer.gapLeft--;
        buffer.gapRight--;
        buffer.data[buffer.gapLeft] = ' ';
    }
}

void gapbuffer_moveGapRight(GapBuffer buffer, int pos) {
    while (buffer.gapLeft < pos) {
        buffer.data[buffer.gapLeft] = buffer.data[buffer.gapRight + 1];
        buffer.gapLeft++;
        buffer.gapRight++;
        buffer.data[buffer.gapRight] = ' ';
    }
}

void gapbuffer_moveCursor(GapBuffer buffer, int pos) {
    if (pos < 0 || pos > buffer.size) {
        runtimeError("Position out of bounds");
        return;
    }
    if (pos < buffer.gapLeft) {
        gapbuffer_moveGapLeft(buffer, pos);
    } else if (pos > buffer.gapLeft) {
        gapbuffer_moveGapRight(buffer, pos);
    }
}

void gapbuffer_insert(GapBuffer buffer, string str, int pos) {
    if (pos < 0 || pos > buffer.size) {
        runtimeError("Position out of bounds");
        return;
    }
    int length = str.length();
    if (buffer.size + length > DEFAULT_GAP_BUFFER_CAPACITY) {
        runtimeError("GapBuffer capacity exceeded");
        return;
    }
    if (pos != buffer.gapLeft) {
        gapbuffer_moveCursor(buffer, pos);
    }
    for (int i = 0; i < length; i++) {
        buffer.data[buffer.gapLeft] = str[i];
        buffer.gapLeft++;
        buffer.gapSize--;
    }
    buffer.size += length;
}