/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBase.HashtagJAO;
import DataBase.OpinionJAO;
import Entities.HashTag;
import Entities.opinion;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ali Mohamed
 */
@WebServlet(urlPatterns = {"/SaveHashTags"})
public class SaveHashTags extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            if (request.getCharacterEncoding() == null) {
                request.setCharacterEncoding("UTF-8");
            }
            /* TODO output your page here. You may use following sample code. */

            int[] IDs = new int[5];
            opinion[] opinions = new opinion[5];
            OpinionJAO database = new OpinionJAO();
            HashtagJAO hashtagJAO = new HashtagJAO();
            for (int i = 0; i < 5; i++) {
                IDs[i] = Integer.parseInt(request.getParameter("ID" + i));
                opinions[i] = database.Read(IDs[i]);

            }

            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    HashTag template = new HashTag();
                    String text = request.getParameter("HashTag" + i + "" + j);
                    template.setText(text);
                    template.setOp(opinions[i]);
                    hashtagJAO.Insert(template);

                }

            }
            response.sendRedirect("ThankYou.html");
        }

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
