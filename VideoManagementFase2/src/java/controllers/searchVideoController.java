package controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebServiceRef;

@WebServlet(name = "searchVideoController", urlPatterns = {"/searchVideo"})
public class searchVideoController extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/SOAPVideoService/SearchVideoWebService.wsdl")
    private SearchVideoWebService_Service service;

    private final String AUTOR_VALUE = "0";
    private final String TITLE_VALUE = "1";
    private final String CREATEDDATE_VALUE = "2";

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();

        if (existUser(session)) {
            request.getRequestDispatcher("/WEB-INF/searchVideoByPattern.jsp").forward(request, response);
        } else {
            request.setAttribute("errorSignIn", false);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String searchPattern = request.getParameter("searchPatternValue");
        String selectedOption = request.getParameter("searchPatternOptionSelected");
        List<controllers.Video> selectedVideos;

        try {
            selectedVideos = getVideosByPatternSelected(selectedOption, searchPattern);
            setAttributeOfVideoSearch(searchPattern, selectedOption, selectedVideos, request);
            request.getRequestDispatcher("/WEB-INF/searchVideoByPattern.jsp").forward(request, response);
        } catch (Exception_Exception | ExceptionVideoWebService ex) {
            response.sendRedirect("searchVideo");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Boolean existUser(HttpSession session) {
        return !(session.getAttribute("userName") == null);
    }

    private void setAttributeOfVideoSearch(String searchPattern, String selectedOption, List<controllers.Video> selectedVideos, HttpServletRequest request) {
        request.setAttribute("searchPattern", searchPattern);
        request.setAttribute("selectedOption", selectedOption);
        request.setAttribute("selectedVideos", selectedVideos);

    }

    private List<controllers.Video> getVideosByPatternSelected(String selectedOption, String patternToFind) throws Exception_Exception, ExceptionVideoWebService {
        switch (selectedOption) {
            case AUTOR_VALUE:
                return getVideosByAutor(patternToFind);
            case TITLE_VALUE:
                return getVideosByTitle(patternToFind);
            case CREATEDDATE_VALUE:
                return getVideosByCreatedDate(patternToFind);
            default:
                return new ArrayList<>();
        }
    }

    private java.util.List<controllers.Video> getVideosByTitle(java.lang.String title) throws ExceptionVideoWebService, Exception_Exception {
        controllers.SearchVideoWebService port = service.getSearchVideoWebServicePort();
        return port.getVideosByTitle(title);
    }

    private java.util.List<controllers.Video> getVideosByAutor(java.lang.String autor) throws Exception_Exception, ExceptionVideoWebService {
        controllers.SearchVideoWebService port = service.getSearchVideoWebServicePort();
        return port.getVideosByAutor(autor);
    }

    private java.util.List<controllers.Video> getVideosByCreatedDate(java.lang.String createdDate) throws Exception_Exception, ExceptionVideoWebService {
        controllers.SearchVideoWebService port = service.getSearchVideoWebServicePort();
        return port.getVideosByCreatedDate(createdDate);
    }
}
