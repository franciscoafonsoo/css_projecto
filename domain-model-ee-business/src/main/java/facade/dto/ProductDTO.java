package facade.dto;

import java.io.Serializable;


public class ProductDTO implements Serializable{

    private static final long serialVersionUID = -4087131153704256744L;

    public final int prodCod;
    public final String description;
    public final double faceValue;
    public final double qty;

    public ProductDTO(int prodCod, String description, double faceValue, double qty) {
        this.prodCod = prodCod;
        this.description = description;
        this.faceValue = faceValue;
        this.qty = qty;
    }
}