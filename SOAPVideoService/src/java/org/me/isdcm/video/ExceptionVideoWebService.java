package org.me.isdcm.video;

import javax.xml.ws.WebFault;

@WebFault(name = "ExceptionVideo", targetNamespace = "http://video.isdcm.me.org")
public class ExceptionVideoWebService extends Exception {

    private ExceptionVideo faultInfo;

    public ExceptionVideoWebService(String message, ExceptionVideo faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    public ExceptionVideoWebService(String message, ExceptionVideo faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    ExceptionVideoWebService(String error_in_search_by_title, Throwable t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public ExceptionVideo getFaultInfo() {
        return faultInfo;
    }
}
