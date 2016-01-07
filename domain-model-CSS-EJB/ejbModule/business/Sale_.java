package business;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.479+0000")
@StaticMetamodel(Sale.class)
public class Sale_ {
	public static volatile SingularAttribute<Sale, Integer> id;
	public static volatile SingularAttribute<Sale, Date> date;
	public static volatile SingularAttribute<Sale, SaleStatus> status;
	public static volatile SingularAttribute<Sale, Customer> customer;
	public static volatile ListAttribute<Sale, SaleProduct> saleProducts;
}
