package business;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.478+0000")
@StaticMetamodel(Receipt.class)
public class Receipt_ extends Documents_ {
	public static volatile SingularAttribute<Receipt, Double> value;
	public static volatile SingularAttribute<Receipt, Payment> paymentPlan;
	public static volatile SingularAttribute<Receipt, Integer> tranche;
	public static volatile SingularAttribute<Receipt, Integer> invoice;
}
