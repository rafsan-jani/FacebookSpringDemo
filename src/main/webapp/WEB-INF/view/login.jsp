<%@ include file="header.jsp"%>
                                <!--##########  Form Section #############-->
    <sf:form method="POST" modelAttribute="userInfo">

    <div class="row">
                    <div class="col-sm-6 col-md-4 col-md-offset-4">
                        <h2 class="text-center login-title"><st:message code="label.title.login" /></h2>
                        <div class="account-wall">
                            <c:if test="${error==null?'':error}">
                            </c:if>
                            <div id="mismatch">
                             <c:out value="${error}">
                             </c:out>
                             </div>
                             <sf:input type="text"  class="form-control" placeholder="Username" value="${cookie.userName.value}" path="userName" />
                            <sf:errors path="userName" cssClass="error" />
                            <sf:password  class="form-control"  placeholder="Password" path="password" />
                            <sf:errors path="password" cssClass="error" />
                            <sf:button class="btn btn-lg btn-primary btn-block" type="submit">
                              <st:message code="button.signin" />
                             </sf:button>
                        </div>
                        <a href="/FacebookSpring/register" class="text-center new-account">
                        <st:message code="hyperlink.newAccount" />
                        </a>
                    </div>
    </div>
    </sf:form>
                               <!--################  End Form #############-->
<%@ include file="footer.jsp"%>