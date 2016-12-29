<%-- 
    Document   : list
    Created on : Dec 3, 2016, 2:12:28 PM
    Author     : regis
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset=UTF-8>
        <title>Livros de java, Android, Iphone, PHP, Ruby e muito mais -
            Casa do código</title>
    </head>
    <body>
        <div>${mensagem}</div>
        <table>
            <tr>
                <td>Título</td>
                <td>Descrição</td>
                <td>Páginas</td>
            </tr>

            <c:forEach items="${produtos }" var="produto">
                <tr>
                    <td>
                        <a href="${s:mvcUrl('PC#detail').arg(0, produto.id).build()}">
                            ${produto.titulo}
                        </a>
                    </td>
                    <td>${produto.descricao }</td>
                    <td>${produto.paginas }</td>
                </tr>
            </c:forEach>

        </table>
    </body>
</html>