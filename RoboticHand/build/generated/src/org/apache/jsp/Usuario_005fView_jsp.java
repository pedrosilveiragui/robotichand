package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import Model.Setor;
import Model.Cidade;
import Model.Estado;
import java.util.ArrayList;

public final class Usuario_005fView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        \n");
      out.write("        ");

            if(request.getSession().getAttribute("arraySetor") == null){
                response.sendRedirect("SetorController?cmd=Buscar&source=Usuario_View.jsp");
            }
            
            /*if(request.getSession().getAttribute("arrayEstado") == null){
                response.sendRedirect("EstadoController?cmd=Buscar&source=Usuario_View.jsp");   
            }*/

        
      out.write("\n");
      out.write("        \n");
      out.write("        <form name=\"frmUsuario\" action=\"UsuarioController\">\n");
      out.write("        <table border=\"1\">\n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\" align=\"center\">Cadastro de Usuários</td>\n");
      out.write("            </tr>\n");
      out.write("            <tr>\n");
      out.write("                <td>Nome: </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"txtnome\" width=\"200\" maxlength=\"100\" value =\"");
 if(request.getAttribute("nome") != null) { out.print(request.getAttribute("nome")); } 
      out.write("\" >\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>E-mail: </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"txtemail\" width=\"200\" maxlength=\"100\" value =\"");
 if(request.getAttribute("email") != null) { out.print(request.getAttribute("email")); } 
      out.write("\" >\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>Login: </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"text\" name=\"txtlogin\" width=\"200\" maxlength=\"100\" value =\"");
 if(request.getAttribute("login") != null) { out.print(request.getAttribute("login")); } 
      out.write("\" >\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>Senha: </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"password\" name=\"txtsenha\" width=\"200\" maxlength=\"100\" value =\"");
 if(request.getAttribute("senha") != null) { out.print(request.getAttribute("senha")); } 
      out.write("\" >\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>Confirmaçao: </td>\n");
      out.write("                <td>\n");
      out.write("                    <input type=\"password\" name=\"txtconfirm\" width=\"200\" maxlength=\"100\" value =\"");
 if(request.getAttribute("confirm") != null) { out.print(request.getAttribute("confirm")); } 
      out.write("\" >\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>Setor </td>\n");
      out.write("                <td>\n");
      out.write("                    <select name=\"slIDSetor\">\n");
      out.write("                        ");

                            if(request.getSession().getAttribute("arraySetor") != null){
                                ArrayList<Setor> arSetor = (ArrayList<Setor>)(request.getSession().getAttribute("arraySetor"));
                                for(int i = 0; i < arSetor.size(); i++){
                                    out.print("<option value=" + arSetor.get(i).ID + ">" + arSetor.get(i).Nome + "</option>");
                                }
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>Estado: </td>\n");
      out.write("                <td>\n");
      out.write("                    <select name=\"slIDEstado\">\n");
      out.write("                        ");

                            if(request.getSession().getAttribute("arrayEstado") != null){
                                ArrayList<Estado> arEstado = (ArrayList<Estado>)(request.getSession().getAttribute("arrayEstado"));
                                for(int i = 0; i < arEstado.size(); i++){
                                    if(request.getAttribute("idEstado") != null){
                                        if(Integer.parseInt(request.getAttribute("idEstado").toString()) == arEstado.get(i).ID){
                                            out.print("<option value=" + arEstado.get(i).ID + " selected>" + arEstado.get(i).Nome + "</option>");
                                        }else{
                                            out.print("<option value=" + arEstado.get(i).ID + ">" + arEstado.get(i).Nome + "</option>");
                                        }
                                    }else{
                                        out.print("<option value=" + arEstado.get(i).ID + ">" + arEstado.get(i).Nome + "</option>");
                                    }
                                    
                                }
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                    <input type=\"submit\" name=\"cmd\" value=\"Buscar Cidades\">\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td>Cidade: </td>\n");
      out.write("                <td>\n");
      out.write("                    <select name=\"slIDCidade\">\n");
      out.write("                        ");

                            if(request.getSession().getAttribute("arrayCidade") != null){
                                ArrayList<Cidade> arCidade = (ArrayList<Cidade>)(request.getSession().getAttribute("arrayCidade"));
                                for(int i = 0; i < arCidade.size(); i++){
                                    out.print("<option value=" + arCidade.get(i).ID + ">" + arCidade.get(i).Nome + "</option>");
                                }
                            }
                        
      out.write("\n");
      out.write("                    </select>\n");
      out.write("                </td>\n");
      out.write("            </tr>\n");
      out.write("            \n");
      out.write("            <tr>\n");
      out.write("                <td colspan=\"2\"><input type=\"submit\" name=\"cmd\" value=\"Cadastrar\"></td>\n");
      out.write("            </tr>\n");
      out.write("        </table>\n");
      out.write("        </form>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
