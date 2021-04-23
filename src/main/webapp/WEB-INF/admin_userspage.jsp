<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Users Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <table class="table table-striped">
            <thead>
            <th>ID</th>
            <th>Rolle</th>
            <th>Fornavn</th>
            <th>Efternavn</th>
            <th>Telefon</th>
            <th>Saldo</th>
            <th>Email</th>
            </thead>
            <c:forEach var="user" items="${sessionScope.userlist}">
                <tr>
                    <td>${user.userId}</td>
                    <td>${user.roleId}</td>
                    <td>${user.firstname}</td>
                    <td>${user.lastname}</td>
                    <td>${user.phoneNo}</td>
                    <td>${user.balance},-</td>
                    <td>${user.email}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/fc/employeepage">Gå tilbage</a>
    </jsp:body>
</t:genericpage>
