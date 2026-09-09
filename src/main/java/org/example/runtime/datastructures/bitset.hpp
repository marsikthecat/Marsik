#pragma once

#include <stdbool.h>

typedef struct BitSet {
    unsigned char bits;
} BitSet;

BitSet init_bitset();

void bitset_set(BitSet& bs, int index);

void bitset_clear(BitSet& bs, int index);

void bitset_toggle(BitSet& bs, int index);

bool bitset_get(BitSet& bs, int index);

void bitset_setAll(BitSet& bs);

void bitset_clearAll(BitSet& bs);

bool bitset_isEmpty(BitSet& bs);

bool bitset_isFull(BitSet& bs);

int bitset_count(BitSet& bs);