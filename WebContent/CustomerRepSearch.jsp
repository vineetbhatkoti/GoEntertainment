<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CR Home</title>
</head>
<body>
<f:view>
<h:form>
 <h:outputText value="Member id:"></h:outputText>
 <h:inputText value="#{customerRepBean.memberid}"></h:inputText>
<c:set target="${searchSongBean}" property="memberid" value="${customerRepBean.memberid}"/>
    <c:set target="${searchMovieBean}" property="memberid" value="${customerRepBean.memberid}"/>

 	 <c:set target="${searchSongBean}" property="branchid" value="${customerRepBean.branchid}"/>
    <c:set target="${searchMovieBean}" property="branchid" value="${customerRepBean.branchid}"/>
	<h:selectOneMenu  id="select_sm" value="#{searchSongBean.value}" onchange="submit()" immediate="true">
		<f:selectItem itemLabel="Please select one"/>
        <f:selectItem itemValue="1" itemLabel="Songs"/>
        <f:selectItem itemValue="2" itemLabel="Movies"/>
         
       
    </h:selectOneMenu>

  </h:form>
  <h:form>
<h:panelGrid border="1" columns="2" rendered="#{searchSongBean.value == 1}">
 <h:outputText value="Genre"></h:outputText>
 <h:inputText value="#{searchSongBean.genre}"></h:inputText>
 <h:outputText value="Artist"></h:outputText> 
 <h:inputText value="#{searchSongBean.artist}"/>
  <h:outputText value="Album"></h:outputText> 
 <h:inputText value="#{searchSongBean.album}"/>
 <h:outputText value="Language"></h:outputText> 
 <h:inputText value="#{searchSongBean.language}"/>
 <h:outputText value="Medium"></h:outputText> 
 <h:inputText value="#{searchSongBean.medium}"/>
 
 <h:commandButton value="Search" action="#{searchSongBean.search}"></h:commandButton>
</h:panelGrid>


<c:if test="${searchSongBean.list != null and searchSongBean.value == 1}">
<h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="Songs"/>
                </f:facet>
	<h:dataTable border="1"  value="#{searchSongBean.list}" var="song">
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
	                              <h:outputText value="Total Price"/>
	                          </f:facet>
                          <h:outputText value="#{song.price}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Quantity"/>
	                          </f:facet>
                          <h:inputText value="#{song.quantity}">
                         
                          <f:validateLength minimum="0"   />
                          </h:inputText>
                     </h:column>
                     
                     <h:column>
                     			 <f:facet name="header" >
	                              <h:outputText value="Select"/>
	                          </f:facet>
                     <h:selectBooleanCheckbox value="#{searchSongBean.checked[song.songid]}" /> 
                     </h:column>
	
	</h:dataTable>

</h:panelGrid>
 <h:commandButton value="Add To Cart" action="#{searchSongBean.addtocart}" ></h:commandButton>
</c:if>


</h:form>

<h:form>
<h:panelGrid border="1" columns="2" rendered="#{searchSongBean.value == 2}">
 <h:outputText value="Genre"></h:outputText>
 <h:inputText value="#{searchMovieBean.genre}"></h:inputText>
 <h:outputText value="Actor"></h:outputText> 
 <h:inputText value="#{searchMovieBean.actor}"/>
  <h:outputText value="MovieName"></h:outputText> 
 <h:inputText value="#{searchMovieBean.movieName}"/>
 <h:outputText value="Language"></h:outputText> 
 <h:inputText value="#{searchMovieBean.language}"/>
 <h:outputText value="Medium"></h:outputText> 
 <h:inputText value="#{searchMovieBean.medium}"/>
 
 <h:commandButton value="Search" action="#{searchMovieBean.searchMovie}"></h:commandButton>
</h:panelGrid>


<c:if test="${searchMovieBean.list != null and searchSongBean.value == 2}">
<h:panelGrid border="1" columns="1">
				<f:facet name="header">
	            <h:outputText value="Movie"/>
                </f:facet>
	<h:dataTable border="1"  value="#{searchMovieBean.list}" var="movie">
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
	                              <h:outputText value="Price Per Item"/>
	                          </f:facet>
                          <h:outputText value="#{movie.price}"/>
                     </h:column>
                     <h:column>
	                          <f:facet name="header" >
	                              <h:outputText value="Quantity Available"/>
	                          </f:facet>
                          <h:inputText value="#{movie.quantity}">
                         
                          <f:validateLength minimum="0"   />
                          </h:inputText>
                     </h:column>
                     
                     <h:column>
                     			 <f:facet name="header" >
	                              <h:outputText value="Select"/>
	                          </f:facet>
                     <h:selectBooleanCheckbox value="#{searchMovieBean.checked[movie.movieid]}" /> 
                     </h:column>
	
	</h:dataTable>

</h:panelGrid>
 <h:commandButton value="Add To Cart" action="#{searchMovieBean.addtocart}" ></h:commandButton>
</c:if>


</h:form>
</f:view>
</body>
</html>