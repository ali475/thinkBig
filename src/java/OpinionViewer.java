/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DataBase.DescusionJAO;
import Entities.Descussion;
import Entities.opinion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ali Mohamed
 */
public class OpinionViewer extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code. */
            String Text = request.getParameter("pram1");
            try {
                int ID = Integer.parseInt(Text);
                DescusionJAO Database = new DescusionJAO();
                Descussion current = Database.Read(ID);
                ArrayList<opinion> RandomOpinions = GenerateRand(current.getOpinions(), 5);
                int i=0;
                for (opinion RandomOpinion : RandomOpinions) {
                    request.setAttribute("id"+i, RandomOpinion.getId());
                    request.setAttribute("text"+i, RandomOpinion.getText());
                    request.setAttribute("type"+i++, RandomOpinion.getType());
                }
                request.getRequestDispatcher("opinion.jsp").forward(request, response);
            } catch (Exception e) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Servlet OpinionViewer</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Servlet input Error </h1>");
                out.println("</body>");
                out.println("</html>");
            }

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

    private ArrayList<opinion> GenerateRand(Set<opinion> opinions, int i) {
        ArrayList<opinion> Data = new ArrayList<>();
        ArrayList<opinion> result = new ArrayList<>();
        for (opinion opinion1 : opinions) {
            Data.add(opinion1);
        }
        Random rand = new Random();
        for (int j = 0; j < i; j++) {
            int randomIndex = rand.nextInt(Data.size());
            result.add(Data.get(randomIndex));
            Data.remove(randomIndex);
        }
        return result;
    }

}
