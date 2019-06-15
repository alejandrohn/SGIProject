package org.me.isdcm.video;

import org.me.isdcm.video.helpers.Video;
import org.me.isdcm.video.helpers.ActionManager;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.soap.SOAPException;
import org.me.isdcm.video.SearchPatternsClasses.AutorPattern;
import org.me.isdcm.video.SearchPatternsClasses.CreatedDatePattern;
import org.me.isdcm.video.SearchPatternsClasses.IVideoQuery;
import org.me.isdcm.video.SearchPatternsClasses.TitlePattern;

@WebService(serviceName = "SearchVideoWebService")
public class SearchVideoWebService {

    ActionManager actionManager = new ActionManager();
    List<Video> videoList;

    /**
     *
     * @param title
     * @return
     * @throws org.me.isdcm.video.ExceptionVideoWebService
     */
    @WebMethod(operationName = "getVideosByTitle")
    public List<Video> getVideosByTitle(@WebParam(name = "title") String title) throws ExceptionVideoWebService, Exception {

        TitlePattern titlePattern = new TitlePattern(title);
        videoList = actionManager.getVideosByPattern(titlePattern);
        checkException(titlePattern);

        return videoList;
    }

    @WebMethod(operationName = "getVideosByAutor")
    public List<Video> getVideosByAutor(@WebParam(name = "autor") String autor) throws ExceptionVideoWebService, Exception {

        AutorPattern autorPattern = new AutorPattern(autor);
        videoList = actionManager.getVideosByPattern(autorPattern);
        checkException(autorPattern);

        return videoList;
    }

    @WebMethod(operationName = "getVideosByCreatedDate")
    public List<Video> getVideosByCreatedDate(@WebParam(name = "createdDate") String createdDate) throws ExceptionVideoWebService, Exception {

        CreatedDatePattern createdDatePattern = new CreatedDatePattern(createdDate);
        videoList = actionManager.getVideosByPattern(createdDatePattern);
        checkException(createdDatePattern);

        return videoList;
    }

    private void checkException(IVideoQuery pattern) throws Exception {
        if (videoList.isEmpty()) {
            throw new Exception("Error in search videos by autor, empty jejejeje" + pattern.getToString());
        }
    }
}
