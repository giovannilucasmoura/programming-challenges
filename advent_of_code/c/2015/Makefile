CC=gcc
CFLAGS=-g3 -Wall

all: day_1 day_2 day_3 day_4 day_5

day_1: ../utils.o day_1.o
	$(CC) $(CFLAGS) $^ -o $@
day_2: ../utils.o day_2.o
	$(CC) $(CFLAGS) $^ -o $@
day_3: ../utils.o day_3.o
	$(CC) $(CFLAGS) $^ -o $@
day_4: ../utils.o day_4.o
	$(CC) $(CFLAGS) -lssl -lcrypto $^ -o $@
day_5: ../utils.o day_5.o
	$(CC) $(CFLAGS) $^ -o $@

day_1.o: day_1.c
day_2.o: day_2.c
day_3.o: day_3.c
day_4.o: day_4.c
day_5.o: day_5.c
utils.o: ../utils.c ../utils.h

clean:
	$(RM) *.o
	$(RM) ../*.o

full-clean: clean
	$(RM) day_1 day_2 day_3 day_4 day_5
