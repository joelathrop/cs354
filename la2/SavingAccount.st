"SavingAccount extends Account class"

Account subclass: SavingAccount [
	interest := 0.

	initSavingAccount: aNumber customer: aCustomer balance: aBalance [
		self init.
		number := aNumber.
		customer := aCustomer.
		balance := aBalance
	]

	SavingAccount class [
		newSavingAccount: aNumber customer: aCustomer balance: aBalance [
			^ self new initSavingAccount: aNumber customer: aCustomer balance: aBalance
		]
	]
]
