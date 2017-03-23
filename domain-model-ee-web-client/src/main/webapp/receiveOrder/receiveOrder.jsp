<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!!
See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.ReceiveOrderModel" scope="request"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/resources/app.css">
    <title>SaleSys: receber uma encomenda</title>
</head>
<body>
<h2>Codigo do Fornecedor</h2>
<form action="receberATalEncomenda" method="post">
    <div class="mandatory_field">
        <label for="vat">Codigo do Fornecedor: </label>
        <input type="text" name="vat" size="50" value="${model.vat}"/>
    </div>
    <div class="button" align="right">
        <input type="submit" value="Ver Encomendas do Fornecedor">
    </div>
</form>
<c:if test="${model.hasMessages}">
    <c:choose>
        <c:when test="${model.messages[0] == 'supplier'}">
            <c:forEach var="mensagem" items="${model.messages}">
                <c:if test="${mensagem != 'supplier'}">
                    ${mensagem}
                </c:if>
            </c:forEach>
            <form action="registarATalEncomenda" method="post">
                <div class="mandatory_field">
                    <label for="id">Id da encomenda:</label>
                    <input type="text" name="id" size="50" value="${model.id}"/>
                </div>
                <div class="mandatory_field">
                    <label for="qty">Quantidade Recebida:</label>
                    <input type="text" name="qty" size="50" value="${model.qty}"/>
                </div>
                <div class="button" align="right">
                    <input type="submit" value="Registar encomenda recebida">
                </div>
            </form>
        </c:when>
        <c:otherwise>
            <c:forEach var="mensagem" items="${model.messages}">
                ${mensagem}
            </c:forEach>
        </c:otherwise>
    </c:choose>
</c:if>
<div class="button" align="right">
    <a href="../.."><input type="button" value="Back to Menu"></a>
</div>
</body>
</html>