<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cart</title>
</head>
<body>
 <f:view><center>
 <h:form>
 <b>List of items you have selected !!</b><br><br><br>
  <c:if test="${searchSongBean.cart != null }">
 <h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="Songs"/>
                </f:facet>
	<h:dataTable border="1"  value="#{searchSongBean.cart}" var="song">
						<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Album Name"/>
	                          </f:facet>
                          <h:outputText value="#{song.album}"/>
                     </h:column>
					<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Genre"/>
	                          </f:facet>
                          <h:outputText value="#{song.genre}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Artist"/>
	                          </f:facet>
                          <h:outputText value="#{song.artist}"/>
                     </h:column>
                     
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Language"/>
	                          </f:facet>
                          <h:outputText value="#{song.language}"/>
                     </h:column>
					<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Medim(CD/DVD)"/>
	                          </f:facet>
                          <h:outputText value="#{song.medium}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Quantity Ordered"/>
	                          </f:facet>
                          <h:outputText value="#{song.quantity}"/>
                     </h:column>
                     
	
	</h:dataTable>
	
</h:panelGrid>
<h:panelGrid columns="2" rendered="#{customerRepBean.customerid ==0}">
<h:outputText value="Promo Code"></h:outputText>
<h:inputText value="#{searchSongBean.promo}"></h:inputText>

</h:panelGrid>
<h:commandButton value="Reserve" action="#{searchSongBean.reserve}" rendered="#{customerRepBean.customerid !=0}"></h:commandButton>
 <h:commandButton value="Order" action="#{searchSongBean.orderCart}"></h:commandButton>
 </c:if>
 
 
 
 
  <c:if test="${searchMovieBean.cart != null }">
 <h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="Movies"/>
                </f:facet>
	 <h:dataTable border="1"  value="#{searchMovieBean.cart}" var="movie">
						<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Movie Name"/>
	                          </f:facet>
                          <h:outputText value="#{movie.movieName}"/>
                     </h:column>
					<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Genre"/>
	                          </f:facet>
                          <h:outputText value="#{movie.genre}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Actor"/>
	                          </f:facet>
                          <h:outputText value="#{movie.actor}"/>
                     </h:column>
                     
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Language"/>
	                          </f:facet>
                          <h:outputText value="#{movie.language}"/>
                     </h:column>
					<h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Medim(CD/DVD)"/>
	                          </f:facet>
                          <h:outputText value="#{movie.medium}"/>
                     </h:column>
                     
                    <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Quantity Ordered"/>
	                          </f:facet>
                          <h:outputText value="#{movie.quantity}"/>
                     </h:column>
	
	</h:dataTable>


</h:panelGrid>
<h:panelGrid columns="2" rendered="#{customerRepBean.customerid ==0}">
<h:outputText value="Promo Code"></h:outputText>
<h:inputText value="#{searchMovieBean.promo}"></h:inputText>

</h:panelGrid>

<h:commandButton value="Reserve" action="#{searchMovieBean.reserve}" rendered="#{customerRepBean.customerid !=0}"></h:commandButton>
  <h:commandButton value="Order" action="#{searchMovieBean.orderCart}"></h:commandButton>
  
 </c:if>
 
  
 </h:form>
 
 </center>
 
 </f:view>
 
</body>
</html>