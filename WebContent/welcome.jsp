<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome</title>
<f:loadBundle var="msg" basename="com.tutorial.message"/>
</head>
<body>
<f:view>
<h:form>
<h:outputLabel value="#{msg.welcome} #{loginBean.name}"></h:outputLabel>


</h:form>

</f:view>
</body>
</html>