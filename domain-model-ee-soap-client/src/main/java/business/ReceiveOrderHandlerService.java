
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
@WebServiceClient(name = "ReceiveOrderHandlerService", targetNamespace = "http://business/", wsdlLocation = "http://localhost:8080/domain-model-ee-business/ReceiveOrderHandler?wsdl")
public class ReceiveOrderHandlerService
    extends Service
{

    private final static URL RECEIVEORDERHANDLERSERVICE_WSDL_LOCATION;
    private final static WebServiceException RECEIVEORDERHANDLERSERVICE_EXCEPTION;
    private final static QName RECEIVEORDERHANDLERSERVICE_QNAME = new QName("http://business/", "ReceiveOrderHandlerService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/domain-model-ee-business/ReceiveOrderHandler?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        RECEIVEORDERHANDLERSERVICE_WSDL_LOCATION = url;
        RECEIVEORDERHANDLERSERVICE_EXCEPTION = e;
    }

    public ReceiveOrderHandlerService() {
        super(__getWsdlLocation(), RECEIVEORDERHANDLERSERVICE_QNAME);
    }

    public ReceiveOrderHandlerService(WebServiceFeature... features) {
        super(__getWsdlLocation(), RECEIVEORDERHANDLERSERVICE_QNAME, features);
    }

    public ReceiveOrderHandlerService(URL wsdlLocation) {
        super(wsdlLocation, RECEIVEORDERHANDLERSERVICE_QNAME);
    }

    public ReceiveOrderHandlerService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, RECEIVEORDERHANDLERSERVICE_QNAME, features);
    }

    public ReceiveOrderHandlerService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public ReceiveOrderHandlerService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ReceiveOrderHandler
     */
    @WebEndpoint(name = "ReceiveOrderHandlerPort")
    public ReceiveOrderHandler getReceiveOrderHandlerPort() {
        return super.getPort(new QName("http://business/", "ReceiveOrderHandlerPort"), ReceiveOrderHandler.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ReceiveOrderHandler
     */
    @WebEndpoint(name = "ReceiveOrderHandlerPort")
    public ReceiveOrderHandler getReceiveOrderHandlerPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://business/", "ReceiveOrderHandlerPort"), ReceiveOrderHandler.class, features);
    }

    private static URL __getWsdlLocation() {
        if (RECEIVEORDERHANDLERSERVICE_EXCEPTION!= null) {
            throw RECEIVEORDERHANDLERSERVICE_EXCEPTION;
        }
        return RECEIVEORDERHANDLERSERVICE_WSDL_LOCATION;
    }

}