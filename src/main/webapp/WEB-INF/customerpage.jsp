<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Customer Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <h1>Hej ${sessionScope.user.firstname} - Velkommen til Olsker Cupcakes!</h1>

        <br>
        <br>
        <br>
        <br>

        <h2><a class="nav-link" href="${pageContext.request.contextPath}/fc/index">Gå til forsiden for at bestille vores dejlige cupcakes</a></h2>
    </jsp:body>

</t:genericpage>

