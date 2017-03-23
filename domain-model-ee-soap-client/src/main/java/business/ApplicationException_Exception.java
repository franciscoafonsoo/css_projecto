
package business;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "ApplicationException", targetNamespace = "http://business/")
public class ApplicationException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private ApplicationException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public ApplicationException_Exception(String message, ApplicationException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public ApplicationException_Exception(String message, ApplicationException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: business.ApplicationException
     */
    public ApplicationException getFaultInfo() {
        return faultInfo;
    }

}