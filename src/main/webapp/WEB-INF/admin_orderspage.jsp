<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Admin side over ordre
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div class="row">
        <div class="col-sm-1 col-md-2 col-lg-3"></div>
        <div class="col-sm-10 col-md-8 col-lg 6 tableoverflow">
        <form action="${pageContext.request.contextPath}/fc/showallorders">
            <label for="searchid">Søg efter bruger</label> <br>
            <input type="text" name="orderlist" id="searchid" placeholder="indtast bruger id">
            <button type="submit" title="Søg efter valgte brugerID">Søg</button>


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
                            <td>${applicationScope.statuslist.get(orderlist.statusId-1).name}</td>
                            <c:if test="${orderlist.statusId == 1}">
                                <td>
                                    <button type="submit" name="delete" title="Tryk her for at slette ordren" value="${orderlist.orderId}">Slet ordre</button>
                                </td>
                            </c:if>
                            <c:if test="${orderlist.statusId == 2}">
                                <td>
                                    <button type="submit" name="delete" title="Du kan ikke slette en gennemført ordre" disabled value="${orderlist.orderId}">Slet
                                        ordre
                                    </button>
                                </td>
                            </c:if>
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
        </form>
        </div>
            <div class="col-sm-1 col-md-2 col-lg-3"></div>
        </div>
        <div class="row">
            <div class="col-5 p-0 m-0"></div>
            <div class="col-2 p-0 m-0 text-center">
        <a class="nav-link p-0 m-0" title="Tilbage" href="${pageContext.request.contextPath}/fc/employeepage">Gå tilbage</a>
            </div>
            <div class="col-5 p-0 m-0"></div>
        </div>
    </jsp:body>
</t:genericpage>
