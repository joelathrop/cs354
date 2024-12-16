package Account

import . "la4/utils/Customer"

// Checking Account constructor initializes customer number, name, and balance
func CheckingAccount(number string, customer *Customer, balance float64) (acc *Account) {
	acc = new(Account)
	acc.Init(number, customer, balance)
	return
}

// initialization function for CheckingAccount
func (acc *Account) CInit(number string, customer *Customer, balance float64) {
	acc.number = number
	acc.customer = customer
	acc.balance = balance
}
