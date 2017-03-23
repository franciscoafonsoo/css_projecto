package facade.dto;

import java.io.Serializable;


public class SupplierDTO implements Serializable{

    private static final long serialVersionUID = -4087131153704256744L;

    public final int id;
    public final String name;
    public final int vat;

    public SupplierDTO(String name, int vat, int id) {
        this.vat = vat;
        this.name = name;
        this.id = id;
    }
}