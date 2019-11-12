/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CidadeDAO;
import DAO.EstadoDAO;
import Model.Cidade;
import Model.Estado;
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
public class EstadoController extends HttpServlet {

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
            if (request.getParameter("cmd") != null) {
                if (request.getParameter("cmd").equals("Salvar")) {
                    Estado estado = new Estado(-1, request.getParameter("txtnome"), request.getParameter("txtuf"));
                    EstadoDAO dao = new EstadoDAO();

                    try {
                        if(dao.insert(estado) == true){
                            out.print("Estado Salvo com <font color = 'green'>Sucesso</font>");
                        }
                    } catch (Exception e) {
                        out.print(e.getMessage());
                    }
                }else if(request.getParameter("cmd").equals("Buscar")){
                    
                    try{
                    EstadoDAO dao = new EstadoDAO();
                    ArrayList<Estado> arEstado = dao.RetrieveAll();
                    
                    RequestDispatcher dispatcher;
                    //request.setAttribute("arrayEstado", arEstado);
                    request.getSession().setAttribute("arrayEstado", arEstado);
                    
                    if(request.getParameter("source") != null){
                        dispatcher = request.getRequestDispatcher(request.getParameter("source"));
                        
                        CidadeDAO dao2 = new CidadeDAO();
                        ArrayList<Cidade> arCidade = dao2.RetrieveAll();
                        
                        request.setAttribute("arrayCidade", arCidade);
                        
                    }else{
                        dispatcher = request.getRequestDispatcher("/Estados_View.jsp");
                    }
                    
                    dispatcher.forward(request, response);
                    
                    }catch(Exception e){
                        out.print(e.getMessage());
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
