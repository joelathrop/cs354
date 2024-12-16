package account

import . "fmt"

type Account struct {
	balance float64
	number string
	customer Customer
}

type Transaction struct {
	number string
	customer Customer
	amount float64
}

func (acc *Account) Accrue(rate float64) {

}

func (acc *Account) GetBalance() float64 {
	return acc.balance
}

func (acc *Account) Deposit(ch chan<- Transaction, number string, customer Customer, amount float64) {
	transaction := Transaction{number, customer, amount}
	ch <- transaction
	// acc.balance += amount
}

func (acc *Account) Withdraw(amount float64) error {
	if amount > acc.balance {
		return fmt.Errorf("insufficient funds")
	}
	acc.balance -= amount
	return nil
}
