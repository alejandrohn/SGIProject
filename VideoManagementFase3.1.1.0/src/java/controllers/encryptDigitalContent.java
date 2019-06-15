package controllers;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.DigitalContent;

@WebServlet(name = "encryptDigitalContent", urlPatterns = {"/encryptDigitalContent"})
public class encryptDigitalContent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {

            String filename = request.getParameter("fileDesencript");
            if (filename != null) {
                DigitalContent.descriptedFile(filename);
            }
        } catch (Exception ex) {
            Logger.getLogger(encryptDigitalContent.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/WEB-INF/digitalContent.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
           
//            String relativeWebPath = "/files";
//            String absoluteDiskPath = getServletContext().getRealPath(relativeWebPath);
//            String filename1 = "videoTest.mp4";
//            File file = new File(absoluteDiskPath, filename1);
//            long leng = file.length();
            String filename = request.getParameter("fileEncript");
            DigitalContent.encriptedFile(filename);
            request.getRequestDispatcher("/WEB-INF/digitalContent.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(encryptDigitalContent.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
