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

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import models.Video;
import models.VideoList;

@WebServlet(name = "videoListController", urlPatterns = {"/videoList"})
public class videoListController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (existUser(session)) {
            List<Video> videos;
            VideoList vl = new VideoList();
            try {
                videos = vl.getVideos();
                request.setAttribute("vl", videos);
                request.getRequestDispatcher("/WEB-INF/videoList.jsp").forward(request, response);
            } catch (java.lang.Exception ex) {
                Logger.getLogger(videoListController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            request.setAttribute("errorSignIn", false);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Boolean existUser(HttpSession session) {
        return !(session.getAttribute("userName") == null);
    }

}
