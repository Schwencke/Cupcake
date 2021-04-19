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
            <th>Pris</th>
            <th>Antal</th>
            </thead>
            <c:forEach var="cupcake" items="${requestScope.cupcakelist}">
                <tr>
                    <td>${cupcake.bottom}</td>
                    <td>${cupcake.topping}</td>
                    <td>${cupcake.price}</td>
                    <td>${cupcake.amount}</td>
                </tr>
            </c:forEach>
        </table>
    </jsp:body>

</t:genericpage>

