<%-- 
    Document   : Cidades_View
    Created on : 05/09/2019, 17:25:28
    Author     : CLIENTE
--%>

<%@page import="Model.Estado"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.Cidade"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            if(request.getSession().getAttribute("user") == null){
                response.sendRedirect(request.getContextPath() + "/LoginERROR.jsp");
            }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <jsp:include page="index.jsp" />
        <%
            if(request.getAttribute("arrayEstado") == null){
                response.sendRedirect("EstadoController?cmd=Buscar&source=Cidades_View.jsp");
                
        }
            %>
        <form name="frmCidade" action="CidadeController">
        <table border="1">
            <tr>
                <td colspan="2" align="center">Cadastro de Cidades</td>
            </tr>
            <tr>
                <td>Nome: </td>
                <td>
                    <input type="text" name="txtnomecity" width="200" maxlength="100">
                </td>
            </tr>
            <tr>
                <td>Estado: </td>
                <td>
                    <select name="slIDEstado">
                        <%
                            if(request.getAttribute("arrayEstado") != null){
                                ArrayList<Estado> arEstado = (ArrayList<Estado>)(request.getAttribute("arrayEstado"));
                                for(int i = 0; i < arEstado.size(); i++){
                                    out.print("<option value=" + arEstado.get(i).ID + ">" + arEstado.get(i).Nome + "</option>");
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center"><input type="submit" name="cmd" value="Salvar"></td>
            </tr>
        </table>
                    
                    <table>
                        <tr><th>ID</th><th>Nome</th><th>Estado</th></tr>
                        
                        <%
                            if(request.getAttribute("arrayCidade") != null){
                                ArrayList<Cidade> arCidade = (ArrayList<Cidade>) (request.getAttribute("arrayCidade"));
                                for(int i = 0; i < arCidade.size(); i++){
                                    out.print("<tr><td>" + arCidade.get(i).ID + "</td>" +
                                                   "<td>" + arCidade.get(i).Nome + "</td>" +
                                                   "<td>" + arCidade.get(i).NomeEstado + "</td></tr>");
                                }
                            }
                        %>
                    </table>
                        
                    </table>
        </form>
    </body>
</html>
