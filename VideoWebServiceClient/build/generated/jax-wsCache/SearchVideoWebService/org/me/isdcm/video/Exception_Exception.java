
package org.me.isdcm.video;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "Exception", targetNamespace = "http://video.isdcm.me.org/")
public class Exception_Exception
    extends java.lang.Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private org.me.isdcm.video.Exception faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public Exception_Exception(String message, org.me.isdcm.video.Exception faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public Exception_Exception(String message, org.me.isdcm.video.Exception faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: org.me.isdcm.video.Exception
     */
    public org.me.isdcm.video.Exception getFaultInfo() {
        return faultInfo;
    }

}
