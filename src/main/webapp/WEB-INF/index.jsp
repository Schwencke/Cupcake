<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Home
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>

        <h2>Our Cool Site</h2>

        <div style="margin-top: 3em;margin-bottom: 3em;">
            CUPCAKES GALOOORE
        </div>
        <form method="post" action="${pageContext.request.contextPath}/fc/addtobasketcommand">
            <div class="form-group mt-2">
                <label class="form-check-label" for="bottom_id">Vælg Bund:</label><br>
                <select class="form-control" name="bottom" id="bottom_id">
                    <c:forEach var="bottom" items="${applicationScope.bottomlist}">
                        <option value="${bottom.flavor},${bottom.price}">${bottom.flavor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Pris: ${bottom.price},-)</option>
                    </c:forEach>
                </select>

                <label class="form-check-label" for="topping_id">Vælg Topping:</label><br>
                <select class="form-control" name="topping" id="topping_id">
                    <c:forEach var="topping" items="${applicationScope.toppinglist}">
                        <option value="${topping.flavor},${topping.price}">${topping.flavor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Pris: ${topping.price},-)</option>
                    </c:forEach>
                </select>

                <label for="amount">Antal:</label>
                <input id="amount" type="number" value="1" name="amount">

                <button type="submit">Læg i kurven</button>
            </div>
        </form>

        <c:if test="${requestScope.msg != null }">
            <p style="color:green">
                    ${requestScope.msg}
            </p>
        </c:if>
<!--
        <c:if test="${sessionScope.role == 'employee' }">
            <p style="font-size: larger">This is what you can do,
                since your are logged in as an employee</p>
            <p><a href="fc/employeepage">Employee Page</a>
        </c:if>

        <c:if test="${sessionScope.role == 'customer' }">
            <p style="font-size: larger">This is what you can do, since your
                are logged in as a customer</p>
            <p><a href="fc/customerpage">Customer Page</a>
        </c:if>
-->
        </div>

    </jsp:body>
</t:genericpage>