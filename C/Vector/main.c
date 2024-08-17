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
    return 0;
}