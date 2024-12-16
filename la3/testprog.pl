#!/bin/gprolog --consult-file

:- include('data.pl').

even(X) :-
	X mod 2 =:= 0.
