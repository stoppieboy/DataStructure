#include "vector.h"

int main(){

    struct el{
        int val;
    };
    struct vector* vector = vector_create(sizeof(struct el*));

    vector_push(vector, &(struct el){.val=2});
    vector_push(vector, &(struct el){.val=3});
    vector_push(vector, &(struct el){.val=5});
    vector_push(vector, &(struct el){.val=6});

    int idx = getchar() - '0';
    printf("val = %d\n", *(int*)vector_at(vector, idx));
    printf("val at the last = %d\n", *(int*)vector_back(vector));
    printf("popped = %d\n", *(int*)vector_pop(vector));
    printf("val at the last = %d\n", *(int*)vector_back(vector));

    return 0;
}