
package business;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the business package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _AddCustomerResponse_QNAME = new QName("http://business/", "addCustomerResponse");
    private final static QName _ApplicationException_QNAME = new QName("http://business/", "ApplicationException");
    private final static QName _AddCustomer_QNAME = new QName("http://business/", "addCustomer");
    private final static QName _GetDiscounts_QNAME = new QName("http://business/", "getDiscounts");
    private final static QName _GetDiscountsResponse_QNAME = new QName("http://business/", "getDiscountsResponse");
    private final static QName _PrepareOrderResponse_QNAME = new QName("http://business/", "prepareOrderResponse");
    private final static QName _AddOrderResponse_QNAME = new QName("http://business/", "addOrderResponse");
    private final static QName _ProductDetails_QNAME = new QName("http://business/", "productDetails");
    private final static QName _PrepareOrder_QNAME = new QName("http://business/", "prepareOrder");
    private final static QName _ProductDetailsResponse_QNAME = new QName("http://business/", "productDetailsResponse");
    private final static QName _AddOrder_QNAME = new QName("http://business/", "addOrder");
    private final static QName _GetOrdersByProduct_QNAME = new QName("http://business/", "getOrdersByProduct");
    private final static QName _GetOrdersByProductResponse_QNAME = new QName("http://business/", "getOrdersByProductResponse");
    private final static QName _GetOrdersBySupplier_QNAME = new QName("http://business/", "getOrdersBySupplier");
    private final static QName _ReceiveOrderResponse_QNAME = new QName("http://business/", "receiveOrderResponse");
    private final static QName _GetOrdersBySupplierResponse_QNAME = new QName("http://business/", "getOrdersBySupplierResponse");
    private final static QName _ReceiveOrder_QNAME = new QName("http://business/", "receiveOrder");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: business
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddCustomer }
     * 
     */
    public AddCustomer createAddCustomer() {
        return new AddCustomer();
    }

    /**
     * Create an instance of {@link ApplicationException }
     * 
     */
    public ApplicationException createApplicationException() {
        return new ApplicationException();
    }

    /**
     * Create an instance of {@link AddCustomerResponse }
     * 
     */
    public AddCustomerResponse createAddCustomerResponse() {
        return new AddCustomerResponse();
    }

    /**
     * Create an instance of {@link GetDiscountsResponse }
     * 
     */
    public GetDiscountsResponse createGetDiscountsResponse() {
        return new GetDiscountsResponse();
    }

    /**
     * Create an instance of {@link GetDiscounts }
     * 
     */
    public GetDiscounts createGetDiscounts() {
        return new GetDiscounts();
    }

    /**
     * Create an instance of {@link CustomerDTO }
     * 
     */
    public CustomerDTO createCustomerDTO() {
        return new CustomerDTO();
    }

    /**
     * Create an instance of {@link PrepareOrderResponse }
     *
     */
    public PrepareOrderResponse createPrepareOrderResponse() {
        return new PrepareOrderResponse();
    }

    /**
     * Create an instance of {@link AddOrder }
     *
     */
    public AddOrder createAddOrder() {
        return new AddOrder();
    }

    /**
     * Create an instance of {@link ProductDetailsResponse }
     *
     */
    public ProductDetailsResponse createProductDetailsResponse() {
        return new ProductDetailsResponse();
    }

    /**
     * Create an instance of {@link AddOrderResponse }
     *
     */
    public AddOrderResponse createAddOrderResponse() {
        return new AddOrderResponse();
    }

    /**
     * Create an instance of {@link ProductDetails }
     *
     */
    public ProductDetails createProductDetails() {
        return new ProductDetails();
    }

    /**
     * Create an instance of {@link PrepareOrder }
     *
     */
    public PrepareOrder createPrepareOrder() {
        return new PrepareOrder();
    }

    /**
     * Create an instance of {@link SupplierDTO }
     *
     */
    public SupplierDTO createSupplierDTO() {
        return new SupplierDTO();
    }

    /**
     * Create an instance of {@link ProductDTO }
     *
     */
    public ProductDTO createProductDTO() {
        return new ProductDTO();
    }

    /**
     * Create an instance of {@link OrdersDTO }
     *
     */
    public OrdersDTO createOrdersDTO() {
        return new OrdersDTO();
    }

    /**
     * Create an instance of {@link GetOrdersByProduct }
     *
     */
    public GetOrdersByProduct createGetOrdersByProduct() {
        return new GetOrdersByProduct();
    }

    /**
     * Create an instance of {@link GetOrdersByProductResponse }
     *
     */
    public GetOrdersByProductResponse createGetOrdersByProductResponse() {
        return new GetOrdersByProductResponse();
    }

    /**
     * Create an instance of {@link ReceiveOrder }
     *
     */
    public ReceiveOrder createReceiveOrder() {
        return new ReceiveOrder();
    }

    /**
     * Create an instance of {@link GetOrdersBySupplierResponse }
     *
     */
    public GetOrdersBySupplierResponse createGetOrdersBySupplierResponse() {
        return new GetOrdersBySupplierResponse();
    }

    /**
     * Create an instance of {@link GetOrdersBySupplier }
     *
     */
    public GetOrdersBySupplier createGetOrdersBySupplier() {
        return new GetOrdersBySupplier();
    }

    /**
     * Create an instance of {@link ReceiveOrderResponse }
     *
     */
    public ReceiveOrderResponse createReceiveOrderResponse() {
        return new ReceiveOrderResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCustomerResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business/", name = "addCustomerResponse")
    public JAXBElement<AddCustomerResponse> createAddCustomerResponse(AddCustomerResponse value) {
        return new JAXBElement<AddCustomerResponse>(_AddCustomerResponse_QNAME, AddCustomerResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ApplicationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business/", name = "ApplicationException")
    public JAXBElement<ApplicationException> createApplicationException(ApplicationException value) {
        return new JAXBElement<ApplicationException>(_ApplicationException_QNAME, ApplicationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddCustomer }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business/", name = "addCustomer")
    public JAXBElement<AddCustomer> createAddCustomer(AddCustomer value) {
        return new JAXBElement<AddCustomer>(_AddCustomer_QNAME, AddCustomer.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiscounts }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business/", name = "getDiscounts")
    public JAXBElement<GetDiscounts> createGetDiscounts(GetDiscounts value) {
        return new JAXBElement<GetDiscounts>(_GetDiscounts_QNAME, GetDiscounts.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDiscountsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://business/", name = "getDiscountsResponse")
    public JAXBElement<GetDiscountsResponse> createGetDiscountsResponse(GetDiscountsResponse value) {
        return new JAXBElement<GetDiscountsResponse>(_GetDiscountsResponse_QNAME, GetDiscountsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrepareOrderResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "prepareOrderResponse")
    public JAXBElement<PrepareOrderResponse> createPrepareOrderResponse(PrepareOrderResponse value) {
        return new JAXBElement<PrepareOrderResponse>(_PrepareOrderResponse_QNAME, PrepareOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrderResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "addOrderResponse")
    public JAXBElement<AddOrderResponse> createAddOrderResponse(AddOrderResponse value) {
        return new JAXBElement<AddOrderResponse>(_AddOrderResponse_QNAME, AddOrderResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductDetails }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "productDetails")
    public JAXBElement<ProductDetails> createProductDetails(ProductDetails value) {
        return new JAXBElement<ProductDetails>(_ProductDetails_QNAME, ProductDetails.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link PrepareOrder }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "prepareOrder")
    public JAXBElement<PrepareOrder> createPrepareOrder(PrepareOrder value) {
        return new JAXBElement<PrepareOrder>(_PrepareOrder_QNAME, PrepareOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ProductDetailsResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "productDetailsResponse")
    public JAXBElement<ProductDetailsResponse> createProductDetailsResponse(ProductDetailsResponse value) {
        return new JAXBElement<ProductDetailsResponse>(_ProductDetailsResponse_QNAME, ProductDetailsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AddOrder }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "addOrder")
    public JAXBElement<AddOrder> createAddOrder(AddOrder value) {
        return new JAXBElement<AddOrder>(_AddOrder_QNAME, AddOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersByProduct }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "getOrdersByProduct")
    public JAXBElement<GetOrdersByProduct> createGetOrdersByProduct(GetOrdersByProduct value) {
        return new JAXBElement<GetOrdersByProduct>(_GetOrdersByProduct_QNAME, GetOrdersByProduct.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersByProductResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "getOrdersByProductResponse")
    public JAXBElement<GetOrdersByProductResponse> createGetOrdersByProductResponse(GetOrdersByProductResponse value) {
        return new JAXBElement<GetOrdersByProductResponse>(_GetOrdersByProductResponse_QNAME, GetOrdersByProductResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersBySupplierResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "getOrdersBySupplierResponse")
    public JAXBElement<GetOrdersBySupplierResponse> createGetOrdersBySupplierResponse(GetOrdersBySupplierResponse value) {
        return new JAXBElement<GetOrdersBySupplierResponse>(_GetOrdersBySupplierResponse_QNAME, GetOrdersBySupplierResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveOrder }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "receiveOrder")
    public JAXBElement<ReceiveOrder> createReceiveOrder(ReceiveOrder value) {
        return new JAXBElement<ReceiveOrder>(_ReceiveOrder_QNAME, ReceiveOrder.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetOrdersBySupplier }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "getOrdersBySupplier")
    public JAXBElement<GetOrdersBySupplier> createGetOrdersBySupplier(GetOrdersBySupplier value) {
        return new JAXBElement<GetOrdersBySupplier>(_GetOrdersBySupplier_QNAME, GetOrdersBySupplier.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReceiveOrderResponse }{@code >}}
     *
     */
    @XmlElementDecl(namespace = "http://business/", name = "receiveOrderResponse")
    public JAXBElement<ReceiveOrderResponse> createReceiveOrderResponse(ReceiveOrderResponse value) {
        return new JAXBElement<ReceiveOrderResponse>(_ReceiveOrderResponse_QNAME, ReceiveOrderResponse.class, null, value);
    }

}
