package business;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.497+0000")
@StaticMetamodel(Transaction.class)
public class Transaction_ {
	public static volatile SingularAttribute<Transaction, Integer> id;
	public static volatile SingularAttribute<Transaction, Double> value;
	public static volatile SingularAttribute<Transaction, Integer> docID;
	public static volatile SingularAttribute<Transaction, Integer> customerVat;
	public static volatile SingularAttribute<Transaction, Date> d;
}
