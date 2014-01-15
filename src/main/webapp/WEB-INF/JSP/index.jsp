<%@page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<!DOCTYPE HTML>
<html lang="${pageContext.response.locale.language}">
<head>
 <title><fmt:message key='welkom'/></title>
 <link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<jsp:include page="/WEB-INF/JSP/menu.jsp"/>
<h2><fmt:message key='welkomTekst'/></h2>
<section>
 <img src='${pageContext.servletContext.contextPath}/images/bierhuis.jpg' alt='foto bieren'/>
</section>
<h3><fmt:message key='aantalBieren'><fmt:param value='${aantalBieren}'/></fmt:message></h3>
</body>
</html>