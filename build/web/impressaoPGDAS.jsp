<%-- 
    Document   : impressaoPGDAS
    Created on : 03/10/2014, 13:29:29
    Author     : issqn
--%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<jsp:useBean id="pgdas" class="br.jonatas.Simples.Modelo.PGDAS"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Impressão PGDAS</title>
    </head>
    <body>
        <form name="form" action="pgdasControleImpressao" method="POST">
            <table border="0">
                <tbody>
                    <tr>
                        <td>Competência:</td>
                        <td><input type="text" name="pa" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td>CNPJ</td>
                        <td><input type="text" name="cnpj" value="" size="20" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Buscar" name="enviar" /></td>
                        <td></td>
                    </tr>
                </tbody>
            </table>
            <%--<c:if test="${not empty listaPgdas}">
            <c:forEach  items="${listaPgdas}" var="item">
                ${item.pa}
            </c:forEach>
            </c:if>
            --%>
            
            <c:forEach  items="${listaPgdas}" var="pgdas">
                ${pgdas.pa}
                ${pgdas.aliquota}
                ${pgdas.razao} <br />
            </c:forEach>
            
        </form>
    </body>
</html>
