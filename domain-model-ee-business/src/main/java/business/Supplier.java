package business;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name=Supplier.FIND_BY_VAT, query = "SELECT s FROM Supplier s WHERE s.vat =:" +
                Supplier.NUMBER_VAT),
        @NamedQuery(name=Supplier.FIND_ALL_SUPPLIERS, query = "SELECT s FROM Supplier s")
})
public class Supplier {

    // Named query name constants
    public static final String FIND_BY_VAT = "Supplier.findByVAT";
    public static final String NUMBER_VAT = "vat";
    public static final String FIND_ALL_SUPPLIERS = "Supplier.findAllSuppliers";

    // 1. attributes

    @Id @GeneratedValue private int id;

    @Column(nullable = false) private String name;

    @Column(nullable = false, unique = true) private int vat;

    // 2. constructor

    protected Supplier() {}

    public Supplier(String name, int vat){
        this.name = name;
        this.vat = vat;
    }

    // 3. getters and setters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getVat() {
        return vat;
    }
}
