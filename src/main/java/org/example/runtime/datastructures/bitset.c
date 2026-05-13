#include "bitset.h"
#include <stdlib.h>
#include <stdio.h>

Bitset init_bitSet() {
    Bitset bs;
    bs.bits = 0;
    return bs;
}

void bitset_set(Bitset* bs, int index) {
    if (index < 0 || index >= 8) {
        fprintf(stderr, "ERROR: Index %d out of bounds (0-7)\n", index);
        return;
    }
    bs->bits |= (1 << index);
}

void bitset_clear(Bitset* bs, int index) {
    if (index < 0 || index >= 8) {
        fprintf(stderr, "ERROR: Index %d out of bounds (0-7)\n", index);
        return;
    }
    bs->bits &= ~(1 << index);
}

void bitset_toggle(Bitset* bs, int index) {
    if (index < 0 || index >= 8) {
        fprintf(stderr, "ERROR: Index %d out of bounds (0-7)\n", index);
        return;
    }
    bs->bits ^= (1 << index);
}

bool bitset_get(Bitset* bs, int index) {
    if (index < 0 || index >= 8) {
        fprintf(stderr, "ERROR: Index %d out of bounds (0-7)\n", index);
        return false;
    }
    return (bs->bits & (1 << index)) != 0;
}

void bitset_setAll(Bitset* bs) {
    bs->bits = 0xFF;
}

void bitset_clearAll(Bitset* bs) {
    bs->bits = 0;
}

bool bitset_isEmpty(Bitset* bs) {
    return bs->bits == 0;
}

bool bitset_isFull(Bitset* bs) {
    return bs->bits == 0xFF;
}

int bitset_count(Bitset* bs) {
    int count = 0;
    unsigned char bits = bs->bits;
    while (bits) {
        count += bits & 1;
        bits >>= 1;
    }
    return count;
}