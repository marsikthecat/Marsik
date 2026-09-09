#include "bitset.hpp"
#include <stdlib.h>
#include <stdio.h>

BitSet init_bitset() {
    BitSet bs;
    bs.bits = 0;
    return bs;
}

void bitset_set(BitSet& bs, int index) {
    if (index < 0 || index >= 8) {
        fprintf(stderr, "ERROR: Index %d out of bounds (0-7)\n", index);
        return;
    }
    bs.bits |= (1 << index);
}

void bitset_clear(BitSet& bs, int index) {
    if (index < 0 || index >= 8) {
        fprintf(stderr, "ERROR: Index %d out of bounds (0-7)\n", index);
        return;
    }
    bs.bits &= ~(1 << index);
}

void bitset_toggle(BitSet& bs, int index) {
    if (index < 0 || index >= 8) {
        fprintf(stderr, "ERROR: Index %d out of bounds (0-7)\n", index);
        return;
    }
    bs.bits ^= (1 << index);
}

bool bitset_get(BitSet& bs, int index) {
    if (index < 0 || index >= 8) {
        fprintf(stderr, "ERROR: Index %d out of bounds (0-7)\n", index);
        return false;
    }
    return (bs.bits & (1 << index)) != 0;
}

void bitset_setAll(BitSet& bs) {
    bs.bits = 0xFF;
}

void bitset_clearAll(BitSet& bs) {
    bs.bits = 0;
}

bool bitset_isEmpty(BitSet& bs) {
    return bs.bits == 0;
}

bool bitset_isFull(BitSet& bs) {
    return bs.bits == 0xFF;
}

int bitset_count(BitSet& bs) {
    int count = 0;
    unsigned char bits = bs.bits;
    while (bits) {
        count += bits & 1;
        bits >>= 1;
    }
    return count;
}