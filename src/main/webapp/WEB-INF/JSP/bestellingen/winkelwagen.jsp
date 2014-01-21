<%@ page  contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix='fmt' uri='http://java.sun.com/jsp/jstl/fmt'%>
<%@taglib prefix='spring' uri='http://www.springframework.org/tags'%>
<%@taglib prefix='form' uri='http://www.springframework.org/tags/form'%> 
<!DOCTYPE HTML>
<html lang="${pageContext.response.locale.language}">
<head>
 <title><fmt:message key='bestelbonlijnen' /></title>
 <link rel='stylesheet' href='${pageContext.servletContext.contextPath}/styles/default.css'/>
</head>
<body>
<jsp:include page="/WEB-INF/JSP/menu.jsp"/>
<h2><fmt:message key='winkelwagen' /></h2>
<c:choose>
<c:when test="${not empty bestelbon.bestelbonLijnen}">
 <table>
   <thead>
     <tr>
       <th>Bier</th><th >Prijs</th><th>Aantal</th><th>Te betalen</th>
     </tr>
    </thead>
     <tbody>
     <c:forEach var='bestelbonLijn' items='${bestelbon.bestelbonLijnen}'>
      <tr>
       <td>${bestelbonLijn.bier.naam}</td>
       <td class='right'><spring:eval expression='bestelbonLijn.bier.prijs' /></td>
       <td class='right'>${bestelbonLijn.aantal}</td>
       <td class='right'><spring:eval expression='bestelbonLijn.prijs' /></td>
     </tr>
    </c:forEach>
    <tr>
     <td></td>
     <td></td>
     <td></td>
     <td>Totaal: &euro; <fmt:formatNumber value='${bestelbon.eindTotaal}' groupingUsed='false' minFractionDigits='0'/></td>
    </tr>
   </tbody>
 </table>
<br/>
<c:url value='/bestelling/bevestigen' var='url'/>
<form:form action='${url}' method='post' commandName='bestelbon' id='bestelbonForm'>
<form:label path='naam'><b>Naam</b>
<form:errors path='naam' cssClass='fout'/></form:label>
<form:input path='naam' autofocus='autofocus'/>
<form:label path='adres.straat'><b>Straat</b>
<form:errors path='adres.straat' cssClass='fout'/></form:label>
<form:input path='adres.straat'/>
<form:label path='adres.huisNr'><b>Huisnr.</b>
<form:errors path='adres.huisNr' cssClass='fout'/></form:label>
<form:input path='adres.huisNr' />
<form:label path='adres.postcode'><b>Postcode</b>
<form:errors path='adres.postcode' cssClass='fout'/>
</form:label>
<form:input path='adres.postcode'/>
<form:label path='adres.gemeente'><b>Gemeente</b>
<form:errors path='adres.gemeente' cssClass='fout'/>
</form:label>
<form:input path='adres.gemeente'/>
<input type='submit' value='Als bestelbon bevestigen' id = 'bestelKnop'/> 
<form:errors cssClass='fout' element='div'/>
</form:form>
<script>
document.getElementById('bestelbonForm').onsubmit= function() {
document.getElementById('bestelKnop').disabled=true;
};
</script>
</c:when>
<c:otherwise><h3><fmt:message key="winkelwagenLeeg" /></h3></c:otherwise>
</c:choose>
</body>
</html>