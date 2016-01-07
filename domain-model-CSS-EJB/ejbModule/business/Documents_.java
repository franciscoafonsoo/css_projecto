package business;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-01-06T14:00:13.466+0000")
@StaticMetamodel(Documents.class)
public class Documents_ {
	public static volatile SingularAttribute<Documents, Integer> id;
	public static volatile SingularAttribute<Documents, Integer> saleNum;
	public static volatile SingularAttribute<Documents, Date> date;
	public static volatile SingularAttribute<Documents, String> companyAdress;
	public static volatile SingularAttribute<Documents, Integer> companyNumber;
	public static volatile SingularAttribute<Documents, Integer> customerVat;
	public static volatile SingularAttribute<Documents, String> customerName;
	public static volatile SingularAttribute<Documents, Sale> sale;
}
