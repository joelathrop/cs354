#!/bin/gprolog --consult-file

:- include('data.pl').

% Compare times
lte(time(Hour, Minute), time(Hour, Minute)) :-
	

meettime(time(Hour, Minute)) :- Hour=<8, Minute=<45.

meetone(Person, Slot) :- free(Person, slot(Time, _)),
			meettime(Time).

main :- findall(Person,
		meetone(Person,slot(time(8,30,am),time(8,45,am))),
		People),
	write('hi'), nl,
	write(People), nl, halt.

:- initialization(main).
