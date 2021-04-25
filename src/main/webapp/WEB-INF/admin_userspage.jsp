<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Admin side over brugere
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
            <th></th>
            </thead>
            <c:forEach var="user" items="${sessionScope.userlist}">
                <tr>
                    <form action="${pageContext.request.contextPath}/fc/balanceupdate">
                        <td><input type="hidden" name="user_id" value="${user.userId}">${user.userId}</td>
                        <td>${applicationScope.rolelist.get(user.roleId-1).role}</td>
                        <td>${user.firstname}</td>
                        <td>${user.lastname}</td>
                        <td>${user.phoneNo}</td>
                        <td><input name="user_balance" value="${user.balance}">,-</td>
                        <td>${user.email}</td>
                        <td>
                            <button type="submit">Opdater</button>
                        </td>
                    </form>
                </tr>
            </c:forEach>
        </table>
        <c:if test="${requestScope.msg != null }">
            <p style="color:green">
                    ${requestScope.msg}
            </p>
        </c:if>
        <a class="nav-link" href="${pageContext.request.contextPath}/fc/employeepage">Gå tilbage</a>
    </jsp:body>
</t:genericpage>
