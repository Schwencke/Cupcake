<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Order Remove Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
<form action="${pageContext.request.contextPath}/fc/finduser">
    <label for="searchid">Søg efter bruger</label> <br>
    <input type="text" name="searchforuser" id="searchid" placeholder="indtast bruger id">
    <button type="submit">Søg</button>

</form>

        <table class="table table-striped">
            <thead>
            <th>Order nr.</th>
            <th>Pris</th>
            <th>Status</th>
            </thead>
            <c:forEach var="orderlistbyuser" items="${sessionScope.searchorderlist}">
                <tr>
                    <td>${orderlistbyuser.orderId}</td>
                    <td>${orderlistbyuser.priceTotal}</td>
                    <td>${orderlistbyuser.statusId}</td>
                </tr>
            </c:forEach>
        </table>

    </jsp:body>
</t:genericpage>
