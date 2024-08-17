#ifndef VECTOR_H
#define VECTOR_H

#include <stddef.h>
#include <stdbool.h>
#include <assert.h>
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#define VECTOR_ELEMENT_INCREMENT 20

struct vector{
    void* data;
    size_t dsize;

    size_t capacity;
    size_t count;

    int rindex;
};

struct vector* vector_create(size_t esize);
void* vector_at(struct vector* vector, int idx);
bool vector_resize(struct vector* vector);
void vector_push(struct vector* vector, void* data);
void vector_free(struct vector* vector);

#endif