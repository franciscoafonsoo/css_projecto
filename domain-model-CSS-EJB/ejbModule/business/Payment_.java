package business;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.476+0000")
@StaticMetamodel(Payment.class)
public class Payment_ {
	public static volatile SingularAttribute<Payment, Integer> id;
	public static volatile SingularAttribute<Payment, Integer> clientVat;
	public static volatile SingularAttribute<Payment, Invoice> transaction;
	public static volatile SingularAttribute<Payment, Integer> invID;
	public static volatile SingularAttribute<Payment, Double> NotPaydYet;
	public static volatile SingularAttribute<Payment, Double> initialValue;
	public static volatile SingularAttribute<Payment, Date> d;
	public static volatile SingularAttribute<Payment, Integer> payd;
}
