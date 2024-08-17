OBJECTS = ./build/vector.o
INCLUDES = -I./

all: ${OBJECTS}
	gcc main.c ${OBJECTS} -o main

./build/vector.o: ./vector.c
	gcc vector.c -o ./build/vector.o -c

clean:
	rm ./main
	rm -rf ${OBJECTS}