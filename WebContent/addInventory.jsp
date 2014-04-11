<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Inventory</title>
</head>
<body>
<a href="Logout.jsp">Log Out</a> </br>
<center><b>Inventory</b></center> </br></br></br></br>
<f:view>
 
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
<h:panelGrid border="1" columns="2" rendered="#{searchSongBean.value==1}">
 <h:outputText value="Genre"></h:outputText>
 <h:inputText value="#{adminBean.genre}"></h:inputText>
 <h:outputText value="Artist"></h:outputText> 
  <h:inputText value="#{adminBean.artist}"></h:inputText>
   <h:outputText value="Album"></h:outputText> 
  <h:inputText value="#{adminBean.album}"></h:inputText>
   <h:outputText value="Language"></h:outputText> 
  <h:inputText value="#{adminBean.language}"></h:inputText>
    <h:outputText value="Medium"></h:outputText> 
  <h:inputText value="#{adminBean.medium}"></h:inputText>
      <h:outputText value="Price"></h:outputText> 
  <h:inputText value="#{adminBean.price}"></h:inputText>
      <h:outputText value="Quantity"></h:outputText> 
  <h:inputText value="#{adminBean.quantity}"></h:inputText>
<h:commandButton value="Add" action="#{adminBean.addSong}"></h:commandButton>
</h:panelGrid>  
   
  
  </h:form>
    
    <h:form>
<h:panelGrid border="1" columns="2" rendered="#{searchSongBean.value ==2}">
 <h:outputText value="Genre"></h:outputText>
 <h:inputText value="#{adminBean.genre}"></h:inputText>
 <h:outputText value="Actor"></h:outputText> 
  <h:inputText value="#{adminBean.actor}"></h:inputText>
   <h:outputText value="Movie Name"></h:outputText> 
  <h:inputText value="#{adminBean.movieName}"></h:inputText>
   <h:outputText value="Language"></h:outputText> 
  <h:inputText value="#{adminBean.language}"></h:inputText>
    <h:outputText value="Medium"></h:outputText> 
  <h:inputText value="#{adminBean.medium}"></h:inputText>
      <h:outputText value="Price"></h:outputText> 
  <h:inputText value="#{adminBean.price}"></h:inputText>
      <h:outputText value="Quantity"></h:outputText> 
  <h:inputText value="#{adminBean.quantity}"></h:inputText>
<h:commandButton value="Add" action="#{adminBean.addMovie}"></h:commandButton>
</h:panelGrid>  
   
  
  </h:form>
    
    
    
    
    </f:view>
</body>
</html>