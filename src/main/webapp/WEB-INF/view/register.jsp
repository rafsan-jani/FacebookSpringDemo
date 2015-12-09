<%@ include file="header.jsp"%>
 <div class="row">
    <div class="col-sm-6 col-md-6 col-md-offset-4">
        <div class="account-wall" overflow="hidden">
	    <sf:form method="POST" modelAttribute="personalDetails">
		<fieldset>
		    <h2><st:message code="label.title.registration"/></h2>
		    <a href="/FacebookSpring/login" class="text-right new-account">Login</a>
			<table>
				<tr>
				    <c:if test="${error==null?'':error}">
                    </c:if>
                    <div class="error">
                        <c:out value="${error}">
                        </c:out>
                    </div>
				</tr>
				<tr>
					<th>
					<sf:label path="firstName">
						<st:message code="label.firstName"/>
					</sf:label>
					</th>
					<td>
					<sf:input path="firstName"  />
					<br/>
					<sf:errors path="firstName" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th>
					<sf:label path="lastName">
						<st:message code="label.lastName"/>
					</sf:label></th>
					<td>
					<sf:input path="lastName"  />
					<br/>
					<sf:errors path="lastName" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th>
					<sf:label path="email">
						<st:message code="label.email"/>
					</sf:label></th>
					<td>
					<sf:input path="email" />
					<br/>
					<sf:errors path="email" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th>
					<sf:label path="password">
						<st:message code="label.password"/>
					</sf:label></th>
					<td>
					<sf:password path="password" />
					<small>6 characters or more (be tricky!)</small>
					<br/>
					<sf:errors path="password" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th>
					<sf:label path="dobString">
						<st:message code="label.dob"/>
					</sf:label></th>
					<td>
					<sf:input path="dobString" />
					<small>dd/mm/yyyy</small>
					<br/>
					<sf:errors path="dobString" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th>
					<sf:label path="sex">
						<st:message code="label.sex"/>
					</sf:label></th>
					<td>
					 <sf:radiobutton path="sex" value="male"/>Male
                     <sf:radiobutton path="sex" value="female"/>Female
					<br/>
					<sf:errors path="sex" cssClass="error" />
					</td>
				</tr>
				<tr>
					<th></th>
					<td>
					<sf:button class="btn btn-lg btn-primary btn-block" type="submit" >
					    <st:message code="button.registration"/>
					 </sf:button>
					</td>
				</tr>
			</table>
		</fieldset>
	</sf:form>
</div>
</div>
</div>
<%@ include file="footer.jsp"%>