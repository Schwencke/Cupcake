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
        <a href="${pageContext.request.contextPath}/fc/admin_balanceupdatepage">Opdater bruger saldo</a>
        <a href="${pageContext.request.contextPath}/fc/admin_orderremovepage">Opdater bruger saldo</a>
    </jsp:body>
</t:genericpage>
