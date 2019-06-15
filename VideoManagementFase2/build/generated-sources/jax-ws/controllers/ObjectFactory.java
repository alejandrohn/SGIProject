
package controllers;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the controllers package. 
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

    private final static QName _ExceptionVideo_QNAME = new QName("http://video.isdcm.me.org", "ExceptionVideo");
    private final static QName _Exception_QNAME = new QName("http://video.isdcm.me.org/", "Exception");
    private final static QName _GetVideosByAutor_QNAME = new QName("http://video.isdcm.me.org/", "getVideosByAutor");
    private final static QName _GetVideosByCreatedDate_QNAME = new QName("http://video.isdcm.me.org/", "getVideosByCreatedDate");
    private final static QName _GetVideosByAutorResponse_QNAME = new QName("http://video.isdcm.me.org/", "getVideosByAutorResponse");
    private final static QName _GetVideosByTitle_QNAME = new QName("http://video.isdcm.me.org/", "getVideosByTitle");
    private final static QName _GetVideosByCreatedDateResponse_QNAME = new QName("http://video.isdcm.me.org/", "getVideosByCreatedDateResponse");
    private final static QName _GetVideosByTitleResponse_QNAME = new QName("http://video.isdcm.me.org/", "getVideosByTitleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: controllers
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ExceptionVideo }
     * 
     */
    public ExceptionVideo createExceptionVideo() {
        return new ExceptionVideo();
    }

    /**
     * Create an instance of {@link GetVideosByTitleResponse }
     * 
     */
    public GetVideosByTitleResponse createGetVideosByTitleResponse() {
        return new GetVideosByTitleResponse();
    }

    /**
     * Create an instance of {@link GetVideosByCreatedDateResponse }
     * 
     */
    public GetVideosByCreatedDateResponse createGetVideosByCreatedDateResponse() {
        return new GetVideosByCreatedDateResponse();
    }

    /**
     * Create an instance of {@link GetVideosByAutorResponse }
     * 
     */
    public GetVideosByAutorResponse createGetVideosByAutorResponse() {
        return new GetVideosByAutorResponse();
    }

    /**
     * Create an instance of {@link GetVideosByTitle }
     * 
     */
    public GetVideosByTitle createGetVideosByTitle() {
        return new GetVideosByTitle();
    }

    /**
     * Create an instance of {@link GetVideosByCreatedDate }
     * 
     */
    public GetVideosByCreatedDate createGetVideosByCreatedDate() {
        return new GetVideosByCreatedDate();
    }

    /**
     * Create an instance of {@link GetVideosByAutor }
     * 
     */
    public GetVideosByAutor createGetVideosByAutor() {
        return new GetVideosByAutor();
    }

    /**
     * Create an instance of {@link Exception }
     * 
     */
    public Exception createException() {
        return new Exception();
    }

    /**
     * Create an instance of {@link Duration }
     * 
     */
    public Duration createDuration() {
        return new Duration();
    }

    /**
     * Create an instance of {@link Video }
     * 
     */
    public Video createVideo() {
        return new Video();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ExceptionVideo }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org", name = "ExceptionVideo")
    public JAXBElement<ExceptionVideo> createExceptionVideo(ExceptionVideo value) {
        return new JAXBElement<ExceptionVideo>(_ExceptionVideo_QNAME, ExceptionVideo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVideosByAutor }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org/", name = "getVideosByAutor")
    public JAXBElement<GetVideosByAutor> createGetVideosByAutor(GetVideosByAutor value) {
        return new JAXBElement<GetVideosByAutor>(_GetVideosByAutor_QNAME, GetVideosByAutor.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVideosByCreatedDate }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org/", name = "getVideosByCreatedDate")
    public JAXBElement<GetVideosByCreatedDate> createGetVideosByCreatedDate(GetVideosByCreatedDate value) {
        return new JAXBElement<GetVideosByCreatedDate>(_GetVideosByCreatedDate_QNAME, GetVideosByCreatedDate.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVideosByAutorResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org/", name = "getVideosByAutorResponse")
    public JAXBElement<GetVideosByAutorResponse> createGetVideosByAutorResponse(GetVideosByAutorResponse value) {
        return new JAXBElement<GetVideosByAutorResponse>(_GetVideosByAutorResponse_QNAME, GetVideosByAutorResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVideosByTitle }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org/", name = "getVideosByTitle")
    public JAXBElement<GetVideosByTitle> createGetVideosByTitle(GetVideosByTitle value) {
        return new JAXBElement<GetVideosByTitle>(_GetVideosByTitle_QNAME, GetVideosByTitle.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVideosByCreatedDateResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org/", name = "getVideosByCreatedDateResponse")
    public JAXBElement<GetVideosByCreatedDateResponse> createGetVideosByCreatedDateResponse(GetVideosByCreatedDateResponse value) {
        return new JAXBElement<GetVideosByCreatedDateResponse>(_GetVideosByCreatedDateResponse_QNAME, GetVideosByCreatedDateResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetVideosByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org/", name = "getVideosByTitleResponse")
    public JAXBElement<GetVideosByTitleResponse> createGetVideosByTitleResponse(GetVideosByTitleResponse value) {
        return new JAXBElement<GetVideosByTitleResponse>(_GetVideosByTitleResponse_QNAME, GetVideosByTitleResponse.class, null, value);
    }

}
