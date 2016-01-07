package business;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.495+0000")
@StaticMetamodel(SaleProduct.class)
public class SaleProduct_ {
	public static volatile SingularAttribute<SaleProduct, Integer> id;
	public static volatile SingularAttribute<SaleProduct, Product> product;
	public static volatile SingularAttribute<SaleProduct, Double> qty;
}
