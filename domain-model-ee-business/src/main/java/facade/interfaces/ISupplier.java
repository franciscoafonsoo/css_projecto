package facade.interfaces;


import java.io.Serializable;

public interface ISupplier extends Serializable{

    int getSupplierCode();

    String getSupplierName();

    int getSupplierVat();

    int getSupplierId();
}
