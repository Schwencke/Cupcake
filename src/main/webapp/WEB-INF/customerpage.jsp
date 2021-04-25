<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Kunde side
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hej ${sessionScope.user.firstname}</h1>
        <a class="nav-link" href="${pageContext.request.contextPath}/fc/index">Gå til forsiden for at bestille vores dejlige cupcakes</a>
    </jsp:body>

</t:genericpage>

