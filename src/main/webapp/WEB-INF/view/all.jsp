<%@ include file="header.jsp"%>
    <c:forEach var="user" items="${allu}">
        <c:out value="${user.userName}" />
        <c:out value="${user.password}" />
        <br/>
    </c:forEach>
<%@ include file="footer.jsp"%>