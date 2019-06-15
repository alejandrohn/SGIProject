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
import models.UsersManager;

@WebServlet(name = "registerUserController", urlPatterns = {"/registerUser"})
public class registerUserController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private Exception error;

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
        request.setAttribute("errorInCreateUser", false);
        request.setAttribute("errorInPasswordUser", false);
        request.setAttribute("errorInEmptyValues", false);

        if (!(session.getAttribute("userName") == null)) {
            response.sendRedirect("welcomePage");
        } else {
            request.getRequestDispatcher("/WEB-INF/registerUser.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("firstName");
        String surname = request.getParameter("surname");
        String email = request.getParameter("email");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");
        String confirmPassword = request.getParameter("confirmPassword");
       
        UsersManager userManager = new UsersManager();
        HttpSession session = request.getSession();
        try {

            if (checkPassword(password, confirmPassword) && !checkEmptyValues(firstName, email, userName)) {
                userManager.insertNewUser(firstName, surname, email, userName, password);
                session.setAttribute("userName", userName);
                response.sendRedirect("welcomePage");
            } else {
                request.setAttribute("errorInCreateUser", false);
                request.setAttribute("errorInPasswordUser", true);
                request.setAttribute("errorInEmptyValues", true);
                request.getRequestDispatcher("/WEB-INF/registerUser.jsp").forward(request, response);
            }
        } catch (Exception e) {
            error = e;
            request.setAttribute("errorInCreateUser", true);
            request.setAttribute("errorInPasswordUser", false);
            request.setAttribute("errorInEmptyValues", false);
            request.getRequestDispatcher("/WEB-INF/registerUser.jsp").forward(request, response);
        }

    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    public boolean checkPassword(String password, String confirmPassword) {
        return password.equals(confirmPassword);
    }

    private boolean checkEmptyValues(String firstName, String email, String userName) throws Exception {
        return (firstName.equals("") || email.equals("") || userName.equals(""));
    }

}
