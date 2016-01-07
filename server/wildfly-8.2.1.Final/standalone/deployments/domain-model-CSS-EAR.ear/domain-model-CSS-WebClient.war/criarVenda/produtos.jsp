<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="helper" class="ui.web.helpers.AddProductHelper" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/app.css"> 
<title>SaleSys: adicionar produto</title>
</head>
<body>
<h2>Adicionar Produto</h2>
<form action="criarProdutos" method="post">
    <div class="mandatory_field">
		<label for="venda">Número de Venda:</label> 
		<input type="text" name="venda" value="${helper.saleId}"/> <br/>
    </div>
    <div class="mandatory_field">
		<label for="produto">Número de Produto:</label> 
		<input type="text" name="produto" value="${helper.prodId}"/> <br/>
    </div>
    <div class="mandatory_field">
		<label for="quant">Quantidade:</label> 
		<input type="text" name="quant" value="${helper.quant}"/> <br/>
    </div>
   <div class="button" align="right">
   		<input type="submit" value="Adicionar Produto">
   </div>
</form>


<c:if test="${helper.hasMessages}">
	<p>Mensagens</p>
	<ul>
	<c:forEach var="mensagem" items="${helper.messages}">
		<li>${mensagem} 
	</c:forEach>
	</ul>
</c:if>
</body>
</html>