package business;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.472+0000")
@StaticMetamodel(Invoice.class)
public class Invoice_ extends Documents_ {
	public static volatile SingularAttribute<Invoice, Double> totalPrice;
	public static volatile SingularAttribute<Invoice, Double> taxCharged;
	public static volatile SingularAttribute<Invoice, Double> totalCharged;
}
