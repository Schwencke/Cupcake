<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Register as new User
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <div style="margin-top: 5em;">
            <form name="login" action="${pageContext.request.contextPath}/fc/registercommand" method="POST">
                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="firstname">Firstname</label>
                    <div class="col-sm-4">
                        <input id="firstname" class="form-control" type="text" name="firstname" required
                               value="${param.firstname}" placeholder="Enter your firstname">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="lastname">Lastname</label>
                    <div class="col-sm-4">
                        <input id="lastname" class="form-control" type="text" name="lastname" required
                               value="${param.lastname}" placeholder="Enter your lastname">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="phoneno">Phonenumber</label>
                    <div class="col-sm-4">
                        <input id="phoneno" class="form-control" type="text" name="phoneno" required
                               value="${param.phoneno}" placeholder="Enter your phone number">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="email">Email</label>
                    <div class="col-sm-4">
                        <input id="email" class="form-control" type="email" name="email" required value="${param.email}"
                               placeholder="Enter a valid email">
                    </div>
                </div>

                <div class="row mb-3">
                    <label class="col-sm-1 col-form-label" for="password1">Password</label>
                    <div class="col-sm-4">
                        <input id="password1" class="form-control mb-2" type="password" name="password1" required
                               value="${param.password1}" placeholder="Enter your password">
                        <input id="password2" class="form-control" type="password" name="password2" required
                               value="${param.password2}" placeholder="Repeat the password">
                    </div>
                </div>

                <input class="btn btn-primary" type="submit" type="submit" value="Submit">
            </form>

            <c:if test="${requestScope.error != null }">
                <p style="color:red">
                        ${requestScope.error}
                </p>
            </c:if>
        </div>
    </jsp:body>
</t:genericpage>


