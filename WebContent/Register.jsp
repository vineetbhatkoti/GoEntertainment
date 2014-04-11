<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register</title>
</head>
<body>

<f:view><center>
<b>Please enter the following details</b></br></br></br>
<h:form>

<h:panelGrid border="1" columns="2">
					 <h:outputText value="First_Name"></h:outputText>
					 <h:inputText value="#{registerBean.first_name}"></h:inputText>
					 <h:outputText value="Last_Name"></h:outputText> 
					 <h:inputText value="#{registerBean.last_name}"/>
					 
					  <h:outputText value="User_ID"></h:outputText> 
					 <h:inputText value="#{registerBean.userid}" />
					 
					 <h:outputText value="Password"></h:outputText> 
					 <h:inputText value="#{registerBean.password }" />
					 
					  <h:outputText value="Email_ID"></h:outputText> 
					 <h:inputText value="#{registerBean.emailid}" />
					 
					 <h:outputText value="Street"></h:outputText> 
					 <h:inputText value="#{registerBean.street}" />
					 
					  <h:outputText value="City"></h:outputText> 
					 <h:inputText value="#{registerBean.city}" />
					 
					  <h:outputText value="State"></h:outputText> 
					 <h:inputText value="#{registerBean.state}" />
					
					
					 <h:outputText value="Country"></h:outputText> 
					 <h:inputText value="#{registerBean.country}" /> 
					 
					 
					 <h:outputText value="Zip_Code"></h:outputText> 
					 <h:inputText value="#{registerBean.zip_code}" /> 
					 
  
 



</h:panelGrid>
<h:commandButton value="SUBMIT" action="#{registerBean.submit_final}"></h:commandButton>
</h:form>
</center>
</f:view>
</body>
</html>