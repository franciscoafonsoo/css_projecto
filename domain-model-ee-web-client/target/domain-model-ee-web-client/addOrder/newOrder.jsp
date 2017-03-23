<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!!
See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="model" class="presentation.web.model.NewOrderModel" scope="request"/>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="/resources/app.css">
    <title>SaleSys: adicionar encomenda</title>
</head>
<body>

<h2>Escolher Fornecedor</h2>
<form action="prepararEncomendaFornecedor" method="post">
    <div class="mandatory_field">
        <label for="vat">Numero do Fornecedor:</label>
        <input type="text" name="vat" size="50" value="${model.vat}"/>
    </div>
    <div class="button" align="right">
        <input type="submit" value="Obter Fornecedor">
    </div>
</form>

<c:if test="${model.hasMessages}">

    <c:choose>
        <c:when test="${model.messages[0]=='Supplier'}">
            ${model.messages[1]}
            <h4>Resultado do Fornecedor</h4>
            <form action="prepararEncomendaProduto" method="post">
                <div class="mandatory_field">
                    <label for="productcode">Codigo Produto:</label>
                    <input type="text" name="productcode" size="50" value="${model.productcode}"/>
                </div>
                <div class="button" align="right">
                    <input type="submit" value="Obter Produto">
                </div>
            </form>
        </c:when>
        <c:when test="${model.messages[0]=='product'}">
            ${model.messages[1]}
            <br>
            <form action="novaEncomenda" method="post">
                <div class="mandatory_field">
                    <label for="vat">Codigo fornecedor:</label>
                    <input type="text" name="vat" size="50" value="${model.vat}"/>
                </div>
                <div class="mandatory_field">
                    <label for="productcode">Codigo Produto:</label>
                    <input type="text" name="productcode" size="50" value="${model.productcode}"/>
                </div>
                <div class="mandatory_field">
                    <label for="qty">Quantidade Produto a Encomendar:</label>
                    <input type="text" name="qty" size="50" value="${model.qty}"/>
                </div>
                <div class="mandatory_field">
                    <label for="deliveryDate">Data de Entrega(YYYY-MM-DD):</label>
                    <input type="text" name="deliveryDate" size="50" value="${model.deliveryDate}"/>
                </div>
                <div class="button" align="right">
                    <input type="submit" value="Encomendar">
                </div>
            </form>
        </c:when>
        <c:otherwise>
            <c:forEach var="mensagem" items="${model.messages}">
                ${mensagem}
            </c:forEach>
            <a href="../.."><input type="button" value="Menu"></a>
        </c:otherwise>
    </c:choose>
</c:if>
</body>
</html>