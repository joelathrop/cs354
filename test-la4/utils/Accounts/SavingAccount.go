package Account

import . "la4/utils/Customer"

// SavingAccount interface
type SavingAccountInt interface {
	SavingAccount(number string, customer Customer, balance float64)
	accrue(rate float64)
}

// SavingAccount struct 
type SavingAccount struct {
	interest float64
}

// Saving account constructor
func NewSavingAccount(number string, customer *Customer, balance float64) (acc *Account) {
	acc = new(Account)
	acc.Init(number, customer, balance)
	return
}

// SavingAccount Initialization method
func (acc *Account) Init(number string, customer *Customer, balance float64) {
	acc.number = number
	acc.customer = customer
	acc.balance = balance
}
