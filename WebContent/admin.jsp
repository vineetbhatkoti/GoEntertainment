<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>Hi Admin !!</center>
</br>
<a href="Logout.jsp">Log Out</a> </br>

<f:view><center>
<h:form>
</br>
</br>
</br>
</br>
 
<h:commandButton value="List Of Members" action="#{adminBean.getmember}" ></h:commandButton>
<h:commandButton value="Add Inventory" action="#{adminBean.addInventory}" ></h:commandButton>
<h:commandButton value="Update Inventory" action="#{adminBean.updateInventory}" ></h:commandButton><br><br>
<c:if test="${adminBean.member1 != null }">
 <h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="List Of Members"/>
                </f:facet>
	<h:dataTable border="1"  value="#{adminBean.member1}" var="mem">
						<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="First Name"/>
	                          </f:facet>
                          <h:outputText value="#{mem.first_name}"/>
                     </h:column>
					<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Last_Name"/>
	                          </f:facet>
                          <h:outputText value="#{mem.last_name}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Email_ID"/>
	                          </f:facet>
                          <h:outputText value="#{mem.emailid}"/>
                     </h:column>
                     
                    
                     
	
	</h:dataTable>
	
</h:panelGrid>
  </c:if>

</h:form></center>
</f:view>



</body>
</html>