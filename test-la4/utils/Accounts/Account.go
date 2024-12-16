package Account

//import . "fmt"
import . "la4/utils/Customer"

// Account interface
type AccountInt interface {
	Accrue(rate float64)
	GetBalance() float64
	Deposit(amount float64)
	Withdraw(amount float64)
	ToString()
}

// Account struct
type Account struct {
	balance float64
	number string
	customer Customer
}

func (acc *Account) Accrue(rate float64) {

}

func (acc *Account) GetBalance() float64 {
	return acc.balance
}

// func (acc *Account) Deposit(ch chan<- Transaction, number string, customer Customer, amount float64) {
//	transaction := Transaction{number, customer, amount}
//	ch <- transaction
	// acc.balance += amount
//}

// void Deposit method to increase balance by desired amount
func (acc *Account) Deposit(amount float64) {
	acc.balance += amount
}

func (acc *Account) Withdraw(amount float64) error {
	//if amount > acc.balance {
	//	return fmt.Errorf("insufficient funds")
	//}
	acc.balance -= amount
	return nil
}

// ToString method returns account number:customer:balance
//func ToString() {
//	return acc.number + ":" + acc.customer + ":" acc.balance
//}



