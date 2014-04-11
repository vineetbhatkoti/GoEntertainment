<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>GoEntertainment</title>
<f:loadBundle var="msg" basename="com.managedBean.message"/>
</head>
<body>
<f:view>

<h:form>
<h:commandLink value="Admin Login" action="#{loginBean.admin}"></h:commandLink>&nbsp;
<h:commandLink value="CR Login" action="#{loginBean.customerRep}"></h:commandLink>
<center><b>GOENTERTAINMENT</b></center></br></br><div align="right"><h:outputLabel  value="Use PromoCode 'DIS123' to get 10% off !!"></h:outputLabel></div>
<center></br></br></br></br></br></br></br>
<h:panelGrid border="1" columns="2">
 <h:outputText value="#{msg.name}"></h:outputText>
 <h:inputText value="#{loginBean.userName}"></h:inputText>
 <h:outputText value="#{msg.password}"></h:outputText> 

 <h:inputSecret value="#{loginBean.password }">
  
 
 </h:inputSecret>


</h:panelGrid>

<h:commandButton value="LOGIN" action="#{loginBean.authenticate}"></h:commandButton>


<h:commandButton value="SIGNUP" action="#{loginBean.register}"></h:commandButton>

 <h:outputText value="#{loginBean.message}"></h:outputText>
</center>
</br></br></br></br><center>
<h:commandLink value="Search the Store" action="#{loginBean.nonmember}"></h:commandLink>
</center>

</h:form>

</f:view>
 
 
 
 
 
</body>
</html>