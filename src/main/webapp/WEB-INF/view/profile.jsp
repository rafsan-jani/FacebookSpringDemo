<%@ include file="header.jsp"%>

<div class="col-sm-6 col-md-4 col-md-offset-4">
<h2 type="center">Profile Info</h2>
   <table>
   <tr>
   				<c:if test="${error==null?'':error}">
                                               </c:if>
                                               <div class="danger">
                                                <c:out value="${error}">
                                                </c:out>
                                                </div>
   				</tr>
    <tr>
          <th>
          <c:out value="Name:" />
          </th>
          <td>
          <c:out value="${userInfo.personalDetails.firstName}" />
          <c:out value="${userInfo.personalDetails.lastName}" />
          </td>

    </tr>
    <tr>
        <th>
        <c:out value="Email:" />
        </th>
        <td>
        <c:out value="${userInfo.personalDetails.email}" />
        <td>
    </tr>
    <tr>
         <th>
         <c:out value="Date of Birth:" />
         </th>
         <td>
         <c:out value="${userInfo.personalDetails.dob}" />
         </td>
    </tr>
     <tr>
        <th>
        <c:out value="Age:" />
        </th>
        <td>
        <c:out value="${userInfo.personalDetails.age}" />
        </td>
     </tr>
     <tr>
        <th>
        <c:out value="Sex:" />
        </th>
        <td>
        <c:out value="${userInfo.personalDetails.sex}" />
        </td>
     </tr>
    </table>
    <sf:form method="POST" action="/FacebookSpring/logout">
    <input class="btn-sm btn-primary btn-block"  type="submit" value="Logout" />
    </sf:form>
 </div>
<%@ include file="footer.jsp"%>
