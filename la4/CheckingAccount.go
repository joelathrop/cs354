package account

type CheckingAccount struct {
	number string
	customer Customer
	balance float64
}

func CheckingAccount(number string, customer Customer, balance float64) *CheckingAccount {
	return &CheckingAccount{
		number: 	number,
		customer: 	customer,
		balance: 	balance,
	}
}
