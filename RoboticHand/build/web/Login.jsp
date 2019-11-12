<%-- 
    Document   : Login
    Created on : 21/10/2019, 15:10:57
    Author     : CLIENTE
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Robotic Hand</title>
    </head>
    <body>
        
        <form name="frmUsuario" action="UsuarioController">
        <table border="1">
            <tr>
                <td colspan="2" align="center">Acessar Sistema</td>
            </tr>
            <tr>
                <td>Login: </td>
                <td>
                    <input type="text" name="txtlogin" width="200" maxlength="100">
                </td>
            </tr>
            
            <tr>
                <td>Senha: </td>
                <td>
                    <input type="text" name="txtsenha" width="200" maxlength="100">
                </td>
            </tr>
            
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" name="cmd" value="Entrar">
                    <input type="submit" name="cmd" value="Cadastrar">
                </td>
            </tr>
    </body>
</html>
