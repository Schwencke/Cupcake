<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Ordre historik
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <div class="row">
            <div class="col-sm-1 col-md-2 col-lg-3"></div>
            <div class="col-sm-10 col-md-8 col-lg 6">
                <table class="table table-light table-striped table-hover">
                    <thead>
                    <th>Ordre Nr:</th>
                    <th>Samlet Pris:</th>
                    <th>Oprettet</th>
                    <th>Status</th>
                    </thead>
                    <c:forEach var="orderlist" items="${sessionScope.orderlist}">
                        <tr>
                            <td>${orderlist.orderId}</td>
                            <td>${orderlist.priceTotal},-</td>
                            <td>${orderlist.created}</td>
                            <td>${applicationScope.statuslist.get(orderlist.statusId-1).name}</td>
                        </tr>
                    </c:forEach>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td></td>
                    </tr>
                </table>
            </div>
            <div class="col-sm-1 col-md-2 col-lg-3"></div>
        </div>
        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>
    </jsp:body>

</t:genericpage>

