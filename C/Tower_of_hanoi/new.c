// Tower of Hanoi - to be written in the ntbk

#include <stdio.h>

void toh(int disks, int start, int finish,  int temp){
    if(disks <= 0)
        return;
    toh(disks-1, start, temp, finish);
    printf("Move CD from %d to %d\n",start, finish);
    toh(disks-1, temp, finish, start);
}

int main(){
    int n = 3;
    toh(n, 1,3,2);
    return 0;
}