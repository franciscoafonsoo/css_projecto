package business;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.474+0000")
@StaticMetamodel(PartedPayment.class)
public class PartedPayment_ extends Payment_ {
	public static volatile SingularAttribute<PartedPayment, Date> firstPayment;
	public static volatile SingularAttribute<PartedPayment, Boolean> firstPayd;
	public static volatile SingularAttribute<PartedPayment, Date> lastPayment;
	public static volatile SingularAttribute<PartedPayment, Boolean> lastPayd;
}
