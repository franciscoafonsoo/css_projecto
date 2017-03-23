<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!!
See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.PendingOrderModel" scope="request"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/resources/app.css">
    <title>SaleSys: ver encomendas</title>
</head>
<body>
<h2>Codigo do Produto</h2>
<form action="mostrarEncomendasPendentes" method="post">
    <div class="mandatory_field">
        <label for="prodcode">Codigo do Produto: </label>
        <input type="text" name="prodcode" size="50" value="${model.prodcode}"/>
    </div>
    <div class="button" align="right">
        <input type="submit" value="Ver Encomendas do Produto">
    </div>
</form>
<c:if test="${model.hasMessages}">
    <h3>Encomendas:</h3>
    <c:forEach var="mensagem" items="${model.messages}">
    ${mensagem}
    </c:forEach>
</c:if>
<div class="button" align="right">
    <a href="../.."><input type="button" value="Back to Menu"></a>
</div>
</body>
</html>