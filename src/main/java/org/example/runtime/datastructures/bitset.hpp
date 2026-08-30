#pragma once

#include <stdbool.h>

typedef struct Bitset {
    unsigned char bits;
} Bitset;

Bitset init_bitset();

void bitset_set(Bitset bs, int index);

void bitset_clear(Bitset bs, int index);

void bitset_toggle(Bitset bs, int index);

bool bitset_get(Bitset bs, int index);

void bitset_setAll(Bitset bs);

void bitset_clearAll(Bitset bs);

bool bitset_isEmpty(Bitset bs);

bool bitset_isFull(Bitset bs);

int bitset_count(Bitset bs);