<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Basket Page
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
            <c:forEach var="cupcake" items="${sessionScope.cupcakelist}">
                <tr>
                    <td>${cupcake.topping}</td>
                    <td>${cupcake.bottom}</td>
                    <td>${cupcake.amount}</td>
                    <td>${cupcake.price},-</td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>Total pris: ${sessionScope.pricetotal},-</td>
            </tr>
        </table>

        <a href="${pageContext.request.contextPath}/fc/index">Bestil mere</a>
        <a href="${pageContext.request.contextPath}/fc/checkoutpage">Til betaling</a>
    </jsp:body>
</t:genericpage>
