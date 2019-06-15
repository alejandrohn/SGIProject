package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import helpers.ControllerStreamingHelper;

@WebServlet(name = "StreamingVideoController", urlPatterns = {"/StreamingVideo"})
public class StreamingVideoController extends HttpServlet {

    private final String jspPageForStreaming = "/WEB-INF/showVideoStreaming.jsp";
    private final String jspPageForServiceError = "/WEB-INF/errorPage.jsp";
    private final String jspPageForLogin = "/WEB-INF/login.jsp";
    private HttpSession session;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        initHttpElements(request);
        if (existUser(session)) {
            request.getRequestDispatcher(jspPageForServiceError).forward(request, response);
        } else {
            request.setAttribute("errorSignIn", false);
            request.getRequestDispatcher(jspPageForLogin).forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        initHttpElements(request);
        if (existUser(session)) {
            int videoId = Integer.parseInt(request.getParameter("id"));
            String title = request.getParameter("title");
            try {
                ControllerStreamingHelper.updateReproductionsNumberAndGetVideoToPlay(videoId, title, request);
                request.getRequestDispatcher(jspPageForStreaming).forward(request, response);
            } catch (Exception e) {
                request.getRequestDispatcher(jspPageForServiceError).forward(request, response);
            }
        } else {
            request.setAttribute("errorSignIn", false);
            request.getRequestDispatcher(jspPageForLogin).forward(request, response);
        }
    }

    public Boolean existUser(HttpSession session) {
        return !(session.getAttribute("userName") == null);
    }

    private void initHttpElements(HttpServletRequest request) {
        this.session = request.getSession();
    }
}
