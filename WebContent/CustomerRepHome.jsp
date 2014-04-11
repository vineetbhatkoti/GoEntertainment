<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CR HOME</title>
</head>
<body>
<f:view>
<a href="Logout.jsp">Log Out</a><center>
<h:form>
  </br></br></br></br></br>
<h:commandButton value="Search Inventory & Reserve" action="#{customerRepBean.search}" ></h:commandButton>
<h:commandButton value="Confirm Order" action="#{customerRepBean.confirmOrder}" ></h:commandButton>
<h:commandButton value="Email: Request Restock" action="#{customerRepBean.sendEmail}" ></h:commandButton>
</br>
</br>
 <h:outputText value="#{customerRepBean.message }"/>
</h:form></center></f:view>
</body>
</html>