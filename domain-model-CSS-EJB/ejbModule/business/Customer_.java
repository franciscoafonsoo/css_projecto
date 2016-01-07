package business;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.464+0000")
@StaticMetamodel(Customer.class)
public class Customer_ {
	public static volatile SingularAttribute<Customer, Integer> id;
	public static volatile SingularAttribute<Customer, Integer> vatNumber;
	public static volatile SingularAttribute<Customer, String> designation;
	public static volatile SingularAttribute<Customer, Integer> phoneNumber;
	public static volatile SingularAttribute<Customer, Discount> discount;
}
