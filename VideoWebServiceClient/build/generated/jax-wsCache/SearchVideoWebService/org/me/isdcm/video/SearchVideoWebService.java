
package org.me.isdcm.video;

import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.FaultAction;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.10-b140803.1500
 * Generated source version: 2.2
 * 
 */
@WebService(name = "SearchVideoWebService", targetNamespace = "http://video.isdcm.me.org/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface SearchVideoWebService {


    /**
     * 
     * @param name
     * @return
     *     returns java.util.List<org.me.isdcm.video.Video>
     * @throws ExceptionWebService
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVideosByTitle", targetNamespace = "http://video.isdcm.me.org/", className = "org.me.isdcm.video.GetVideosByTitle")
    @ResponseWrapper(localName = "getVideosByTitleResponse", targetNamespace = "http://video.isdcm.me.org/", className = "org.me.isdcm.video.GetVideosByTitleResponse")
    @Action(input = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByTitleRequest", output = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByTitleResponse", fault = {
        @FaultAction(className = ExceptionWebService.class, value = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByTitle/Fault/ExceptionWebService"),
        @FaultAction(className = Exception_Exception.class, value = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByTitle/Fault/Exception")
    })
    public List<Video> getVideosByTitle(
        @WebParam(name = "name", targetNamespace = "")
        String name)
        throws ExceptionWebService, Exception_Exception
    ;

}