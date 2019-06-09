<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<spring:url value="/login" var="login" htmlEscape="true" />

<div class="container">
	<div class="form-row text-center">
	<div class="col-sm-4"></div>
	<div class="col-sm-4">
		<h2 class="form-signin-heading">Sign In</h2>

		<form:form id="form" modelAttribute="user" method="post" action="${login}" class="form-signin">
			<div class="form-group">
				<span>${message}</span>
				<form:label path="email">Email:</form:label>
				<form:input path="email" class="form-control" /><br><br>
				<form:label path="password">Password:</form:label>
				<form:password path="password" class="form-control" /><br><br>
				<form:button class="btn btn-lg btn-primary btn-block">Login</form:button>
			</div>
		</form:form>
	</div>

	<div class="col-sm-4"></div>
</div>