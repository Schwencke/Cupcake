<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Kurv
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>

    <jsp:body>
        <c:if test="${sessionScope.orderlinecount == 0}">
            <h1>Kurven er tom</h1>
        </c:if>
        <c:if test="${sessionScope.orderlinecount > 0}">
            <div class="row">
            <div class="col-sm-1 col-md-2 col-lg-3"></div>
            <div class="col-sm-10 col-md-8 col-lg 6">
            <table class="table table-striped">
                <thead>
                <th>Bund</th>
                <th>Topping</th>
                <th>Antal</th>
                <th>Stk pris</th>
                <th>Samlet pris</th>
                </thead>
                <form action="${pageContext.request.contextPath}/fc/removefrombasketcommand">
                    <c:forEach var="orderline" items="${sessionScope.orderlinelist}">
                        <tr>
                            <td>${orderline.bottom}</td>
                            <td>${orderline.topping}</td>
                            <td>${orderline.amount}</td>
                            <td>${orderline.price},-</td>
                            <td>${orderline.amount * orderline.price},-</td>
                            <td>
                                <button type="submit" name="delete" value="${orderline.orderLineId}">Slet</button>
                            </td>
                        </tr>
                    </c:forEach>
                </form>
                <tr>
                    <td>Total pris:</td>
                    <td></td>
                    <td></td>
                    <td></td>
                    <td>${sessionScope.pricetotal},-</td>
                </tr>
            </table>
        </c:if>

        <a class="nav-link" href="${pageContext.request.contextPath}/fc/index">Bestil mere</a>
        <a class="nav-link" href="${pageContext.request.contextPath}/fc/checkoutpage">Til betaling</a>
        </div>
        <div class="col-sm-1 col-md-2 col-lg-3"></div>
        </div>
    </jsp:body>
</t:genericpage>
