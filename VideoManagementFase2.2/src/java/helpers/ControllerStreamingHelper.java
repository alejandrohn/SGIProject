package helpers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import models.ManagerReproductionsNumberService;
import models.Video;
import models.VideoPath;

public class ControllerStreamingHelper {

    public static void updateReproductionsNumberAndGetVideoToPlay(int videoId, String title, HttpServletRequest request) throws Exception {
        int newReproductionsNumber = updateReproductionsNumberAndGetNewNumber(videoId, request);
        Video video = new VideoPath().getVideoToPlay(videoId);
        setRequestValues(video, newReproductionsNumber, title, request);
    }

    private static void setRequestValues(Video video, int newReproductionsNumber, String title, HttpServletRequest request) {
        request.setAttribute("video", video);
        request.setAttribute("title", title);
        request.setAttribute("reproductionsNumber", newReproductionsNumber);
    }

    private static int updateReproductionsNumberAndGetNewNumber(int videoId, HttpServletRequest request) throws Exception {
        HttpSession session = request.getSession();
        return ManagerReproductionsNumberService.updateReproductionsNumber(videoId, (String) session.getAttribute("userName"));
    }
}
