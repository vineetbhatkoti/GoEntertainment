<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thanks !!</title>
</head>
<body>
 <a href="Logout.jsp">Log Out</a></br></br></br></br>
<center>
 <f:view>
 <h:form>
 <c:if test="${searchSongBean.cart != null }">
<h:panelGrid border="1" columns="2">
	<h:outputText value="Your Total Price Is:"></h:outputText>
	<h:outputText value="#{searchSongBean.totalPrice}"></h:outputText>
	</h:panelGrid>
</c:if>


<c:if test="${searchMovieBean.cart != null }">
<h:panelGrid border="1" columns="2">
	<h:outputText value="Your Total Price Is:"></h:outputText>
	<h:outputText value="#{searchMovieBean.totalPrice}"></h:outputText>
	</h:panelGrid>
</c:if>

<br><br><br>
Thanks For Your Order !! 
Have A Great Day.  :) </center>


</h:form>
</f:view>
</body>
</html>