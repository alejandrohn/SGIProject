
package controllers;

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
     * @param autor
     * @return
     *     returns java.util.List<controllers.Video>
     * @throws ExceptionVideoWebService
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVideosByAutor", targetNamespace = "http://video.isdcm.me.org/", className = "controllers.GetVideosByAutor")
    @ResponseWrapper(localName = "getVideosByAutorResponse", targetNamespace = "http://video.isdcm.me.org/", className = "controllers.GetVideosByAutorResponse")
    @Action(input = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByAutorRequest", output = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByAutorResponse", fault = {
        @FaultAction(className = ExceptionVideoWebService.class, value = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByAutor/Fault/ExceptionVideoWebService"),
        @FaultAction(className = Exception_Exception.class, value = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByAutor/Fault/Exception")
    })
    public List<Video> getVideosByAutor(
        @WebParam(name = "autor", targetNamespace = "")
        String autor)
        throws ExceptionVideoWebService, Exception_Exception
    ;

    /**
     * 
     * @param title
     * @return
     *     returns java.util.List<controllers.Video>
     * @throws ExceptionVideoWebService
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVideosByTitle", targetNamespace = "http://video.isdcm.me.org/", className = "controllers.GetVideosByTitle")
    @ResponseWrapper(localName = "getVideosByTitleResponse", targetNamespace = "http://video.isdcm.me.org/", className = "controllers.GetVideosByTitleResponse")
    @Action(input = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByTitleRequest", output = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByTitleResponse", fault = {
        @FaultAction(className = ExceptionVideoWebService.class, value = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByTitle/Fault/ExceptionVideoWebService"),
        @FaultAction(className = Exception_Exception.class, value = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByTitle/Fault/Exception")
    })
    public List<Video> getVideosByTitle(
        @WebParam(name = "title", targetNamespace = "")
        String title)
        throws ExceptionVideoWebService, Exception_Exception
    ;

    /**
     * 
     * @param createdDate
     * @return
     *     returns java.util.List<controllers.Video>
     * @throws ExceptionVideoWebService
     * @throws Exception_Exception
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getVideosByCreatedDate", targetNamespace = "http://video.isdcm.me.org/", className = "controllers.GetVideosByCreatedDate")
    @ResponseWrapper(localName = "getVideosByCreatedDateResponse", targetNamespace = "http://video.isdcm.me.org/", className = "controllers.GetVideosByCreatedDateResponse")
    @Action(input = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByCreatedDateRequest", output = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByCreatedDateResponse", fault = {
        @FaultAction(className = ExceptionVideoWebService.class, value = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByCreatedDate/Fault/ExceptionVideoWebService"),
        @FaultAction(className = Exception_Exception.class, value = "http://video.isdcm.me.org/SearchVideoWebService/getVideosByCreatedDate/Fault/Exception")
    })
    public List<Video> getVideosByCreatedDate(
        @WebParam(name = "createdDate", targetNamespace = "")
        String createdDate)
        throws ExceptionVideoWebService, Exception_Exception
    ;

}
