<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Orders Page
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <form action="${pageContext.request.contextPath}/fc/showallorders">
            <label for="searchid">Søg efter bruger</label> <br>
            <input type="text" name="orderlist" id="searchid" placeholder="indtast bruger id">
            <button type="submit">Søg</button>

        </form>
        <table class="table table-striped">
            <thead>
            <th>Ordre nr.</th>
            <th>Bruger ID</th>
            <th>Pris</th>
            <th>Oprettet</th>
            <th>Status</th>
            </thead>
            <c:forEach var="orderlist" items="${sessionScope.orderlist}">
                <tr>
                    <td>${orderlist.orderId}</td>
                    <td>${orderlist.userId}</td>
                    <td>${orderlist.priceTotal}</td>
                    <td>${orderlist.created}</td>
                    <td>${applicationScope.statuslist.get(orderlist.statusId-1).status}</td>
                    <td><button type="submit" name="delete" value="${orderlist.orderId}">Slet ordre</button></td>
                </tr>
            </c:forEach>
        </table>
        <a href="${pageContext.request.contextPath}/fc/employeepage">Gå tilbage</a>
    </jsp:body>
</t:genericpage>
