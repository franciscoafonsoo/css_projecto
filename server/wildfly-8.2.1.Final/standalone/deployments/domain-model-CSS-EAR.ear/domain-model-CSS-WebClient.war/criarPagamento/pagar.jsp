<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--  No scriptlets!!! 
	  See http://download.oracle.com/javaee/5/tutorial/doc/bnakc.html 
-->
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="helper" class="ui.web.helpers.PayHelper" scope="request"/>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="/app.css"> 
<title>SaleSys: adicionar cliente</title>
</head>
<body>
<h2>Adicionar Cliente</h2>
<form action="realizarPagamento" method="post">
    <div class="mandatory_field">
		<label for="pagamento">Número de pessoa colectiva correspondente:</label> 
		<input type="text" name="pagamento" value="${helper.payId}"/> <br/>
    </div>
   <div class="button" align="right">
   		<input type="submit" value="Efetuar Pagamento">
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