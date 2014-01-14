<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='security' uri='http://www.springframework.org/security/tags'%> 
<!DOCTYPE HTML>
<html lang="${pageContext.response.locale.language}">
<head>
 <title><fmt:message key='menu'/></title>
 <link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<nav>
 <ul class='zonderbolletjes'>
  <li><a href="<c:url value='/'/>"><fmt:message key='welkom'/></a></li>
  <li><a href="<c:url value='/bieren'/>"><fmt:message key='bierenVanEenBrouwer'/></a></li>
  <li><a href="<c:url value='/bestelbonnen'/>"><fmt:message key='winkelWagen'/></a></li>
 </ul>
</nav>
</body>
</html>