<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Representative</title>
</head>
<body>
<f:view>

<h:form>
<center></br></br></br></br></br></br></br>
<h:panelGrid border="1" columns="2">
 <h:outputText value="CRUserName"></h:outputText>
 <h:inputText value="#{customerRepBean.cusRepName}"></h:inputText>
 <h:outputText value="Password"></h:outputText> 

 <h:inputSecret value="#{customerRepBean.password }">
  
 
 </h:inputSecret>


</h:panelGrid>
 <h:outputText value="#{customerRepBean.message}"></h:outputText> 
<h:commandButton value="LOGIN" action="#{customerRepBean.CRAuthenticate}"></h:commandButton>
</center>
</h:form></f:view>
</body>
</html>