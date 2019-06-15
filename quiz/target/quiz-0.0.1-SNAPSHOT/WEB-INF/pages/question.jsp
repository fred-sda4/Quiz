<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="errorPage.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<spring:url value="/nextQuestion" var="url" htmlEscape="true"/>
<div class="container">
		<form:form id="form12" modelAttribute="question" method="post" action="${url}" class="form-signin">
	     <div class="form-group">
            <span>${message}</span>
                <div class="form-group row">
	                 <div class="form-heading col-md-9"> ${question.text}</div>
                </div>
                <c:forEach var="answer" items="${question.answers}">
                 <div class="form-group row">
                    <div class="col-xs-3"><input type="radio" id="answer" name="answer" value="${answer.id}"/></div>
                    <div class="col-md-6">${answer.text}</div>
                 </div>
                </c:forEach>
                <br/> 
                
             <input type="hidden" name="questionId" value="${question.id}"/>
             
			 <c:if test="${question.id > 1}">
			 	<input type="submit" name="action" value="Previous" class="btn btn-success" />
			 </c:if>
			
			 <c:if test="${question.id < 3}">
			 	<input type="submit" name="action" value="Next" class="btn btn-success" />
			 </c:if>
			
			 <input type="submit" name="action" value="Finish Quiz" class="btn btn-success" />
		</div>
	</form:form>
</div>