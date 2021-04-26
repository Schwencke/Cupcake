<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>

    <jsp:attribute name="header">
         Forsiden
    </jsp:attribute>

    <jsp:attribute name="footer">
        <c:set var="addHomeLink" value="${false}" scope="request"/>
    </jsp:attribute>

    <jsp:body>
        <div class="row justify-content-center">
            <div class="col-sm-1"></div>
            <div class="col-sm-6">
                <img class="img-fluid" alt="Cupcakes"
                     src="${pageContext.request.contextPath}/images/cupcakes_small.jpg">
            </div>
            <div class="col-sm-1"></div>
        </div>
        <div class="row justify-content-center">
        <div class="col-sm-6">
            <form method="post" action="${pageContext.request.contextPath}/fc/addtobasketcommand">
                <div class="form-group mt-2">
                    <label class="form-check-label" for="bottom_id">Bund</label><br>
                    <select class="form-control" name="bottom" id="bottom_id">
                        <c:forEach var="bottom" items="${applicationScope.bottomlist}">
                            <option value="${bottom.bottomId}">${bottom.flavor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Pris: ${bottom.price},-)</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="form-group mt-2">
                    <label class="form-check-label" for="topping_id">Topping</label><br>
                    <select class="form-control" name="topping" id="topping_id">
                        <c:forEach var="topping" items="${applicationScope.toppinglist}">
                            <option value="${topping.toppingId}">${topping.flavor}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;(Pris: ${topping.price},-)</option>
                        </c:forEach>
                    </select>
                </div>
                <div class="row justify-content-center">
                    <div class="form-group mt-2">
                        <label for="amount">Antal:</label>
                        <input class="form-control mr-3" id="amount" type="number" value="1" name="amount">
                        <button class="btn btn-outline-secondary mt-2" type="submit">Læg i kurven</button>
                    </div>
                </div>
            </form>

            <c:if test="${requestScope.msg != null }">
                <p style="color:green">
                        ${requestScope.msg}
                </p>
            </c:if>
        </div>

    </jsp:body>
</t:genericpage>