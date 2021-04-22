<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Order History
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
         <table class="table table-striped">
            <thead>
            <th>OrdreNo:</th>
            <th>Pris Total:</th>
            <th>Oprettet</th>
            <th>Status</th>
            </thead>
            <c:forEach var="orderlist" items="${sessionScope.orderlist}">
                <tr>
                    <td>${orderlist.orderId}</td>
                    <td>${orderlist.priceTotal},-</td>
                    <td>${orderlist.created}</td>
                    <td>${applicationScope.statuslist.get(orderlist.statusId-1).status}</td>
                </tr>
            </c:forEach>
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </table>

        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>
    </jsp:body>

</t:genericpage>

