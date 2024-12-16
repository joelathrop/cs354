package customer

type Customer struct {
	name string
}

func Customer(name string) *Customer {
	return &Customer{name: name}
}

func (c *Customer) GetName() string {
	return c.name
}

