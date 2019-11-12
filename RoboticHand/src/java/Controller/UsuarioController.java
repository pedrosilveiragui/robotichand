/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import DAO.CidadeDAO;
import DAO.SetorDAO;
import DAO.UsuarioDAO;
import Model.Usuario;
import Model.Cidade;
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
public class UsuarioController extends HttpServlet {

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
                if (request.getParameter("cmd").equals("Cadastrar")) {
                    Usuario usuario = new Usuario(-1, request.getParameter("txtnome"), request.getParameter("txtemail"), request.getParameter("txtlogin"), request.getParameter("txtsenha"), Integer.parseInt(request.getParameter("slIDSetor")), Integer.parseInt(request.getParameter("slIDCidade")), Integer.parseInt(request.getParameter("slIDEstado")));
                    UsuarioDAO dao = new UsuarioDAO();

                    try {
                        if(dao.insert(usuario) == true){
                            out.print("Usuário Salvo com <font color = 'green'>Sucesso</font>");
                        }
                    } catch (Exception e) {
                        out.print(e.getMessage());
                    }
                }else if(request.getParameter("cmd").equals("Buscar Cidades")){
                    CidadeDAO dao = new CidadeDAO();
                    SetorDAO dao2 = new SetorDAO();
                    int idestado = Integer.parseInt(request.getParameter("slIDEstado"));
                    int idsetor = Integer.parseInt(request.getParameter("slIDSetor"));
                    try{
                        ArrayList<Cidade> arCidade = dao.RetriveByIdEstado(idestado);
                        ArrayList<Setor> arSetor = dao2.RetrieveByIdSetor(idsetor);
                        request.getSession().setAttribute("arrayCidade", arCidade);
                        request.getSession().setAttribute("arraySetor", arSetor);
                        request.setAttribute("nome", request.getParameter("txtnome"));
                        request.setAttribute("email", request.getParameter("txtemail"));
                        request.setAttribute("login", request.getParameter("txtlogin"));
                        request.setAttribute("senha", request.getParameter("txtsenha"));
                        request.setAttribute("confirm", request.getParameter("txtconfirm"));
                        request.setAttribute("idEstado", idestado);
                        request.setAttribute("idSetor", idsetor);
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/Usuario_View.jsp");
                    //request.setAttribute("arrayEstado", arEstado);
                        dispatcher.forward(request, response);
                    }catch(Exception e){
                        out.print("Erro em UsuarioController: " + e.getMessage());
                    }
                        
                }else if(request.getParameter("cmd").equals("Login")){
                    UsuarioDAO dao = new UsuarioDAO();
                    String login = request.getParameter("txtlogin");
                    String senha = request.getParameter("txtsenha");
                    try{
                        Usuario usuario = dao.retrieveByLogin(login, senha);
                        if(usuario != null){
                            request.getSession().setAttribute("user", usuario);
                            RequestDispatcher dispatcher = request.getRequestDispatcher("/Usuario_View.jsp");
                            dispatcher.forward(request, response);
                        }else{
                            out.print("Login inexistente!");
                        }

                    //request.setAttribute("arrayEstado", arEstado);

                    }catch(Exception e){
                        out.print("Erro em UsuarioController: " + e.getMessage());
                    }
                        
                }else if(request.getParameter("cmd").equals("Cadastro")){
                    try{
                        RequestDispatcher dispatcher = request.getRequestDispatcher("/Usuario_View.jsp");
                        dispatcher.forward(request, response);
                    }catch(Exception e){
                        out.print("Erro em UsuarioController: " + e.getMessage());
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
