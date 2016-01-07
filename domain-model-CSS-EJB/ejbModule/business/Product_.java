package business;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.477+0000")
@StaticMetamodel(Product.class)
public class Product_ {
	public static volatile SingularAttribute<Product, Integer> id;
	public static volatile SingularAttribute<Product, Integer> prodCod;
	public static volatile SingularAttribute<Product, String> description;
	public static volatile SingularAttribute<Product, Double> faceValue;
	public static volatile SingularAttribute<Product, Double> qty;
	public static volatile SingularAttribute<Product, Boolean> discountEligibility;
	public static volatile SingularAttribute<Product, Unit> unit;
}
