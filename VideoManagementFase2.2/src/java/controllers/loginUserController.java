package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.UsersManager;

@WebServlet(name = "loginUserController", urlPatterns = {"/loginUser"})
public class loginUserController extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        if (existUser(session)) {
            response.sendRedirect("welcomePage");
        } else {
            request.setAttribute("errorSignIn", false);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");
        String urlOld = request.getParameter("oldUrl");
        try {
            HttpSession session = request.getSession();
            UsersManager userManager = new UsersManager();
            userManager.signInUser(userName, password);
            session.setAttribute("userName", userName);
            redirectToUrl(urlOld, response);
        } catch (Exception e) {
            request.setAttribute("errorSignIn", true);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public Boolean existUser(HttpSession session) {
        return !(session.getAttribute("userName") == null);
    }

    private void redirectToUrl(String urlOld, HttpServletResponse response) throws IOException {
        if (urlOld.equals("NotOldUrlSet")) {
            response.sendRedirect("welcomePage");
        } else {
            response.sendRedirect(urlOld);
        }
    }

}
