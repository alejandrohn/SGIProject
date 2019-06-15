
package org.me.isdcm.video;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.me.isdcm.video package. 
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

    private final static QName _Exception_QNAME = new QName("http://video.isdcm.me.org/", "Exception");
    private final static QName _GetVideosByTitle_QNAME = new QName("http://video.isdcm.me.org/", "getVideosByTitle");
    private final static QName _MyException_QNAME = new QName("http://video.isdcm.me.org", "MyException");
    private final static QName _GetVideosByTitleResponse_QNAME = new QName("http://video.isdcm.me.org/", "getVideosByTitleResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.me.isdcm.video
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link MyException }
     * 
     */
    public MyException createMyException() {
        return new MyException();
    }

    /**
     * Create an instance of {@link GetVideosByTitleResponse }
     * 
     */
    public GetVideosByTitleResponse createGetVideosByTitleResponse() {
        return new GetVideosByTitleResponse();
    }

    /**
     * Create an instance of {@link GetVideosByTitle }
     * 
     */
    public GetVideosByTitle createGetVideosByTitle() {
        return new GetVideosByTitle();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Exception }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org/", name = "Exception")
    public JAXBElement<Exception> createException(Exception value) {
        return new JAXBElement<Exception>(_Exception_QNAME, Exception.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link MyException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://video.isdcm.me.org", name = "MyException")
    public JAXBElement<MyException> createMyException(MyException value) {
        return new JAXBElement<MyException>(_MyException_QNAME, MyException.class, null, value);
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
