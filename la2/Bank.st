"Bank class"

Object subclass: Bank [
	| accounts |

	accounts := Set new.
	
	"addAccount adds an account to the accounts set"
	addAccount: account [
		accounts add: account
	]
	
	"accrue accrues a passed rate to each account in the accounts set"
	accrue: rate [
		accounts do: [ :element |
			rate accrue 
		].
	]

	"printString is a toString that prints each account"
	printString [
		| r |
		accounts do: [ :element |
			r := r, element, String cr.
		]
		^ 'Bank(' , r , ')'
	]

	"main method"
	"classMethod: main [
	]"

]
