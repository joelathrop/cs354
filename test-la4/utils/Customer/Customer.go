package Account

type CustomerInt interface {
	Customer(name string) *Customer
	GetName() string
}

type Customer struct {
	Name string
}

func (c *Customer) Customer(name string) *Customer {
	return &Customer {
		Name: 	name,
	}
}

//func (c *Customer) Init(name string) {
//	c.name = Name
//}

func (c *Customer) ToString() string {return c.Name}
