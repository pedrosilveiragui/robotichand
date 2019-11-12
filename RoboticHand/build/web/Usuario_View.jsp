<%-- 
    Document   : Usuario_View
    Created on : 24/09/2019, 09:48:15
    Author     : CLIENTE
--%>

<%@page import="Model.Setor"%>
<%@page import="Model.Cidade"%>
<%@page import="Model.Estado"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Robotic Hand</title>
    </head>
    <body>
        
        <%
            if(request.getSession().getAttribute("arraySetor") == null){
                response.sendRedirect("SetorController?cmd=Buscar&source=Usuario_View.jsp");
            }
            
            /*if(request.getSession().getAttribute("arrayEstado") == null){
                response.sendRedirect("EstadoController?cmd=Buscar&source=Usuario_View.jsp");   
            }*/

        %>
        
        <form name="frmUsuario" action="UsuarioController">
        <table border="1">
            <tr>
                <td colspan="2" align="center">Cadastro de Usuários</td>
            </tr>
            <tr>
                <td>Nome: </td>
                <td>
                    <input type="text" name="txtnome" width="200" maxlength="100" value ="<% if(request.getAttribute("nome") != null) { out.print(request.getAttribute("nome")); } %>" >
                </td>
            </tr>
            
            <tr>
                <td>E-mail: </td>
                <td>
                    <input type="text" name="txtemail" width="200" maxlength="100" value ="<% if(request.getAttribute("email") != null) { out.print(request.getAttribute("email")); } %>" >
                </td>
            </tr>
            
            <tr>
                <td>Login: </td>
                <td>
                    <input type="text" name="txtlogin" width="200" maxlength="100" value ="<% if(request.getAttribute("login") != null) { out.print(request.getAttribute("login")); } %>" >
                </td>
            </tr>
            
            <tr>
                <td>Senha: </td>
                <td>
                    <input type="password" name="txtsenha" width="200" maxlength="100" value ="<% if(request.getAttribute("senha") != null) { out.print(request.getAttribute("senha")); } %>" >
                </td>
            </tr>
            
            <tr>
                <td>Confirmaçao: </td>
                <td>
                    <input type="password" name="txtconfirm" width="200" maxlength="100" value ="<% if(request.getAttribute("confirm") != null) { out.print(request.getAttribute("confirm")); } %>" >
                </td>
            </tr>
            
            <tr>
                <td>Setor </td>
                <td>
                    <select name="slIDSetor">
                        <%
                            if(request.getSession().getAttribute("arraySetor") != null){
                                ArrayList<Setor> arSetor = (ArrayList<Setor>)(request.getSession().getAttribute("arraySetor"));
                                for(int i = 0; i < arSetor.size(); i++){
                                    out.print("<option value=" + arSetor.get(i).ID + ">" + arSetor.get(i).Nome + "</option>");
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            
            <tr>
                <td>Estado: </td>
                <td>
                    <select name="slIDEstado">
                        <%
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
                        %>
                    </select>
                    <input type="submit" name="cmd" value="Buscar Cidades">
                </td>
            </tr>
            
            <tr>
                <td>Cidade: </td>
                <td>
                    <select name="slIDCidade">
                        <%
                            if(request.getSession().getAttribute("arrayCidade") != null){
                                ArrayList<Cidade> arCidade = (ArrayList<Cidade>)(request.getSession().getAttribute("arrayCidade"));
                                for(int i = 0; i < arCidade.size(); i++){
                                    out.print("<option value=" + arCidade.get(i).ID + ">" + arCidade.get(i).Nome + "</option>");
                                }
                            }
                        %>
                    </select>
                </td>
            </tr>
            
            <td colspan="2" align="center">
                    <input type="submit" name="cmd" value="Cadastrar">
            </td>
            
        </table>
        </form>
    </body>
</html>
