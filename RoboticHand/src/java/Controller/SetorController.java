/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.SetorDAO;
import Model.Setor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author CLIENTE
 */
public class SetorController extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            if (request.getParameter("cmd") != null) {
                if (request.getParameter("cmd").equals("Salvar")) {
                    Setor setor = new Setor(-1, request.getParameter("txtnome"));
                    SetorDAO dao = new SetorDAO();

                    try {
                        if (dao.insert(setor) == true) {
                            out.print("Setor Salvo com <font color = 'green'>Sucesso</font>");
                        }
                    } catch (Exception e) {
                        out.print(e.getMessage());
                    }
                } else if (request.getParameter("cmd").equals("Buscar")) {
                    SetorDAO dao = new SetorDAO();
                    ArrayList<Setor> arSetor = new ArrayList<Setor>();
                    try {
                        arSetor = dao.RetrieveAll();
                        request.getSession().setAttribute("arraySetor", arSetor);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/EstadoController?cmd=Buscar&source=Usuario_View.jsp");
                        dispatcher.forward(request, response);
                    } catch (Exception e) {
                        out.print("Erro em SetorController: " + e.getMessage());
                    }
                }
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

}
