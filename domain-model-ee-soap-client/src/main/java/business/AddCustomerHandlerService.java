
package business;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AddCustomerHandlerService", targetNamespace = "http://business/", wsdlLocation = "http://localhost:8080/domain-model-ee-business/AddCustomerHandler?wsdl")
public class AddCustomerHandlerService
    extends Service
{

    private final static URL ADDCUSTOMERHANDLERSERVICE_WSDL_LOCATION;
    private final static WebServiceException ADDCUSTOMERHANDLERSERVICE_EXCEPTION;
    private final static QName ADDCUSTOMERHANDLERSERVICE_QNAME = new QName("http://business/", "AddCustomerHandlerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/domain-model-ee-business/AddCustomerHandler?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ADDCUSTOMERHANDLERSERVICE_WSDL_LOCATION = url;
        ADDCUSTOMERHANDLERSERVICE_EXCEPTION = e;
    }

    public AddCustomerHandlerService() {
        super(__getWsdlLocation(), ADDCUSTOMERHANDLERSERVICE_QNAME);
    }

    public AddCustomerHandlerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ADDCUSTOMERHANDLERSERVICE_QNAME, features);
    }

    public AddCustomerHandlerService(URL wsdlLocation) {
        super(wsdlLocation, ADDCUSTOMERHANDLERSERVICE_QNAME);
    }

    public AddCustomerHandlerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ADDCUSTOMERHANDLERSERVICE_QNAME, features);
    }

    public AddCustomerHandlerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AddCustomerHandlerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AddCustomerHandler
     */
    @WebEndpoint(name = "AddCustomerHandlerPort")
    public AddCustomerHandler getAddCustomerHandlerPort() {
        return super.getPort(new QName("http://business/", "AddCustomerHandlerPort"), AddCustomerHandler.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AddCustomerHandler
     */
    @WebEndpoint(name = "AddCustomerHandlerPort")
    public AddCustomerHandler getAddCustomerHandlerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://business/", "AddCustomerHandlerPort"), AddCustomerHandler.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ADDCUSTOMERHANDLERSERVICE_EXCEPTION!= null) {
            throw ADDCUSTOMERHANDLERSERVICE_EXCEPTION;
        }
        return ADDCUSTOMERHANDLERSERVICE_WSDL_LOCATION;
    }

}
