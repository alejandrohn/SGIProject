/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.ParserConfigurationException;
import models.EncryptResource;
import org.xml.sax.SAXException;

/**
 *
 * @author alejandro
 */
@WebServlet(name = "encryptController", urlPatterns = {"/encrypt"})
public class encryptController extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
           
            String filename = request.getParameter("docXMLToDesencript");
            EncryptResource.desencryptDocument(filename);
            request.getRequestDispatcher("/WEB-INF/encrypt.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(encryptController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String filename = request.getParameter("docXMLToEncript");
            EncryptResource.encryptDocument(filename);
            request.getRequestDispatcher("/WEB-INF/encrypt.jsp").forward(request, response);
        } catch (Exception ex) {
            Logger.getLogger(encryptController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
