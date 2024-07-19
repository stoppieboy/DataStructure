#include <stdio.h>
#include <stdlib.h>
#define V 5

struct Edges{
    int dest;
    struct Edges* next;
};

struct Vertex {
    int src;
    struct Edges* head;
};


struct Edges* add(struct Edges* head, int dest){
    struct Edges* newEdge = (struct Edges*)malloc(sizeof(struct Edges));
    newEdge -> dest = dest;
    newEdge -> next = head;
    head = newEdge;
    return head;
}

void buildGraph(int pair[][2], int pair_count, struct Vertex* ar){
    for(int i=0; i<pair_count; i++)
    {
        ar[pair[i][0]].head = add(ar[pair[i][0]].head, pair[i][1]);
        ar[pair[i][1]].head = add(ar[pair[i][1]].head, pair[i][0]);
    }
}
void Display(struct Edges* head)
{
    struct Edges* start = head;
    while(start != NULL)
    {
        printf("%d ", start -> dest);
        start = start -> next;
    }
}

int main(){
    struct Vertex ar[V];
    for(int i = 0; i < V; i++){
        ar[i].src = i;
        ar[i].head = NULL;
    }
    int pair[][2] = {{0,1}, {1,2}, {0,3}, {0,4},{2,4},{1,3}};

    buildGraph(pair, 6, ar);
    for(int i=0; i<V; i++)
    {
        printf("%d : ", ar[i].src);
        Display(ar[i].head);
        printf("\n");
    }

    return 0;
}