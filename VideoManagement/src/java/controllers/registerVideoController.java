/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.RegisterVideo;

@WebServlet(name = "registerVideoController", urlPatterns = {"/registerVideo"})
public class registerVideoController extends HttpServlet {

    private String error = "";

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (existUser(session)) {
            request.setAttribute("errorInsertVideo", false);
            request.getRequestDispatcher("/WEB-INF/registerVideo.jsp").forward(request, response);
        } else {
            request.setAttribute("errorSignIn", false);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            String title = request.getParameter("title");
            String autor = request.getParameter("autor");
            String description = request.getParameter("description");
            String format = request.getParameter("format");
            String createdDate = request.getParameter("createdDate");

            int hour = Integer.parseInt(request.getParameter("hour"));
            int minute = Integer.parseInt(request.getParameter("minute"));
            int seconds = Integer.parseInt(request.getParameter("seconds"));
            int reproductionNumber = Integer.parseInt(request.getParameter("repoductionNumber"));

            RegisterVideo rg = new RegisterVideo();
            rg.insertVideo(autor, title, description, format, createdDate, reproductionNumber, hour, minute, seconds);
//            request.getRequestDispatcher("/WEB-INF/videoList.jsp").forward(request, response);
            response.sendRedirect("videoList");
        } catch (Exception e) {
            request.setAttribute("errorInsertVideo", true);
            request.getRequestDispatcher("/WEB-INF/registerVideo.jsp").forward(request, response);

        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Boolean existUser(HttpSession session) {
        return !(session.getAttribute("userName") == null);
    }
}
