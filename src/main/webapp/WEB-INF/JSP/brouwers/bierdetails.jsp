<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<!DOCTYPE HTML>
<html lang="${pageContext.response.locale.language}">
<head>
 <title>details</title>
 <link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<jsp:include page="/WEB-INF/JSP/menu.jsp"/>
<h2>${bier.naam}</h2>
<dl>
 <dt>Alcohol</dt>
 <dd><spring:eval expression='bier.alcohol' />&nbsp;&#37;</dd>
 <dt>Prijs</dt>
 <dd><spring:eval expression='bier.prijs' /></dd>
 <dt>Soort</dt>
 <dd>${bier.soort.naam}</dd>
 <dt>Brouwer</dt>
 <dd>${bier.brouwer.naam}</dd>
</dl><br/>
<br/>
<spring:url value='/bestelling/toevoegen/{bierNr}' var='url'>
 <spring:param name='bierNr' value='${bier.bierNr}'/>
</spring:url>
<form:form action='${url}' method='post' commandName='aantalForm' id='aantalForm'>
<form:hidden path='bierNr' value='${bier.bierNr}'/>
<form:label path='aantal'><b>Aantal</b>
<form:errors path='aantal' cssClass='fout'/></form:label>
<form:input path='aantal' type='number' size="10" autofocus='autofocus' />
<input type='submit' value='Toevoegen' id = 'bestelKnop'/> 
</form:form>
<script>
document.getElementById('aantalForm').onsubmit= function() {
document.getElementById('bestelKnop').disabled=true;
};
</script>
</body>
</html>