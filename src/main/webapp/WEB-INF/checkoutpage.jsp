<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Checkout
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <table class="table table-striped">
            <thead>
            <th>Bund</th>
            <th>Topping</th>
            <th>Antal</th>
            <th>Pris</th>
            </thead>
            <c:forEach var="cupcake" items="${requestScope.cupcakelist}">
                <tr>
                    <td>${cupcake.topping}</td>
                    <td>${cupcake.bottom}</td>
                    <td>${cupcake.amount}</td>
                    <td>${cupcake.price}</td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/fc/index">Bestil mere</a>
        <a href="${pageContext.request.contextPath}/fc/paymentpage">Til betaling</a>
    </jsp:body>

</t:genericpage>

