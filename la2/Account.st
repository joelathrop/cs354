"gst Account.st"

"Smalltalk Account program"

Object subclass: Account [
	| number customer balance |
	
	"instance variables"
	"Account class [
		new [
			^super new initialize
		]
	]
	initialize [
		number := 'default'.
		customer := 'default'.
		balance := 'default'.
		^self
	]
	instancevariableNames: 'number customer balance'."

	"accrue: rate [
	
	]"

	"Balance getter"
	getBalance: balance [
		^balance
	]

	"deposit method adds an amount to balance"
	deposit: amount [
		balance = balance + amount
	]

	"withdraw method subtracts an amount from balance"
	withdraw: amount [
		balance = balance - amount
	]

	printString [
		^ 'Account(' , number , ':' , customer , ':' , balance , ')'
	]

]
