Object subclass: Customer [
	| name |
	
	"constructor for customer"
	Customer class>>name: aName [
		^(self new)
		name: aName.
	]

	
	initialize: aName [
		aName: name.
	]

	printString [
		^ 'Customer(' , name , ')'
	]
]

