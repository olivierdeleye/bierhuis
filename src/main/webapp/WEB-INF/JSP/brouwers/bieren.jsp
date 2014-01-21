<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%> 
<!DOCTYPE HTML>
<html lang="${pageContext.response.locale.language}">
<head>
 <title>bieren</title>
 <link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<jsp:include page="/WEB-INF/JSP/menu.jsp"/>
<h2>${brouwer.naam} (${brouwer.adres.gemeente})</h2>
<c:forEach items='${brouwer.bieren}' var='bier'>
  <spring:url var='url' value='/bieren/{bierNr}'>
    <spring:param name='bierNr' value='${bier.bierNr}'/>
  </spring:url>
  <ul>
   <li><a href='${url}'>${bier.naam}</a></li>
  </ul>
 </c:forEach>
</body>
</html>