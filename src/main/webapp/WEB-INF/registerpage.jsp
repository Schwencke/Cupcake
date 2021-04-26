<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register ny bruger
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>

        <div class="row mt-5">
        <div class="col-lg-3"></div>
        <div class="col-lg-6 justify-content-center">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand"  method="post">

                <div class="row mt-5">
                    <div class="col">
                        <input id="firstname" class="form-control" type="text" name="firstname" required
                               value="${param.firstname}" placeholder="Indtast dit fornavn">
                    </div>
                    <div class="col">
                        <input id="lastname" class="form-control" type="text" name="lastname" required
                               value="${param.lastname}" placeholder="Indtast dit efternavn">
                    </div>
                </div>

                <div class="row mt-5">
                    <div class="col">
                        <input id="phoneno" class="form-control" type="text" name="phoneno" required
                               value="${param.phoneno}" placeholder="Indtast dit telefon nummer">
                    </div>
                    <div class="col">
                        <input id="email" class="form-control" type="email" name="email" required value="${param.email}"
                               placeholder="Indtast din email">
                        <small id="emailHelp" class="form-text text-muted">Vi deler ikke din email med nogen</small>
                    </div>
                </div>

                <div class="row mb-3 form-group">
                    <div class="col-12 mt-5">
                        <input id="password1" class="form-control mb-2" type="password" name="password1" required
                               value="${param.password1}" placeholder="Angiv password">
                        <input id="password2" class="form-control" type="password" name="password2" required
                               value="${param.password2}" placeholder="Angiv password igen">
                    </div>
                </div>

                <input class="btn btn-primary" type="submit" type="submit" value="Register">
            </form>
        </div>
        <div class="col-lg-3"></div>

        <c:if test="${requestScope.error != null }">
            <p style="color:red">
                    ${requestScope.error}
            </p>
        </c:if>
    </jsp:body>
</t:genericpage>


