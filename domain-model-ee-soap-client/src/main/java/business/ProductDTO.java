
package business;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for productDTO complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="productDTO">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="prodCod" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="description" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="faceValue" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="qty" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "productDTO", propOrder = {
    "prodCod",
    "description",
    "faceValue",
    "qty"
})
public class ProductDTO {

    protected int prodCod;
    protected String description;
    protected double faceValue;
    protected double qty;

    /**
     * Gets the value of the prodCod property.
     * 
     */
    public int getProdCod() {
        return prodCod;
    }

    /**
     * Sets the value of the prodCod property.
     * 
     */
    public void setProdCod(int value) {
        this.prodCod = value;
    }

    /**
     * Gets the value of the description property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the faceValue property.
     * 
     */
    public double getFaceValue() {
        return faceValue;
    }

    /**
     * Sets the value of the faceValue property.
     * 
     */
    public void setFaceValue(double value) {
        this.faceValue = value;
    }

    /**
     * Gets the value of the qty property.
     * 
     */
    public double getQty() {
        return qty;
    }

    /**
     * Sets the value of the qty property.
     * 
     */
    public void setQty(double value) {
        this.qty = value;
    }

}
