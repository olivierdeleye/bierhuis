<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%> 
<!DOCTYPE HTML>
<html lang="${pageContext.response.locale.language}">
<head>
 <title><fmt:message key='brouwers'/></title>
 <link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<jsp:include page="/WEB-INF/JSP/menu.jsp"/>
<h2><fmt:message key = 'brouwers'/></h2>
<c:forEach items='${brouwers}' var='brouwer'>
  <spring:url var='url' value='/brouwers/{brouwerNr}'>
    <spring:param name='brouwerNr' value='${brouwer.brouwerNr}'/>
  </spring:url>
  <ul>
   <li><a href='${url}'>${brouwer.naam} (${brouwer.adres.gemeente})</a></li>
  </ul>
 </c:forEach>
</body>
</html>