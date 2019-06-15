<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/home" var="url" htmlEscape="true"/>
<div class="container">
	<h2 class="form-signin-heading">Your result</h2>
	<form:form id="form12" modelAttribute="question" method="post" action="${url}" class="form-signin">
		<div class="form-group row col-md-12">
			<div class="col-md-6">
				Final score
			</div>
			<div class="col-md-6">
					${result}
			</div>
		</div>
		<br/>
		<input type="submit" name="action" value="Take another quiz" class="btn btn-success" />
	</form:form>
</div>