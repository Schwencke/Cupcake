<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Employee Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <a href="${pageContext.request.contextPath}/fc/userspage">Opdater brugere</a>
        <a href="${pageContext.request.contextPath}/fc/orderspage">Opdater ordre</a>
    </jsp:body>
</t:genericpage>
