<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Inventory</title>
</head>
<body>
<f:view>
 <a href="Logout.jsp">Log Out</a> </br></br></br></br>

<h:form>
<h:selectOneMenu  id="select_sm1" value="#{loginBean.branchid}" onchange="submit()" immediate="true">
		<f:selectItem itemLabel="Please select one"/>
        <f:selectItem itemValue="1" itemLabel="Branch1"/>
        <f:selectItem itemValue="2" itemLabel="Branch2"/>
         
       
    </h:selectOneMenu>
     <c:set target="${adminBean}" property="branchid" value="${loginBean.branchid}"/>
    </h:form>
    
     <h:form>
 	
	<h:selectOneMenu  id="select_sm" value="#{searchSongBean.value}" onchange="submit()" immediate="true" rendered="#{loginBean.branchid ==1 or loginBean.branchid ==2}">
		<f:selectItem itemLabel="Please select one"/>
        <f:selectItem itemValue="1" itemLabel="Songs"/>
        <f:selectItem itemValue="2" itemLabel="Movies"/>
         
       
    </h:selectOneMenu>
   
    
  </h:form>
  <h:form>
  <c:if test="${searchSongBean.value==1}">
   <h:commandButton value="Get Songs" action="#{adminBean.getSongs}" ></h:commandButton>
  </c:if>
  <c:if test="${adminBean.songlist != null and searchSongBean.value==1}">
  
<h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="Songs"/>
                </f:facet>
	<h:dataTable border="1"  value="#{adminBean.songlist}" var="song">
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
	                              <h:outputText value="Price Per Item"/>
	                          </f:facet>
                          <h:inputText value="#{song.price}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Quantity Available"/>
	                          </f:facet>
                          <h:inputText value="#{song.quantity}">
                         
                          <f:validateLength minimum="0"   />
                          </h:inputText>
                     </h:column>
                       <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Status"/>
	                          </f:facet>
                          <h:outputText value="#{song.status}"/>
                     </h:column>
                     <h:column>
                     			 <f:facet name="header" >
	                              <h:outputText value="Select"/>
	                          </f:facet>
                     <h:selectBooleanCheckbox value="#{adminBean.checked[song.songid]}" /> 
                     </h:column>
	
	</h:dataTable>
 
</h:panelGrid>
<h:commandButton value="Update" action="#{adminBean.update_Song}" ></h:commandButton>
<h:commandButton value="Delete" action="#{adminBean.delete_song}" ></h:commandButton>
</c:if>
  </h:form>
 <h:form> 
 <c:if test="${searchSongBean.value==2}">
   <h:commandButton value="Get Movie" action="#{adminBean.getMovie}" ></h:commandButton>
  </c:if>
  <c:if test="${adminBean.movielist != null and searchSongBean.value==2}">
 <h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="Movies"/>
                </f:facet>
	 <h:dataTable border="1"  value="#{adminBean.movielist}" var="movie">
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
	                              <h:outputText value="Price"/>
	                          </f:facet>
                          <h:inputText value="#{movie.price}"/>
                     </h:column>
                    <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Quantity"/>
	                          </f:facet>
                          <h:inputText value="#{movie.quantity}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Status"/>
	                          </f:facet>
                          <h:outputText value="#{movie.status}"/>
                     </h:column>
                      <h:column>
                     			 <f:facet name="header" >
	                              <h:outputText value="Select"/>
	                          </f:facet>
                     <h:selectBooleanCheckbox value="#{adminBean.checked[movie.movieid]}" /> 
                     </h:column>
	
	</h:dataTable>


</h:panelGrid>
 <h:commandButton value="Update" action="#{adminBean.update_Movie}" ></h:commandButton>
<h:commandButton value="Delete" action="#{adminBean.delete_movie}" ></h:commandButton>
 </c:if>
  </h:form>
 
  
  
  
  
  </f:view>
</body>
</html>