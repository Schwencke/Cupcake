<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Balance Page
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
            <c:forEach var="orderline" items="${sessionScope.orderlinelist}">
                <tr>
                    <td>${orderline.topping}</td>
                    <td>${orderline.bottom}</td>
                    <td>${orderline.amount}</td>
                    <td>${orderline.price},-</td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td>Total pris: ${sessionScope.pricetotal},-</td>
            </tr>
        </table>

    </jsp:body>
</t:genericpage>
