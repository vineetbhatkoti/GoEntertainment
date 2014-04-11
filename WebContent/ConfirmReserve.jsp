<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Confirm Reserve</title>
</head>
<body>
<a href="Logout.jsp">Log Out</a>
<f:view><center>
<h:form>
 	 <c:set target="${searchSongBean}" property="branchid" value="${customerRepBean.branchid}"/>
    <c:set target="${searchMovieBean}" property="branchid" value="${customerRepBean.branchid}"/>
	<h:selectOneMenu  id="select_sm" value="#{searchSongBean.value}" onchange="submit()" immediate="true">
		<f:selectItem itemLabel="Please select one"/>
        <f:selectItem itemValue="1" itemLabel="Songs"/>
        <f:selectItem itemValue="2" itemLabel="Movies"/>
    </h:selectOneMenu>

  </h:form>
<h:form>

<h:panelGrid border="1" columns="2">
 <h:outputText value="Enter Memberid"></h:outputText>
 <h:inputText value="#{customerRepBean.memberid}"></h:inputText>
 <h:outputText value="Enter Date(yyyy-mm-dd)"></h:outputText> 
 <h:inputText value="#{customerRepBean.date1}">
 </h:inputText>
</h:panelGrid>

<c:set target="${searchSongBean}" property="memberid" value="${customerRepBean.memberid}"/>
    <c:set target="${searchMovieBean}" property="memberid" value="${customerRepBean.memberid}"/>
<h:commandButton value="Get Reserved Order" action="#{customerRepBean.getReservedSongOrder}" rendered="#{searchSongBean.value==1}"></h:commandButton>

<h:commandButton value="Get Reserved Order" action="#{customerRepBean.getReservedMovieOrder}" rendered="#{searchSongBean.value == 2}"></h:commandButton>
</br></br>
<c:if test="${customerRepBean.reservesong!= null}">
<h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="Songs"/>
                </f:facet>
	<h:dataTable border="1"  value="#{customerRepBean.reservesong}" var="song">
						<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Song Id"/>
	                          </f:facet>
                          <h:outputText value="#{song.songid}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Total Price"/>
	                          </f:facet>
                          <h:outputText value="#{song.totalPrice}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Quantity"/>
	                          </f:facet>
                          <h:outputText value="#{song.quantity}">
                         
                          </h:outputText>
                     </h:column>
                     
                     
	
	</h:dataTable>

</h:panelGrid>
 <h:commandButton value="Order" action="#{customerRepBean.addSongtocart}" ></h:commandButton>
</c:if>

</h:form>

<h:form>

<c:if test="${customerRepBean.reserveMovie!= null}">
<h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="Movie"/>
                </f:facet>
	<h:dataTable border="1"  value="#{customerRepBean.reserveMovie}" var="movie">
						<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Movie ID"/>
	                          </f:facet>
                          <h:outputText value="#{movie.movieid}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Total Price"/>
	                          </f:facet>
                          <h:outputText value="#{movie.totalPrice}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Quantity"/>
	                          </f:facet>
                          <h:outputText value="#{movie.quantity}">
                         
                          </h:outputText>
                     </h:column>
                     
                     
	
	</h:dataTable>

</h:panelGrid>
 <h:commandButton value="Order" action="#{customerRepBean.addMovietocart}" ></h:commandButton>
</c:if>




</h:form>


</br>
</br>
 <h:outputText value="#{customerRepBean.message }"/></center>
</f:view>
 



</body>
</html>