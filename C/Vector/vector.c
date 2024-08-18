#include "vector.h"

struct vector* vector_create(size_t esize)
{
    struct vector* vector = (struct vector*)calloc(sizeof(struct vector), 1);
    vector->data = malloc(esize * VECTOR_ELEMENT_INCREMENT);
    vector->capacity = VECTOR_ELEMENT_INCREMENT;
    vector->count = 0;
    vector->rindex = 0;
    vector->dsize = esize;
    return vector;
}

void* vector_at(struct vector* vector, int idx)
{
    return vector->data + (idx*vector->dsize);
}

void* vector_back(struct vector* vector){
    // return vector->data + ((vector->rindex-1) * vector->dsize);
    return vector_at(vector, vector->rindex-1);
}

bool vector_resize(struct vector* vector)
{
    vector->data = realloc(vector->data, (vector->count+VECTOR_ELEMENT_INCREMENT)*vector->dsize);
    assert(vector->data);
}

void vector_push(struct vector* vector, void* data)
{
    if(vector)
    {
        bool status = true;
        if(vector->capacity == vector->count)
        {
            status = vector_resize(vector);
        }
        if(status)
        {
            void* ptr = vector_at(vector, vector->rindex);
            memcpy(ptr, data, vector->dsize);
            vector->rindex++;
            vector->count++;
        }
    }
}

bool vector_in_bounds_for_pop(struct vector* vector,  int idx)
{
    return (idx >= 0 && idx < vector->capacity);
}

void* vector_pop(struct vector* vector)
{
    void* ptr = NULL;
    ptr = vector_back(vector);
    vector->rindex--;
    vector->count--;

    return ptr;
}

void vector_free(struct vector* vector)
{
    free(vector->data);
    free(vector);
}