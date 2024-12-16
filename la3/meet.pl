#!/bin/gprolog --consult-file

:- include('data.pl').
:- include('uniq.pl').

% Time to minutes
time_to_min(H, M, am, Minutes) :-
	Minutes is H * 60 + M.
time_to_min(H, M, pm, Minutes) :-
	Minutes is (H + 12) * 60 + M.

% Do two time slots overlap?
overlap(slot(time(hour1, min1, amPm1), time(hour2, min2, amPm2)),
	slot(time(hour3, min3, amPm3), time(hour4, min4, amPm4))) :-
	(amPm1 = amPm3, amPm2 = amPm4 ; amPm1 \= am, amPm3 \= am,
		amPm2 \= pm, amPm4 \= pm),
	time_to_min(hour1, min1, amPm1, Minutes1),
	time_to_min(hour2, min2, amPm2, Minutes2),
	time_to_min(hour3, min3, amPm3, Minutes3),
	time_to_min(hour4, min4, amPm4, Minutes4),
	(Minutes1 =< Minutes4, Minutes3 =< Minutes2).

% List of slots overlap
overlap_list([], _).
overlap_list([H|T], List) :-
	member(E, List),
	overlap(H, E),
	overlap_list(T, List).

% Find all meeting times
meet(Slot) :-
	findall(F, free(_, F), FreeSLots),
	overlap_list(FreeSlots, [Slot|_]).

main :- findall(Slot, meet(Slot), Slots), 
		uniq(Slots, Uniq), 
		write(Uniq), nl, halt.

:- initialization(main).
									here
