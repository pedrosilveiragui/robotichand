<%-- 
    Document   : Cidades_View
    Created on : 05/09/2019, 14:56:00
    Author     : CLIENTE
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Model.Estado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%
            if(request.getSession().getAttribute("user") == null){
                response.sendRedirect(request.getContextPath() + "/LoginERROR.jsp");
            }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
        <title>JSP Page</title>
    </head>
    <body>
        
        <jsp:include page="index.jsp" />
        <form name="frmEstado" action="EstadoController">
        <table border="1">
            <tr>
                <td colspan="2" align="center">Cadastro de Estados</td>
            </tr>
            <tr>
                <td>Nome: </td>
                <td>
                    <input type="text" name="txtnome" width="200" maxlength="100">
                </td>
            </tr>
            <tr>
                <td>UF: </td>
                <td>
                    <input type="text" name="txtuf">
                </td>
            </tr>
            <tr>
                <td><input type="submit" name="cmd" value="Salvar"></td>
                <td><input type="submit" name="cmd" value="Buscar"></td>
            </tr>
        </table>
            
          <table>
              <tr><th>ID</th><th>Nome</th><th>UF</th></tr>
              
              <%
                 if(request.getAttribute("arrayEstado") != null){
                     ArrayList<Estado> arEstado = (ArrayList<Estado>)(request.getAttribute("arrayEstado"));
                     for(int i =0; i < arEstado.size(); i++){
                         out.print("<tr><td>" + arEstado.get(i).ID + "</td>"+
                                       "<td>" + arEstado.get(i).Nome + "</td>" +
                                       "<td>" + arEstado.get(i).UF + "</td></tr>");
                     }
                 } 
              %>
          </table>
        </form>
        

    </body>
</html>
