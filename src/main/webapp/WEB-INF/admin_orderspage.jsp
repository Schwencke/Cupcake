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


        <table class="table table-striped">
            <thead>
            <th>Ordre nr.</th>
            <th>Bruger ID</th>
            <th>Pris</th>
            <th>Oprettet</th>
            <th>Status</th>
            </thead>
            <c:forEach var="orderlist" items="${sessionScope.orderlist}">
                <c:if test="${orderlist.statusId != 3}">
                <tr>
                    <td>${orderlist.orderId}</td>
                    <td><input type="hidden" name="user_id" value="${orderlist.userId}">${orderlist.userId}</td>
                    <td>${orderlist.priceTotal}</td>
                    <td>${orderlist.created}</td>
                    <td>${applicationScope.statuslist.get(orderlist.statusId-1).status}</td>
                    <c:if test="${orderlist.statusId == 1}">
                    <td><button type="submit" name="delete"  value="${orderlist.orderId}">Slet ordre</button></td>
                    </c:if>
                    <c:if test="${orderlist.statusId == 2}">
                        <td><button type="submit" name="delete" disabled value="${orderlist.orderId}">Slet ordre</button></td>
                    </c:if>
                </tr>
                </c:if>
            </c:forEach>
        </table></form>

        <a href="${pageContext.request.contextPath}/fc/employeepage">Gå tilbage</a>
    </jsp:body>
</t:genericpage>
