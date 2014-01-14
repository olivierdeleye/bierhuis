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
<jsp:include page="menu.jsp"/>
<h2>Welkom in het huis van de Belgische bieren</h2>
<section>
 <img src='${pageContext.servletContext.contextPath}/images/bierhuis.jpg'/>
</section>
<fmt:message key='aantalBieren'><fmt:param value='${aantalBieren}'/></fmt:message>
</body>
</html>