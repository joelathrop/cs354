# la1-1: Scheme tsar Program

* Author: Joe Lathrop
* Class: CS354 Section 2
* Semester: Spring 2023

## Overview

This program defines a function called tsar which reads in a list,
searches for a value, and replaces any value in the list matching search
with the passed in replace value.

## Running and Testing
To run the program, use the guile interpreter:

* guile tsar.scm

The program only returns values, it does not display anything. To test
functionailty, the user can add to the bottom of the scheme program:

* (display (tsar subj srch repl))

with the desired values. "subj" represents the list, "srch" represents
the search value, and "repl" represents the replace value. Suggested test
suites are detailed in the file "testsuite.txt".
