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
 <dd><fmt:formatNumber value='${bier.alcohol}' minFractionDigits='0'/>&nbsp;&#37;</dd>
 <dt>Prijs</dt>
 <dd><fmt:formatNumber value='${bier.prijs}' minFractionDigits='0'/>&nbsp;&euro;</dd>
 <dt>Soort</dt>
 <dd>${bier.soort.naam}</dd>
 <dt>Brouwer</dt>
 <dd>${bier.brouwer.naam}</dd>
</dl><br/>
<c:url value='/bestelling/toevoegen' var='url'/>
<form:form action='${url}' method='post' commandName='bestelbonLijn' id='bestelForm'>
<form:hidden path='bierNr' value='${bier.bierNr}'/>
<form:label path='aantal'><b>Aantal</b></form:label><form:errors path='aantal' cssClass='fout'/>
<form:input path='aantal' type='number' size='3' maxlength='5' autofocus='autofocus' />
<input type='submit' value='Toevoegen' id = 'bestelKnop'/> 
<form:errors cssClass='fout' element='div'/>
</form:form>
<script>
document.getElementById('bestelForm').onsubmit= function() {
document.getElementById('bestelKnop').disabled=true;
};
</script>
</body>
</html>